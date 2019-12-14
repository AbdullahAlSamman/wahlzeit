package org.wahlzeit.model;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CoordinateTest {

    @Test
    public void getDistance() throws CloneNotSupportedException, CoordinateException {

        CartesianCoordinate a = new CartesianCoordinate(new Value(2.0), new Value(0.0), new Value(1.0));
        CartesianCoordinate b = new CartesianCoordinate(new Value(-6.0), new Value(-5.0), new Value(-6.0));
        assertEquals(a.getCartesianDistance(b), 11.0, 0.8);

    }

    @Test
    public void getCartesianDistance() throws CloneNotSupportedException, CoordinateException {

        CartesianCoordinate a = new CartesianCoordinate(new Value(2.0), new Value(0.0), new Value(1.0));
        CartesianCoordinate b = new CartesianCoordinate(new Value(-6.0), new Value(-5.0), new Value(-6.0));
        assertEquals(a.getCartesianDistance(b), 11.0, 0.8);
    }

    @Test
    public void sphericIsEqual() throws CloneNotSupportedException, CoordinateException {
        SphericCoordinate a = null;
        SphericCoordinate b = null;

        a = new SphericCoordinate(new Value(2.011542), new Value(12.321215), new Value(3.555125));
        b = new SphericCoordinate(new Value(2.011542), new Value(12.321215), new Value(3.555125));
        assertTrue(a.isEqual(b));


        a = new SphericCoordinate(new Value(2.011542), new Value(12.321215), new Value(3.555125));
        b = new SphericCoordinate(new Value(2.011541), new Value(12.321215), new Value(3.555125));
        assertFalse(a.isEqual(b));
    }

    @Test
    public void cartesianIsEqual() throws CloneNotSupportedException, CoordinateException {
        CartesianCoordinate a = new CartesianCoordinate(new Value(2.011542), new Value(12.321215), new Value(3.555125));
        CartesianCoordinate b = new CartesianCoordinate(new Value(2.011542), new Value(12.321215), new Value(3.555125));
        assertTrue(a.isEqual(b));


        a = new CartesianCoordinate(new Value(2.011542), new Value(12.321215), new Value(3.555125));
        b = new CartesianCoordinate(new Value(3.011541), new Value(12.321215), new Value(3.555125));
//        assertFalse(b.isEqual(a));

    }

    @Test
    public void mixIsEqual() throws CoordinateException, CloneNotSupportedException {

        CartesianCoordinate a = new CartesianCoordinate(new Value(3.1192341054807553), new Value(-0.7803950016594408), new Value(-1.5166660813163957));
        SphericCoordinate b = new SphericCoordinate(new Value(2.011542), new Value(12.321215), new Value(3.555125));
        assertTrue(a.isEqual(b));

        a = new CartesianCoordinate(new Value(2.011542), new Value(12.321215), new Value(3.555125));
        b = new SphericCoordinate(new Value(12.980660771301823), new Value(12.484335797069424), new Value(12.321215));
        assertTrue(b.isEqual(a));


        a = new CartesianCoordinate(new Value(2.011542), new Value(12.321215), new Value(3.555125));
        b = new SphericCoordinate(new Value(2.011541), new Value(12.321215), new Value(3.555125));
        assertFalse(a.isEqual(b));
        assertFalse(b.isEqual(a));
    }
}