package Geometries;

import Primitives.Point3D;
import Primitives.Vector;

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
        return null;
    }

}
