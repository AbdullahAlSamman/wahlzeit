package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LocationTest {

    @Test
    public void testEquals() throws CoordinateException {
        try {
            Location locA = new Location(new CartesianCoordinate(new Value(2.011542), new Value(12.321215), new Value(3.555125)));
            Location locB = new Location(new CartesianCoordinate(new Value(2.011542), new Value(12.321215), new Value(3.555125)));
            assertTrue(locA.equals(locB));

            locA = new Location(new CartesianCoordinate(new Value(2.011542), new Value(12.321211), new Value(3.555125)));
            locB = new Location(new CartesianCoordinate(new Value(2.011542), new Value(12.321215), new Value(3.555125)));
            assertFalse(locA.equals(locB));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}