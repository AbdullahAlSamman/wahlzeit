package org.wahlzeit.model;

public interface Coordinate {
    public CartesianCoordinate asCartesianCoordinate() throws CoordinateException;

    public SphericCoordinate asSphericCoordinate() throws CoordinateException;

    public double getCentralAngle();

    public double getCartesianDistance(Coordinate coordinate) throws CoordinateException;

    boolean isEqual(Coordinate coordinate) throws CoordinateException;

    void assertClassInvariants();
}
