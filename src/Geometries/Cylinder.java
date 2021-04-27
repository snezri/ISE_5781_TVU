package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class Cylinder extends Tube{
    double height;

    public Cylinder(Ray r , double rad, double height) {
        super(r,rad);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                '}';
    }


    @Override
    public Vector getNormal(Point3D p0) {
        return null;
    }
}
