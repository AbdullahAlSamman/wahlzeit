package org.wahlzeit.model;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class CartesianCoordinate extends AbstractCoordinate {

    private final Value x;
    private final Value y;
    private final Value z;

    public Value getX() throws CloneNotSupportedException {
        return (Value) z.clone();
    }

    public Value getY() throws CloneNotSupportedException {
        return (Value) y.clone();
    }

    public Value getZ() throws CloneNotSupportedException {
        return (Value) z.clone();
    }


    /**
     * Constructor
     */
    public CartesianCoordinate(Value x, Value y, Value z) throws CloneNotSupportedException {
        this.x = (Value) x.clone();
        this.y = (Value) y.clone();
        this.z = (Value) z.clone();
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
    public double getCartesianDistance(Coordinate coordinate) throws CoordinateException, CloneNotSupportedException {
        this.assertClassInvariants();
        if (coordinate == null)
            throw new CoordinateException(getClass().getName() + " .getCartesianDistance", "coordinate pram is null");

        CartesianCoordinate c = coordinate.asCartesianCoordinate();
        assertNotNull(c);
        c.assertClassInvariants();

        double result = Math.sqrt(Math.pow(this.getX().getValue() - c.getX().getValue(), 2) + Math.pow(this.getY().getValue() - c.getY().getValue(), 2) + Math.pow(this.getZ().getValue() - c.getZ().getValue(), 2));

        assertTrue(Math.abs(result) >= 0); //Logical check if the distance is bigger than zero
        return result;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() throws CloneNotSupportedException {
        //not sure about the math
        this.assertClassInvariants();

        SphericCoordinate sc = new SphericCoordinate(
                new Value(Math.sqrt(Math.pow(this.x.getValue(), 2.0) + Math.pow(this.y.getValue(), 2.0) + Math.pow(this.z.getValue(), 2.0))),
                new Value(Math.sqrt(Math.pow(this.x.getValue(), 2.0) + Math.pow(this.y.getValue(), 2.0))),
                new Value(this.y.getValue()));

        assertNotNull(sc);
        sc.assertClassInvariants();

        return sc;
    }

    @Override
    public double getCentralAngle() {
        return 0;
    }

    @Override
    public void assertClassInvariants() throws CloneNotSupportedException {
        assertNotNull(getX());
        assertNotNull(getY());
        assertNotNull(getZ());
    }
}
