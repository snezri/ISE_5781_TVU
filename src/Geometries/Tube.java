package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.List;

import static Primitives.Util.alignZero;
import static Primitives.Util.isZero;

public class Tube implements Geometry{
    Ray axisRay;
    double radius;

    public Tube(Ray R, double rad){
        this.axisRay=R;
        this.radius=rad;
    }

    public Ray getAxisRay() {
        return axisRay;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Tube{" +
                "axisRay=" + axisRay +
                ", radius=" + radius +
                '}';
    }


    @Override
    public Vector getNormal(Point3D p) {
        Point3D P0 = axisRay.getPoint3D();
        Vector v = axisRay.getDir();
        Vector P0_P = p.substract(P0);
        double t = alignZero(v.dotProduct(P0_P));
        if (isZero(t)) {
            return P0_P.normalize();
        }
        Point3D o = P0.add(v.scale(t));
        if (p.equals(o)) {
            throw new IllegalArgumentException("point can't be on the tube axis");
        }
        Vector n = p.substract(o).normalize();
        return n;
    }

    /**
     * @param ray
     * @return
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Vector vAxis = axisRay.getDir();
        Vector v = ray.getDir();
        Point3D p0 = ray.getPoint3D();

        // At^2+Bt+C=0
        double a = 0;
        double b = 0;
        double c = 0;

        double vVa = alignZero(v.dotProduct(vAxis));
        Vector vVaVa;
        Vector vMinusVVaVa;
        if (vVa == 0) // the ray is orthogonal to the axis
            vMinusVVaVa = v;
        else {
            vVaVa = vAxis.scale(vVa);
            try {
                vMinusVVaVa = v.substract(vVaVa);
            } catch (IllegalArgumentException e1) { // the rays is parallel to axis
                return null;
            }
        }
        // A = (v-(v*va)*va)^2
        a = vMinusVVaVa.lengthSquared();

        Vector deltaP = null;
        try {
            deltaP = p0.substract(axisRay.getPoint3D());
        } catch (IllegalArgumentException e1) { // the ray begins at axis P0
            if (vVa == 0) // the ray is orthogonal to Axis
                return List.of(ray.getPoint(radius));

            double t = alignZero(Math.sqrt(radius * radius / vMinusVVaVa.lengthSquared()));
            return t == 0 ? null : List.of(ray.getPoint(t));
        }

        double dPVAxis = alignZero(deltaP.dotProduct(vAxis));
        Vector dPVaVa;
        Vector dPMinusdPVaVa;
        if (dPVAxis == 0)
            dPMinusdPVaVa = deltaP;
        else {
            dPVaVa = vAxis.scale(dPVAxis);
            try {
                dPMinusdPVaVa = deltaP.substract(dPVaVa);
            } catch (IllegalArgumentException e1) {
                double t = alignZero(Math.sqrt(radius * radius / a));
                return t == 0 ? null : List.of(ray.getPoint(t));
            }
        }

        // B = 2(v - (v*va)*va) * (dp - (dp*va)*va))
        b = 2 * alignZero(vMinusVVaVa.dotProduct(dPMinusdPVaVa));
        c = dPMinusdPVaVa.lengthSquared() - radius * radius;

        // A*t^2 + B*t + C = 0 - lets resolve it
        double discr = alignZero(b * b - 4 * a * c);
        if (discr <= 0) return null; // the ray is outside or tangent to the tube

        double doubleA = 2 * a;
        double tm = alignZero(-b / doubleA);
        double th = Math.sqrt(discr) / doubleA;
        if (isZero(th)) return null; // the ray is tangent to the tube

        double t1 = alignZero(tm + th);
        if (t1 <= 0) // t1 is behind the head
            return null; // since th must be positive (sqrt), t2 must be non-positive as t1

        double t2 = alignZero(tm - th);

        // if both t1 and t2 are positive
        if (t2 > 0)
            return List.of(ray.getPoint(t1), ray.getPoint(t2));
        else // t2 is behind the head
            return List.of(ray.getPoint(t1));

//        return null;
    }
}
