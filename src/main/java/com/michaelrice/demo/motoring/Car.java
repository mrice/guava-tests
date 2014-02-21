package com.michaelrice.demo.motoring;

import com.google.common.base.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Car {
    final String make;
    final String model;

    public Car(final String make, final String model) {
        this.make = checkNotNull(make, "Car cannot have a null make");
        checkArgument(make.length() >= 3, "Car's make cannot be less than three (3) characters. Was: %s", make);
        this.model = checkNotNull(model, "Car cannot have a null model");
        checkArgument(model.length() >= 3, "Car's model cannot be less than three (3) characters. Was: %s", model);
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

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("make", make)
                .add("model", model)
                .toString();
    }
}
