package unittests;

import Geometries.Plane;
import Primitives.Point3D;
import Primitives.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaneTests {
    /**
     * Test method for {@link Geometries.Plane#getNormal(Primitives.Point3D)}.
     */
    @Test
    public void testGetNormalPlane() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Plane p = new Plane(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals("It is not the plane's normal",new Vector(sqrt3, sqrt3, sqrt3), p.getNormal(new Point3D(0, 0, 1)));
    }

    @Test
    public void testConstructor(){
        // ============ Equivalence Partitions Tests ==============
        Plane P=new Plane(new Point3D(1,0,0),new Point3D(0,1,0),new Point3D(0,0,1));
        // =============== Boundary Values Tests ==================
        //TC01: The first and second point are the same
        Point3D p1=new Point3D(1,0,0);
        Point3D p2=new Point3D(2,0,0);
        Point3D p3=new Point3D(4,0,0);
        try{
            Plane Pl=new Plane(p1,p1,p3);
            fail("can't create a plane with only two points");

        } catch (IllegalArgumentException e) {}
        //TC10: The three points are on the same line
        try{
            Plane Pl=new Plane(p1,p2,p3);
            fail("can't create a plane because the three points are on the same line");

        } catch (IllegalArgumentException e) {}



    }
}