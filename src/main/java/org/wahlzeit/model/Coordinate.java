package org.wahlzeit.model;

import java.math.BigDecimal;

public class Coordinate {

    protected double x;
    protected double y;
    protected double z;

    /**
     * Constructor
     */
    public Coordinate(double x, double y, double z) {
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
     * @param coordinate point.
     * @return distance between the points.
     **/
    public double getDistance(Coordinate xyz) {
        return Math.sqrt(Math.pow(this.getX() - xyz.getX(), 2) + Math.pow(this.getY() - xyz.getY(), 2) + Math.pow(this.getZ() - xyz.getZ(), 2));
    }

    /**
     * isEqual compare two coordinate points if they are the same.
     *
     * @param coordinate point to compare with.
     * @return true if the points are equal.
     **/
    public boolean isEqual(Coordinate xyz) {
        BigDecimal[] pointA = this.convertToBigD(xyz);
        BigDecimal[] pointB = this.convertToBigD(this);
        if (pointA[0].compareTo(pointB[0]) == 0)
            if (pointA[1].compareTo(pointB[1]) == 0)
                if (pointA[2].compareTo(pointB[2]) == 0)
                    return true;
        return false;
    }

    /**
     * convert values from double to BigDecimal
     *
     * @param Coordinate point
     * @return array of BigDecimal in order x,y,z
     **/
    private BigDecimal[] convertToBigD(Coordinate xyz) {
        BigDecimal[] result = {
                new BigDecimal(xyz.getX()),
                new BigDecimal(xyz.getY()),
                new BigDecimal(xyz.getZ())
        };
        return result;
    }
}
