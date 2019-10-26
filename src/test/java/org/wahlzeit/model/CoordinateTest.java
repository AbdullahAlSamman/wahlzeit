package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {

    @Test
    public void getDistance() {
        Coordinate a = new Coordinate(2.0, 0.0, 1.0);
        Coordinate b = new Coordinate(-6.0, -5.0, -6.0);
        assertEquals(a.getDistance(b), 11.0, 0.8);
    }

    @Test
    public void isEqual() {
        Coordinate a = new Coordinate(2.011542, 12.321215, 3.555125);
        Coordinate b = new Coordinate(2.011542, 12.321215, 3.555125);
        assertTrue(a.isEqual(b));

        a = new Coordinate(2.011542, 12.321215, 3.555125);
        b = new Coordinate(2.011541, 12.321215, 3.555125);
        assertFalse(a.isEqual(b));
    }
}