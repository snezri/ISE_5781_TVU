package elements;

import Primitives.Color;

public class AmbientLight {

    final private Color intensity;

    /**
     * constructor - To get the intensity
     */
    public AmbientLight(Color Ia, double Ka) {
        intensity = Ia.scale(Ka);
    }

    /**
     * return the intensity
     */
    public Color getIntensity() {
        return intensity;
    }
}