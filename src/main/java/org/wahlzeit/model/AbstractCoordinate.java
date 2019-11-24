package org.wahlzeit.model;

import java.math.BigDecimal;

public abstract class AbstractCoordinate implements Coordinate {



    /**
     * isEqual compare two coordinate points if they are the same.
     *
     * @param coordinate point to compare with.
     * @return true if the points are equal.
     **/
    public boolean isEqual(Coordinate coordinate) {
        if (this instanceof CartesianCoordinate) {
            CartesianCoordinate newCoordinate = coordinate.asCartesianCoordinate();
            return doIsEqual(this.convertToBigD(this), this.convertToBigD(newCoordinate));
        } else if (this instanceof SphericCoordinate) {
            SphericCoordinate newCoordinate = coordinate.asSphericCoordinate();
            return doIsEqual(this.convertToBigD(this), this.convertToBigD(newCoordinate));
        }
        return doIsEqual(this.convertToBigD(this), this.convertToBigD(coordinate));
    }

    private boolean doIsEqual(BigDecimal[] pointA, BigDecimal[] pointB) {
        if (pointA[0].compareTo(pointB[0]) == 0.0)
            if (pointA[1].compareTo(pointB[1]) == 0.0)
                if (pointA[2].compareTo(pointB[2]) == 0.0)
                    return true;
        return false;
    }

    /**
     * convert values from double to BigDecimal
     *
     * @param xyz point
     * @return array of BigDecimal in order x,y,z
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
            return result;

        } else if (xyz instanceof SphericCoordinate) {
            SphericCoordinate sc = xyz.asSphericCoordinate();
            result = new BigDecimal[]{
                    new BigDecimal(sc.getPhi()),
                    new BigDecimal(sc.getTheta()),
                    new BigDecimal(sc.getRadius())
            };
            return result;
        }
        return result;
    }
}
