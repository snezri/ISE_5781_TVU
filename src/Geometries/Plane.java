package Geometries;

import Primitives.Point3D;
import Primitives.Vector;


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
}
