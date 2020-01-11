package org.wahlzeit.model;

public class FoodPhoto extends Photo {

    private double price;
    private String restaurant;
    private String type;

    public String getType() throws FoodException {
        if (type == null)
            throw new FoodException(getClass().getName()+"getType", "type is null");
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() throws FoodException {
        if (Double.isNaN(price))
            throw new FoodException("FoodPhoto.getPrice", "price is null");
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRestaurant() throws FoodException {
        if (restaurant == null)
            throw new FoodException("FoodPhoto.getRestaurant", "restaurant is null");
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
        super(id);
    }
}
