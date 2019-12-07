package org.wahlzeit.model;

public class CoordinateException extends Exception {
    private String source;
    private String message;

    public CoordinateException(String src, String message) {
        super("Source: " + src + " , " + message);
        this.source = src;
        this.message = message;
    }

    @Override
    public String toString() {
        return "CoordinateException{" +
                "source='" + source + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
