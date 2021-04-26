package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

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
    public Vector getNormal(Point3D p0) {
        return null;
    }
}
