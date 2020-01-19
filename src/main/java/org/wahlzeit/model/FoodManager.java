package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;

public class FoodManager {
    private static FoodManager instance = null;
    private Map<String, FoodType> foodTypeMap;

    protected FoodManager() {
        foodTypeMap = new HashMap<>();
    }

    public synchronized static FoodManager getInstance() {
        if (instance == null)
            instance = new FoodManager();
        return instance;
    }

    public Food createFood() {
        return new Food();
    }

    public Food createFood(String name, String restaurant, double price, FoodType type) {
        return new Food(name, price, restaurant, type);
    }

    public FoodType createTypeInstance(String type, String parent) {
        FoodType ft;
        if (foodTypeMap.containsKey(type)) {
            return foodTypeMap.get(type);
        } else {
            if (checkParent(parent)) {
                ft = new FoodType(type, parent);
                foodTypeMap.put(type, ft);
            } else {
                foodTypeMap.put(parent, new FoodType(parent, ""));
                ft = new FoodType(type, parent);
                foodTypeMap.put(type, ft);
            }
        }
        return ft;
    }


    private boolean checkParent(String parent) {
        for (Map.Entry<String, FoodType> entry : foodTypeMap.entrySet()) {
            if (parent.equals(entry.getKey()))
                return true;
        }
        return false;
    }

    public boolean checkFoodType(String typeName) {
        if (foodTypeMap.containsKey(typeName))
            return true;
        return false;
    }

}
