package org.wahlzeit.model;

public class FoodPhoto extends Photo {

    private Food food;
    private FoodManager foodManager;


    /**
     * Constructor
     */
    public FoodPhoto() {
        super();
        foodManagerInit();
    }

    /**
     * Constructor
     */
    public FoodPhoto(PhotoId id) {
        super(id);
        foodManagerInit();
    }

    public void foodManagerInit() {
        foodManager = FoodManager.getInstance();
    }
}
