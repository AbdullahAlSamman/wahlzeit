package org.wahlzeit.model;

import static junit.framework.TestCase.assertNotNull;

public class SphericCoordinate extends AbstractCoordinate {

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

        this.assertClassInvariants();

        CartesianCoordinate sc = new CartesianCoordinate(
                this.radius * Math.sin(this.phi) * Math.cos(this.theta),
                this.radius * Math.sin(this.phi) * Math.sin(this.theta),
                this.radius * Math.cos(this.phi)
        );
        assertNotNull(sc);
        sc.assertClassInvariants();

        return sc;
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        assertNotNull(coordinate);
        CartesianCoordinate pointA = this.asCartesianCoordinate();
        CartesianCoordinate pointB = coordinate.asCartesianCoordinate();
        return pointA.getCartesianDistance(pointB);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        assertClassInvariants();
        return this;

    }

    @Override
    public double getCentralAngle() {
        //TODO: lookup the math
        return 0;
    }

    @Override
    public void assertClassInvariants() {
        assertNotNull(getRadius());
        assertNotNull(getPhi());
        assertNotNull(getTheta());
    }
}
