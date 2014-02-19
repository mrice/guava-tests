package com.michaelrice.demo.motoring;

import com.google.common.base.Objects;

public class Car {
    final String make;
    final String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(make, model);
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equal(this, obj);
    }
}
