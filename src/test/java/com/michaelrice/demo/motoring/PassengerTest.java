package com.michaelrice.demo.motoring;

import org.junit.Test;

public class PassengerTest {

    @Test
    public void testNonNullConstructor() {
        Passenger p = Passenger.newPassenger("michael", "male");
    }

    @Test(expected = NullPointerException.class)
    public void testNullConstructor() {
        Passenger p = Passenger.newPassenger(null, null);
    }

}
