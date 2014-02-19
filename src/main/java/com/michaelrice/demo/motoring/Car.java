package com.michaelrice.demo.motoring;

import com.google.common.base.Objects;

public class Car {
    final String make;
    final String model;

    public Car(final String make, final String model) {
        this.make = make;
        this.model = model;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Car) {
            Car that = (Car)obj;
            return Objects.equal(this.make, that.make) &&
                   Objects.equal(this.model, this.model);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(make, model);
    }

}
