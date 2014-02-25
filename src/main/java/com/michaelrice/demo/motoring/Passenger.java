package com.michaelrice.demo.motoring;

import com.google.common.base.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

public class Passenger {
    final String gender;
    final String name;

    public static Passenger newPassenger(final String gender, final String name) {
        checkNotNull(gender, "Gender of passenger cannot be null");
        checkNotNull(name, "Name of passenger cannot be null");
        return new Passenger(gender, name);
    }

    Passenger(final String gender, final String name) {
        this.gender = gender;
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("gender", gender)
                .toString();
    }

}
