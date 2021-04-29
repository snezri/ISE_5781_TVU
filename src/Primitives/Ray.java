package Primitives;


import static Primitives.Util.isZero;

public class Ray {
    Point3D p0;
    Vector dir;

    public Ray(Point3D p, Vector v){
        this.p0=p;
        this.dir=v.normalized();
    }

    public Point3D getPoint3D(){
        return p0;
    }

    public Vector getDir(){
        return dir;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Ray)) return false;
        Ray other = (Ray) obj;
        return p0.equals(other.p0) && dir.equals(other.dir);
    }

    @Override
    public String toString() {
        return "Ray{" +
                "p0=" + p0 +
                ", dir=" + dir +
                '}';
    }

    public Point3D getPoint(double delta ){
        if (isZero(delta)){
            return  p0;
        }
        return p0.add(dir.scale(delta));
    }

}
