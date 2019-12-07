package org.wahlzeit.model;

public class Location {
    private Coordinate coordinate;

    /**
     * Constructor
     *
     * @param xyz coordinate object to initiate location class
     */
    public Location(Coordinate xyz) {
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
     * @param loc object
     * @return boolean true if they are equals
     */
    public boolean equals(Location loc) throws CoordinateException {
        return this.getCoordinate().isEqual(loc.getCoordinate());
    }
}
