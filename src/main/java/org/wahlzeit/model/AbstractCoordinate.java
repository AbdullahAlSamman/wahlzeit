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
    public boolean isEqual(Coordinate coordinate) throws CoordinateException {

        assertNotNull(coordinate);

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

    private boolean doIsEqual(Double[] pointA, Double[] pointB) {

        assertNotNull(pointA);
        assertTrue(pointA.length == 3);

        assertNotNull(pointB);
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
    private Double[] convertToDoubleArray(Coordinate xyz) {
        Double[] result = null;

        assertNotNull(xyz);

        try {
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

            assertNotNull(result);
        } catch (CoordinateException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void assertClassInvariants() {
        // no class invariants to test in here
        return;
    }
}
