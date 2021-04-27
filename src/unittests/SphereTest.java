package unittests;

import Geometries.Sphere;
import Primitives.Point3D;
import Primitives.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class SphereTest {

    @Test
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        Sphere sph = new Sphere(new Point3D(0, 0, 1),1.0);
        assertEquals( "It is not the sphere's normal",new Vector(0, 0, 1), sph.getNormal(new Point3D(0, 0, 2)));
    }
}