package Geometries;

import Primitives.Point3D;
import Primitives.Vector;

public class Cylinder implements Geometry{
    double height;

    public Cylinder(double height) {
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
