package org.wahlzeit.model;

public class FoodPhoto extends Photo {

    private double price;
    private String restaurant;
    private String type;

    public String getType() throws FoodException {
        if(type == null)
            throw new FoodException("");
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * Constructor
     */
    public FoodPhoto() {
        super();
    }

    /**
     * Constructor
     */
    public FoodPhoto(PhotoId id) {
        super();
    }
}
