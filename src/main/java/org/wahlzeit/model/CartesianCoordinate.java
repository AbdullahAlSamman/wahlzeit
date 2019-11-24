package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

    protected double x;
    protected double y;
    protected double z;

    /**
     * Constructor
     */
    public CartesianCoordinate(double x, double y, double z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    /**
     * calculate distance between two points using Cartesian distance
     *
     * @param xyz point.
     * @return distance between the points.
     **/
    public double getDistance(CartesianCoordinate xyz) {
        return Math.sqrt(Math.pow(this.getX() - xyz.getX(), 2) + Math.pow(this.getY() - xyz.getY(), 2) + Math.pow(this.getZ() - xyz.getZ(), 2));
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    /**
     * calculate distance between two points using Cartesian distance
     *
     * @param coordinate point.
     * @return distance between the points.
     **/
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        CartesianCoordinate c = coordinate.asCartesianCoordinate();
        return Math.sqrt(Math.pow(this.getX() - c.getX(), 2) + Math.pow(this.getY() - c.getY(), 2) + Math.pow(this.getZ() - c.getZ(), 2));
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        //not sure about the math
        return new SphericCoordinate(
                Math.sqrt(Math.pow(this.x, 2.0) + Math.pow(this.y, 2.0) + Math.pow(this.z, 2.0)),
                Math.sqrt(Math.pow(this.x, 2.0) + Math.pow(this.y, 2.0)),
                this.y);
    }

    @Override
    public double getCentralAngle() {
        return 0;
    }


}
