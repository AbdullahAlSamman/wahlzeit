package org.wahlzeit.model;

public class Food {
    private String name;
    private double price;
    private String restaurant;
    private FoodType type;

    public Food() {
    }

    public Food(String name, double price, String restaurant, FoodType type) {
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public FoodType getType() throws FoodException {
        if (type == null)
            throw new FoodException(getClass().getName() + ".getType", "type is null");
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public double getPrice() throws FoodException {
        if (Double.isNaN(price))
            throw new FoodException(getClass().getSimpleName() + ".getPrice", "price is null");
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRestaurant() throws FoodException {
        if (restaurant == null)
            throw new FoodException(getClass().getSimpleName() + ".getRestaurant", "restaurant is null");
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

}
