package unittests;

import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void testGetNormal() {
          // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Triangle Tr = new Triangle(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals("It is not the triangle's normal",new Vector(sqrt3, sqrt3, sqrt3), Tr.getNormal(new Point3D(0, 0, 1)));
    }

}