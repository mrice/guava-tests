package com.michaelrice.demo.motoring;

import com.google.common.base.Objects;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarTest {

    @Test
    public void testEquals() {
        String make = "Saab", model = "9-3";
        Car saab1 = Car.newCar(make, model),
            saab2 = Car.newCar(make, model);
        assertEquals(saab1, saab2);
    }

    @Test
    public void testHashCode() {
        String make = "Saab", model = "9-3";
        Car saab = Car.newCar(make, model);
        assertEquals(Objects.hashCode(make, model), saab.hashCode());
    }

    @Test
    public void testStaticInstanceMaker() {
        String make = "Saab", model = "9-3";
        Car saab1 = new Car(make, model);
        Car saab2 = Car.newCar(make, model);
        assertEquals(saab1, saab2);
    }

    @Test
    public void testGetters() {
        String make = "Saab", model = "9-3";
        Car saab = Car.newCar(make, model);
        assertEquals(make, saab.getMake());
        assertEquals(model, saab.getModel());
    }

    @Test(expected = NullPointerException.class)
    public void testNullPreconditionChecks() {
        Car nullCar = Car.newCar(null, null);
    }

    @Test
    public void testPreconditionValidArguments() {
        Car validCar = Car.newCar("saab", "9-3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPreconditionInvalidMakeArgument() {
        Car invalidCar = Car.newCar("to", "9-3");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testPreconditionInvalidModelArgument() {
        Car invalidCar = Car.newCar("saab", "to");
    }

    @Test
    public void testToStringNoPassengers() {
        assertEquals("Car{make=Saab, model=9-3}", Car.newCar("Saab", "9-3").toString());
    }

    @Test
    public void testToStringWithPassengers() {
        String make = "Saab", model = "9-3";
        String passenger1 = "michael", passenger2 = "mia";

        Car c = Car.newCar(make, model);
        c.addPassenger(PassengerPosition.DRIVER, Passenger.newPassenger("male", passenger1));
        c.addPassenger(PassengerPosition.FRONT_PASSENGER, Passenger.newPassenger("female", passenger2));

        String toString = c.toString();
        assertTrue(toString.contains(make));
        assertTrue(toString.contains(passenger1));
        assertTrue(toString.contains(passenger2));

    }

    @Test
    public void testSetNonNullPassenger() {
        Passenger michael = Passenger.newPassenger("male", "michael");
        Car saab = Car.newCar("saab", "9-3");
        saab.addPassenger(PassengerPosition.DRIVER, michael);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNullPassenger() {
        Car saab = Car.newCar("saab", "9-3");
        saab.addPassenger(PassengerPosition.DRIVER, null);
    }

    @Test
    public void testOptionalPassenger() {
        Car saab = Car.newCar("saab", "9-3");
        saab.addPassenger(PassengerPosition.DRIVER, Passenger.newPassenger("male", "michael"));
        assertTrue(saab.getPassenger(PassengerPosition.DRIVER).isPresent());
        assertTrue(saab.getPassenger(PassengerPosition.FRONT_PASSENGER).isPresent()==false);
    }

    @Test(expected = IllegalStateException.class)
    public void testDuplicatePassenger() {
        Car saab = Car.newCar("saab", "9-3");
        Passenger p = Passenger.newPassenger("male", "michael");
        Passenger q = Passenger.newPassenger("female", "mia");
        saab.addPassenger(PassengerPosition.FRONT_PASSENGER, p);
        saab.addPassenger(PassengerPosition.FRONT_PASSENGER, q);
    }
}
