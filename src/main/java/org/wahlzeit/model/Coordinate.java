package org.wahlzeit.model;

public interface Coordinate {
    public CartesianCoordinate asCartesianCoordinate() throws CoordinateException, CloneNotSupportedException;

    public SphericCoordinate asSphericCoordinate() throws CoordinateException, CloneNotSupportedException;

    public double getCentralAngle();

    public double getCartesianDistance(Coordinate coordinate) throws CoordinateException, CloneNotSupportedException;

    boolean isEqual(Coordinate coordinate) throws CoordinateException, CloneNotSupportedException;

    void assertClassInvariants() throws CloneNotSupportedException;
}
