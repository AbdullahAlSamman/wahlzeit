package org.wahlzeit.model;


import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public abstract class AbstractCoordinate implements Coordinate {

    /**
     * isEqual compare two coordinate points if they are the same.
     *
     * @param coordinate point to compare with.
     * @return true if the points are equal.
     **/
    public boolean isEqual(Coordinate coordinate) throws CoordinateException, CloneNotSupportedException {

        if (coordinate == null)
            throw new CoordinateException("AbstractCoordinate.isEqual", "coordinate param is null");

        if (this instanceof CartesianCoordinate) {
            CartesianCoordinate newCoordinate = coordinate.asCartesianCoordinate();
            newCoordinate.assertClassInvariants();
            assertNotNull(newCoordinate);

            return doIsEqual(this.convertToDoubleArray(this), this.convertToDoubleArray(newCoordinate));
        } else if (this instanceof SphericCoordinate) {
            SphericCoordinate newCoordinate = coordinate.asSphericCoordinate();
            newCoordinate.assertClassInvariants();
            assertNotNull(newCoordinate);

            return doIsEqual(this.convertToDoubleArray(this), this.convertToDoubleArray(newCoordinate));
        }
        return doIsEqual(this.convertToDoubleArray(this), this.convertToDoubleArray(coordinate));
    }

    private boolean doIsEqual(Double[] pointA, Double[] pointB) throws CoordinateException {


        if (pointA == null || pointA.length > 3 || pointA.length < 3)
            throw new CoordinateException("AbstractCoordinate.doIsEqual", "point A param is null or has less or more values");
        assertTrue(pointA.length == 3);

        if (pointB == null || pointB.length > 3 || pointB.length < 3)
            throw new CoordinateException("AbstractCoordinate.doIsEqual", "point b param is null or has less or more values");
        assertTrue(pointB.length == 3);

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
    private Double[] convertToDoubleArray(Coordinate xyz) throws CoordinateException, CloneNotSupportedException {
        Double[] result = null;

        if (xyz == null)
            throw new CoordinateException("AbstractCoordinate.convertToDoubleArray", "coordinate param is null");

        if (xyz instanceof CartesianCoordinate) {
            CartesianCoordinate cc = xyz.asCartesianCoordinate();
            result = new Double[]{
                    cc.getX().getValue(),
                    cc.getY().getValue(),
                    cc.getZ().getValue()
            };
        } else if (xyz instanceof SphericCoordinate) {
            SphericCoordinate sc = xyz.asSphericCoordinate();
            result = new Double[]{
                    sc.getPhi().getValue(),
                    sc.getTheta().getValue(),
                    sc.getRadius().getValue()
            };
        }

        if (result == null)
            throw new CoordinateException("AbstractCoordinate.convertToDoubleArray", "result is null");

        return result;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void assertClassInvariants() throws CloneNotSupportedException {
        // no class invariants to test in here
        return;
    }
}
