package Geometries;

import Primitives.Point3D;
import Primitives.Ray;

import java.lang.reflect.Array;
import java.util.*;

public class Geometries implements Intersectable {

    private List<Intersectable> listGeo;

    public Geometries() {
        listGeo = new ArrayList<Intersectable>();
    }

    public Geometries(Intersectable... intersectables) {
        add(intersectables);
    }

    public void add(Intersectable... intersectables) {
        for(int i=0; i<intersectables.length;i++){
            listGeo.add(intersectables[i]);
        }
    }


    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> result = null;
        if(listGeo==null){
            return null;
        }
        for (int i=0; i<listGeo.size();i++) {
            //get intersections points of a particular item from listGeo
            if (listGeo.get(i).findIntersections(ray) != null) {
                //first time initialize result to new LinkedList
                if (result == null) {
                    result = new ArrayList<>();
                }
                for(int k=0; k<listGeo.get(i).findIntersections(ray).size();k++)
                //add all item points to the resulting list
                result.addAll((Collection<? extends Point3D>) listGeo.get(i).findIntersections(ray).get(k));
            }

        }

        return result;
    }

}