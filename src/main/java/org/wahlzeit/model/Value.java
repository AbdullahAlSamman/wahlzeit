package org.wahlzeit.model;

public class Value implements Cloneable {

    private double Value;

    public Value(double value) {
        Value = value;
    }

    public double getValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
