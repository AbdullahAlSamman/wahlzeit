package org.wahlzeit.model;

public class Location {
    private Coordinate coordinate;

    /**
     * Constructor
     *
     * @param coordinate object to initiate location class
     */
    public Location(CartesianCoordinate xyz) {
        this.setCoordinate(xyz);
    }

    /**
     * @methodtype get
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * @methodtype set
     */
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * check if location coordinates are equals
     *
     * @param Location object
     * @return boolean true if they are equals
     */
    public boolean equals(Location loc) {
        return this.getCoordinate().isEqual(loc.getCoordinate());
    }
}
