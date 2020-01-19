package org.wahlzeit.model;

public class FoodType {
    private String name;
    private String parent;

    public FoodType(String name) {
        this.name = name;
    }

    public FoodType(String name, String parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
