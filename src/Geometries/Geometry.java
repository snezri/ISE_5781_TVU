package Geometries;
import Primitives.Point3D;
import Primitives.Vector;

public interface Geometry extends Intersectable{
    public Vector getNormal(Point3D p0);

}
