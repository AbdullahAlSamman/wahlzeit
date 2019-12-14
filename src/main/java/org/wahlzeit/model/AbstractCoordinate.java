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
            throw new CoordinateException(getClass().getName() + ".isEqual", "coordinate param is null");

        if (this instanceof CartesianCoordinate) {
            CartesianCoordinate newCoordinate = coordinate.asCartesianCoordinate();
            newCoordinate.assertClassInvariants();
            assertNotNull(newCoordinate);

            return doIsEqual(this.convertToValueArray(this), this.convertToValueArray(newCoordinate));
        } else if (this instanceof SphericCoordinate) {
            SphericCoordinate newCoordinate = coordinate.asSphericCoordinate();
            newCoordinate.assertClassInvariants();
            assertNotNull(newCoordinate);

            return doIsEqual(this.convertToValueArray(this), this.convertToValueArray(newCoordinate));
        }
        return doIsEqual(this.convertToValueArray(this), this.convertToValueArray(coordinate));
    }

    private boolean doIsEqual(Value[] pointA, Value[] pointB) throws CoordinateException {


        if (pointA == null || pointA.length > 3 || pointA.length < 3)
            throw new CoordinateException(getClass().getName() + ".doIsEqual", "point A param is null or has less or more values");
        assertTrue(pointA.length == 3);

        if (pointB == null || pointB.length > 3 || pointB.length < 3)
            throw new CoordinateException(getClass().getName() + ".doIsEqual", "point b param is null or has less or more values");
        assertTrue(pointB.length == 3);

        for (int i = 0; i < 3; i++) {
            if (!pointA[i].equals(pointB[i]))
                return false;
        }
        return true;
    }

    /**
     * convert values from double to BigDecimal
     *
     * @param xyz point
     * @return array of BigDecimal in order x,y,z
     **/
    private Value[] convertToValueArray(Coordinate xyz) throws CoordinateException, CloneNotSupportedException {
        Value[] result = null;

        if (xyz == null)
            throw new CoordinateException(getClass().getName() + ".convertToDoubleArray", "coordinate param is null");

        if (xyz instanceof CartesianCoordinate) {
            CartesianCoordinate cc = xyz.asCartesianCoordinate();
            result = new Value[]{
                    cc.getX(),
                    cc.getY(),
                    cc.getZ()
            };
        } else if (xyz instanceof SphericCoordinate) {
            SphericCoordinate sc = xyz.asSphericCoordinate();
            result = new Value[]{
                    sc.getPhi(),
                    sc.getTheta(),
                    sc.getRadius()
            };
        }

        if (result == null)
            throw new CoordinateException(getClass().getName() + ".convertToDoubleArray", "result is null");

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
