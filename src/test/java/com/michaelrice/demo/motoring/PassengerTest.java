package com.michaelrice.demo.motoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    @Test
    public void testNonNullConstructor() {
        Passenger p = Passenger.newPassenger("michael", "male");
    }

    @Test(expected = NullPointerException.class)
    public void testNullConstructor() {
        Passenger p = Passenger.newPassenger(null, null);
    }

    @Test
    public void testNewPassenger() {
        String gender = "male", name = "michael";
        Passenger p = Passenger.newPassenger(gender, name);
        assertEquals(gender, p.getGender());
        assertEquals(name, p.getName());
    }
}
