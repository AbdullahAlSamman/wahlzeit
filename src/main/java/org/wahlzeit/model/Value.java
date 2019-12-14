package org.wahlzeit.model;

public class Value implements Cloneable {

    public Double getValue() {
        return Value;
    }

    public void setValue(Double value) {
        Value = value;
    }

    private Double Value;

    public Value(Double value) {
        Value = value;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Value obj) {
        if (this.getValue().compareTo(obj.getValue()) == 0.0)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
