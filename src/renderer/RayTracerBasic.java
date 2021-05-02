package renderer;

import Primitives.Color;
import Primitives.Point3D;
import Primitives.Ray;
import scene.Scene;


import java.util.List;

/**
 *  RayTracerBasic class inherits from RayTracerBase
 */
public class RayTracerBasic extends RayTracerBase{
    /**
     * RayTracerBasic constructor receives a scene and calls the father's constructor
     * @param scene
     */
    public RayTracerBasic(Scene scene) {
        super(scene);
    }

    /**
     * The traceRay function looks for the intersections between the ray and the 3D model of the scene by using
     * the findIntersections function which is in the Intersectable interface.
     * if it doesn't find intersections then it will return the background color otherwise it searches the
     * closest point from the ray by using the function "findClosestPoint" that we created in the Ray class
     * and return the color of this point by using the function "calcColor"
     * @param ray
     * @return Color
     */

    @Override
    public Color traceRay(Ray ray) {
        List<Point3D> intersections = scene.geometries.findIntersections(ray);
        if (intersections != null) {
            Point3D closestPoint = ray.findClosestPoint(intersections);
            return calcColor(closestPoint);
        }
        //ray did not intersect any geometrical object
        return scene.background;

    }

    /**
     *The calcColor function receives a point and returns the color at this point
     * @param point
     * @return Color
     */

    private Color calcColor(Point3D point) {
        return scene.ambientLight.getIntensity();
    }
}
