package scene;

import Geometries.Geometries;
import Primitives.Color;
import elements.AmbientLight;


/**
 * The Scene class is a PDS (Passive Data Structure) means it is here only to keep the elements.
 * That's why all the attributes are public. There are no getter functions.
 */
public class Scene {
    String name;
    public Color background=Color.BLACK;
    public AmbientLight ambientLight=new AmbientLight(new Color(192, 192, 192),1.d); ;
    public Geometries geometries=null;

    /**
     * Scene constructor- Receives the scene's name and create an empty group of forms 3D models
     * @param name
     */
    public Scene(String name) {
        this.name = name;
        geometries=new Geometries();
    }

    /**
     *
     * @param background
     * @return
     */
    public Scene setBackground(Color background) {
        this.background = background;
        return this;
    }

    /**
     *
     * @param ambientLight
     * @return
     */
    public Scene setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }

    /**
     *
     * @param geometries
     * @return
     */
    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }
}
