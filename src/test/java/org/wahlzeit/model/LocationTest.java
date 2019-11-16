package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LocationTest {

    @Test
    public void testEquals() {
        Location locA = new Location(new CartesianCoordinate(2.011542, 12.321215, 3.555125));
        Location locB = new Location(new CartesianCoordinate(2.011542, 12.321215, 3.555125));
        assertTrue(locA.equals(locB));

        locA = new Location(new CartesianCoordinate(2.011542, 12.321211, 3.555125));
        locB = new Location(new CartesianCoordinate(2.011542, 12.321215, 3.555125));
        assertFalse(locA.equals(locB));
    }
}