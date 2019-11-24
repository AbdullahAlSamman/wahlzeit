package org.wahlzeit.model;

public interface Coordinate {
    public CartesianCoordinate asCartesianCoordinate();

    public SphericCoordinate asSphericCoordinate();

    public double getCentralAngle();

    public double getCartesianDistance(Coordinate coordinate);

}
