package org.wahlzeit.model;

import java.math.BigDecimal;

public class SphericCoordinate implements Coordinate {

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private double phi;
    private double theta;
    private double radius;

    /**
     * Constructor
     */
    public SphericCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.radius = radius;
        this.theta = theta;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return new CartesianCoordinate(
                this.radius * Math.sin(this.phi) * Math.cos(this.theta),
                this.radius * Math.sin(this.phi) * Math.sin(this.theta),
                this.radius * Math.cos(this.phi)
        );
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return 0;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;

    }

    @Override
    public double getCentralAngle() {
        //TODO: lookup the math
        return 0;
    }

    /**
     * isEqual compare two coordinate points if they are the same.
     *
     * @param coordinate point to compare with.
     * @return true if the points are equal.
     **/
    @Override
    public boolean isEqual(Coordinate coordinate) {
        SphericCoordinate t = coordinate.asSphericCoordinate();
        return doIsEqual(this.convertToBigD(this), this.convertToBigD(t));
    }

    /**
     * convert values from double to BigDecimal
     *
     * @param xyz Coordinate point
     * @return array of BigDecimal in order x,y,z / phi,theta,radius
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
        } else if (xyz instanceof SphericCoordinate) {
            SphericCoordinate sc = xyz.asSphericCoordinate();
            result = new BigDecimal[]{
                    new BigDecimal(sc.getPhi()),
                    new BigDecimal(sc.getTheta()),
                    new BigDecimal(sc.getRadius())
            };
        }

        return result;
    }

    private boolean doIsEqual(BigDecimal[] pointA, BigDecimal[] pointB) {
        if (pointA[0].compareTo(pointB[0]) == 0.0)
            if (pointA[1].compareTo(pointB[1]) == 0.0)
                if (pointA[2].compareTo(pointB[2]) == 0.0)
                    return true;
        return false;
    }
}
