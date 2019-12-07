package org.wahlzeit.model;

public class FoodException extends Exception {
    private String source;
    private String message;

    public FoodException(String src, String message) {
        super("Source: " + src + " , " + message);
        this.source = src;
        this.message = message;
    }

    @Override
    public String toString() {
        return "FoodException{" +
                "source='" + source + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
