package elements;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import static Primitives.Util.isZero;

public class Camera {
    Point3D p0;
    private Vector vUp, vRight, vTo;
    double width, heigth, distance;

    public Camera(Point3D p0, Vector vUp, Vector vTo) {
        this.p0 = p0;
        if(vUp.dotProduct(vTo)!=0)
            throw new IllegalArgumentException("vUp and vTo are not orthogonals");
        this.vUp=vUp.normalized();
        this.vTo=vTo.normalized();
        this.vRight=(vUp.crossProduct(vTo)).normalized();
    }

    public Vector getvUp() { return vUp; }

    public Vector getvTo() { return vTo; }

    public Vector getvRight() { return vRight; }

    public Point3D getP0() { return p0;}

    public double getHeight(){return heigth;}
    public double getWidth(){return width;}
    public double getDistance(){return distance;}
    public Camera setViewPlaneSize(double width, double height){
        this.width=width;
        this.heigth=height;
        return this;
    }

    public Camera setDistance(double distance){
        this.distance=distance;
        return this;
    }

    public Ray constructRayThroughPixel(int nX, int nY, int j, int i) {
        Point3D Pc = p0.add(vTo.scale(distance));

        double Rx = width / nX;
        double Ry = heigth / nY;

        Point3D Pij = Pc;

        double Xj = (j - (nX - 1) / 2d) * Rx;
        double Yi = -(i - (nY - 1) / 2d) * Ry;

        if (isZero(Xj) && isZero(Yi)) {
            return new Ray(p0, Pij.substract(p0));
        }
        if (isZero(Xj)) {
            Pij = Pij.add(vUp.scale(Yi));
            return new Ray(p0, Pij.substract(p0));
        }
        if (isZero(Yi)) {
            Pij = Pij.add(vRight.scale(Xj));
            return new Ray(p0, Pij.substract(p0));
        }

        Pij = Pij.add(vRight.scale(Xj).add(vUp.scale(Yi)));
        return new Ray(p0, Pij.substract(p0));

    }
}
