package org.wahlzeit.model;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CoordinateTest {

    @Test
    public void getDistance() throws CoordinateException {
        CartesianCoordinate a = new CartesianCoordinate(2.0, 0.0, 1.0);
        CartesianCoordinate b = new CartesianCoordinate(-6.0, -5.0, -6.0);
        assertEquals(a.getCartesianDistance(b), 11.0, 0.8);
    }

    @Test
    public void getCartesianDistance() throws CoordinateException {
        CartesianCoordinate a = new CartesianCoordinate(2.0, 0.0, 1.0);
        CartesianCoordinate b = new CartesianCoordinate(-6.0, -5.0, -6.0);
        assertEquals(a.getCartesianDistance(b), 11.0, 0.8);
    }

    @Test
    public void sphericIsEqual() throws CoordinateException {
        SphericCoordinate a = new SphericCoordinate(2.011542, 12.321215, 3.555125);
        SphericCoordinate b = new SphericCoordinate(2.011542, 12.321215, 3.555125);
        assertTrue(a.isEqual(b));


        a = new SphericCoordinate(2.011542, 12.321215, 3.555125);
        b = new SphericCoordinate(2.011541, 12.321215, 3.555125);
        assertFalse(a.isEqual(b));
    }

    @Test
    public void cartesianIsEqual() throws CoordinateException {
        CartesianCoordinate a = new CartesianCoordinate(2.011542, 12.321215, 3.555125);
        CartesianCoordinate b = new CartesianCoordinate(2.011542, 12.321215, 3.555125);
        assertTrue(a.isEqual(b));


        a = new CartesianCoordinate(2.011542, 12.321215, 3.555125);
        b = new CartesianCoordinate(2.011541, 12.321215, 3.555125);
        assertFalse(a.isEqual(b));
    }

    @Test
    public void mixIsEqual() throws CoordinateException {
        CartesianCoordinate a = new CartesianCoordinate(3.1192341054807553, -0.7803950016594408, -1.5166660813163957);
        SphericCoordinate b = new SphericCoordinate(2.011542, 12.321215, 3.555125);
        assertTrue(a.isEqual(b));

        a = new CartesianCoordinate(2.011542, 12.321215, 3.555125);
        b = new SphericCoordinate(12.980660771301823, 12.484335797069424, 12.321215);
        assertTrue(b.isEqual(a));


        a = new CartesianCoordinate(2.011542, 12.321215, 3.555125);
        b = new SphericCoordinate(2.011541, 12.321215, 3.555125);
        assertFalse(a.isEqual(b));
        assertFalse(b.isEqual(a));
    }
}