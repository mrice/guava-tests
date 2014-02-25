package com.michaelrice.demo.motoring;

import com.google.common.base.Objects;
import com.google.common.base.Optional;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class Car {

    final String make;
    final String model;

    Map<PassengerPosition, Passenger> passengers = new HashMap<PassengerPosition, Passenger>();

    public static Car newCar(final String make, final String model) {
        checkNotNull(make, "Car cannot have a null make");
        checkNotNull(model, "Car cannot have a null model");
        checkArgument(make.length() >= 3, "Car's make cannot be less than three (3) characters; was: %s", make);
        checkArgument(model.length() >= 3, "Car's model cannot be less than three (3) characters; was: %s", model);
        return new Car(make, model);
    }

    Car(final String make, final String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void addPassenger(PassengerPosition position, Passenger passenger) {
        checkNotNull(passenger);
        checkState((!passengers.containsKey(position)), "There is already a passenger in the %s position (%s)",
                position, passengers.get(position));
        passengers.put(position, passenger);
    }

    public Optional<Passenger> getPassenger(PassengerPosition position) {
        if (passengers.containsKey(position) && passengers.get(position) != null)
            return Optional.of(passengers.get(position));
        else
            return Optional.absent();
    }

    //TODO revisit this to take into account passenger information
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

    //TODO revisit this to take into account passenger information
    @Override
    public int hashCode() {
        return Objects.hashCode(make, model);
    }

    @Override
    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper = stringHelper.add("make", make).add("model", model);
        for (PassengerPosition position : passengers.keySet()) {
            stringHelper.add(position.toString(), passengers.get(position));
        }
        return stringHelper.toString();
    }
}
