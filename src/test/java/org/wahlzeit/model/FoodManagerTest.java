package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;


public class FoodManagerTest {
    FoodManager foodManager;
    Food f;
    FoodType ft;

    @Before
    public void init() {
        foodManager = FoodManager.getInstance();
        assertNotNull(foodManager);
    }


    @Test
    public void foodCreate() throws FoodException {
        ft = foodManager.createTypeInstance("spicy", "hot");
        f = foodManager.createFood("pasta", "ItalyRestaurant", 10.99, ft);
        assertNotNull(f);
        assertNotNull(ft);
        assertEquals(f.getName(), "pasta");
        assertEquals(f.getRestaurant(), "ItalyRestaurant");
        assertEquals(f.getPrice(), 10.99, 0.0);
        assertEquals(f.getType().getParent(), "hot");
        assertEquals(f.getType().getName(), "spicy");
    }

    @Test
    public void foodManagerMapTest() {
        assertTrue(foodManager.checkFoodType("hot"));
        assertTrue(foodManager.checkFoodType("spicy"));
    }

}
