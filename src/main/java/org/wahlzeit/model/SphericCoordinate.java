package org.wahlzeit.model;

import static junit.framework.TestCase.assertNotNull;

public class SphericCoordinate extends AbstractCoordinate {

    private final Value phi;
    private final Value theta;
    private final Value radius;

    public Value getPhi() throws CloneNotSupportedException {
        return (Value) phi.clone();
    }

    public Value getTheta() throws CloneNotSupportedException {
        return (Value) theta.clone();
    }

    public Value getRadius() throws CloneNotSupportedException {
        return (Value) radius.clone();
    }


    /**
     * Constructor
     */
    public SphericCoordinate(Value phi, Value theta, Value radius) throws CloneNotSupportedException {
        this.phi = (Value) phi.clone();
        this.radius = (Value) radius.clone();
        this.theta = (Value) theta.clone();
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() throws CloneNotSupportedException {

        this.assertClassInvariants();

        CartesianCoordinate sc = new CartesianCoordinate(
                new Value(this.radius.getValue() * Math.sin(this.phi.getValue()) * Math.cos(this.theta.getValue())),
                new Value(this.radius.getValue() * Math.sin(this.phi.getValue()) * Math.sin(this.theta.getValue())),
                new Value(this.radius.getValue() * Math.cos(this.phi.getValue()))
        );
        assertNotNull(sc);
        sc.assertClassInvariants();

        return sc;
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) throws CoordinateException, CloneNotSupportedException {
        if (coordinate == null)
            throw new CoordinateException("SphericCoordinate.getCartesianDistance", "coordinate param is null");

        CartesianCoordinate pointA = this.asCartesianCoordinate();
        CartesianCoordinate pointB = coordinate.asCartesianCoordinate();
        return pointA.getCartesianDistance(pointB);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() throws CloneNotSupportedException {
        assertClassInvariants();
        return this;

    }

    @Override
    public double getCentralAngle() {
        //TODO: lookup the math
        return 0;
    }

    @Override
    public void assertClassInvariants() throws CloneNotSupportedException {
        assertNotNull(getRadius());
        assertNotNull(getPhi());
        assertNotNull(getTheta());
    }
}
