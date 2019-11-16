package org.wahlzeit.model;

import java.math.BigDecimal;

public class CartesianCoordinate implements Coordinate {

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

    /**
     * isEqual compare two coordinate points if they are the same.
     *
     * @param coordinate point to compare with.
     * @return true if the points are equal.
     **/
    @Override
    public boolean isEqual(Coordinate coordinate) {
        CartesianCoordinate t = coordinate.asCartesianCoordinate();
        return doIsEqual(this.convertToBigD(t), this.convertToBigD(this));
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

    private boolean doIsEqual(BigDecimal[] pointA, BigDecimal[] pointB) {
        if (pointA[0].compareTo(pointB[0]) == 0.0)
            if (pointA[1].compareTo(pointB[1]) == 0.0)
                if (pointA[2].compareTo(pointB[2]) == 0.0)
                    return true;
        return false;
    }

    /**
     * convert values from double to BigDecimal
     *
     * @param xyz point
     * @return array of BigDecimal in order x,y,z
     **/
    private BigDecimal[] convertToBigD(Coordinate xyz) {
        BigDecimal[] result = null;
        if (xyz instanceof CartesianCoordinate) {
            CartesianCoordinate cc = xyz.asCartesianCoordinate();
            result = new BigDecimal[]{
                    new BigDecimal(cc.getX()),
                    new BigDecimal(cc.getY()),
                    new BigDecimal(cc.getZ())
            };
            return result;

        } else if (xyz instanceof SphericCoordinate) {
            SphericCoordinate sc = xyz.asSphericCoordinate();
            result = new BigDecimal[]{
                    new BigDecimal(sc.getPhi()),
                    new BigDecimal(sc.getTheta()),
                    new BigDecimal(sc.getRadius())
            };
            return result;
        }
        return result;
    }

}
