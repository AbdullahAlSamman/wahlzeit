package org.wahlzeit.model;

public class FoodPhoto extends Photo {

    private double Price;
    private String Resturant;
    private String Type;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getResturant() {
        return Resturant;
    }

    public void setResturant(String resturant) {
        Resturant = resturant;
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
