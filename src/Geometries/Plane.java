package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.List;

import static Primitives.Util.alignZero;
import static Primitives.Util.isZero;


public class Plane implements Geometry {
    Point3D p0;
    Vector normal;

    public Plane(Point3D p1, Point3D p2, Point3D p3){
        this.p0=p1;
        Vector v1= p2.substract(p1);
        Vector v2=p3.substract(p2);
        normal=(v1.crossProduct(v2)).normalize();
    }

    public Plane(Point3D p, Vector v){
        this.p0=p;
        this.normal=v;
    }

    public Point3D getPoint3D(){ return p0;}
    public Vector getVector(){ return normal;}

    @Override
    public String toString() {
        return "Plane{" +
                "p0=" + p0 +
                ", normal=" + normal +
                '}';
    }

    @Override
    public Vector getNormal(Point3D p) {
        return this.normal;
    }

    public Vector getNormal() { return null;}

    /**
     * @param ray
     * @return
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Point3D P0 = ray.getPoint3D();
        Vector v = ray.getDir();
        Vector n = normal;
        if(p0.equals(P0)){
            return  null;
        }
        Vector P0_Q0 = p0.substract(P0);
        //numerator
        double nP0Q0  = alignZero(n.dotProduct(P0_Q0));
        if (isZero(nP0Q0 )){
            return null;
        }
        //denominator
        double nv = alignZero(n.dotProduct(v));
        // ray is lying in the plane axis
        if(isZero(nv)){
            return null;
        }
        double  t = alignZero(nP0Q0  / nv);
        if (t <=0){
            return  null;
        }
        Point3D point = ray.getPoint(t);
        return List.of(point);
    }
}
