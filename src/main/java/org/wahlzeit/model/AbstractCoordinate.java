package org.wahlzeit.model;

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
            return doIsEqual(this.convertToDoubleArray(this), this.convertToDoubleArray(newCoordinate));
        } else if (this instanceof SphericCoordinate) {
            SphericCoordinate newCoordinate = coordinate.asSphericCoordinate();
            return doIsEqual(this.convertToDoubleArray(this), this.convertToDoubleArray(newCoordinate));
        }
        return doIsEqual(this.convertToDoubleArray(this), this.convertToDoubleArray(coordinate));
    }

    private boolean doIsEqual(Double[] pointA, Double[] pointB) {
        if (pointA[0].compareTo(pointB[0]) != 0.0)
            return false;
        if (pointA[1].compareTo(pointB[1]) != 0.0)
            return false;
        if (pointA[2].compareTo(pointB[2]) != 0.0)
            return false;
        return true;
    }

    /**
     * convert values from double to BigDecimal
     *
     * @param xyz point
     * @return array of BigDecimal in order x,y,z
     **/
    private Double[] convertToDoubleArray(Coordinate xyz) {
        Double[] result = null;
        if (xyz instanceof CartesianCoordinate) {
            CartesianCoordinate cc = xyz.asCartesianCoordinate();
            result = new Double[]{
                    cc.getX(),
                    cc.getY(),
                    cc.getZ()
            };
        } else if (xyz instanceof SphericCoordinate) {
            SphericCoordinate sc = xyz.asSphericCoordinate();
            result = new Double[]{
                    sc.getPhi(),
                    sc.getTheta(),
                    sc.getRadius()
            };
        }
        return result;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
