package org.wahlzeit.model;

public class Location {
    private CartesianCoordinate cartesianCoordinate;

    /**
     * Constructor
     *
     * @param coordinate object to initiate location class
     */
    public Location(CartesianCoordinate xyz) {
        this.setCartesianCoordinate(xyz);
    }

    /**
     * @methodtype get
     */
    public CartesianCoordinate getCartesianCoordinate() {
        return cartesianCoordinate;
    }

    /**
     * @methodtype set
     */
    public void setCartesianCoordinate(CartesianCoordinate cartesianCoordinate) {
        this.cartesianCoordinate = cartesianCoordinate;
    }

    /**
     * check if location coordinates are equals
     *
     * @param Location object
     * @return boolean true if they are equals
     */
    public boolean equals(Location loc) {
        return this.getCartesianCoordinate().isEqual(loc.getCartesianCoordinate());
    }
}
