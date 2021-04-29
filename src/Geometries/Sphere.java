package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.List;

import static Primitives.Util.alignZero;

public class Sphere implements Geometry{
    Point3D center;
    double radius;

    public Sphere(Point3D p, double r){
        this.center=p;
        this.radius=r;
    }

    public Point3D getPoint3D(){
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    @Override
    public Vector getNormal(Point3D p0) {
        Vector v= p0.substract(center);
        return v.normalize();
    }

    /**
     * @param ray
     * @return
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Point3D P0 = ray.getPoint3D();
        Vector v = ray.getDir();

        if (P0.equals(center)) {
            return List.of(center.add(v.scale(radius)));
        }

        Vector U = center.substract(P0);

        double tm = alignZero(v.dotProduct(U));
        double d = alignZero(Math.sqrt(U.lengthSquared() - tm * tm));

        // no intersections : the ray direction is above the sphere
        if (d >= radius) {
            return null;
        }

        double th = alignZero(Math.sqrt(radius * radius - d * d));
        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);

        if (t1 > 0 && t2 > 0) {
//            Point3D P1 = P0.add(v.scale(t1));
//            Point3D P2 = P0.add(v.scale(t2));
            Point3D P1 =ray.getPoint(t1);
            Point3D P2 =ray.getPoint(t2);
            return List.of(P1, P2);
        }
        if (t1 > 0) {
//            Point3D P1 = P0.add(v.scale(t1));
            Point3D P1 =ray.getPoint(t1);
            return List.of(P1);
        }
        if (t2 > 0) {
//            Point3D P2 = P0.add(v.scale(t2));
            Point3D P2 =ray.getPoint(t2);
            return List.of(P2);
        }
        return null;
    }
}
