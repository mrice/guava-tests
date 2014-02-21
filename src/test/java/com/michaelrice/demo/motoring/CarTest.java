package com.michaelrice.demo.motoring;

import com.google.common.base.Objects;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {

    @Test
    public void testEquals() {
        String make = "Saab", model = "9-3";
        Car saab1 = new Car(make, model),
            saab2 = new Car(make, model);
        assertEquals(saab1, saab2);
    }

    @Test
    public void testHashCode() {
        String make = "Saab", model = "9-3";
        Car saab = new Car(make, model);
        assertEquals(Objects.hashCode(make, model), saab.hashCode());
    }

    @Test(expected = NullPointerException.class)
    public void testNullPreconditionChecks() {
        Car nullCar = new Car(null, null);
    }

    @Test
    public void testPreconditionValidArguments() {
        Car validCar = new Car("saab", "9-3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPreconditionInvalidMakeArgument() {
        Car invalidCar = new Car("to", "9-3");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testPreconditionInvalidModelArgument() {
        Car invalidCar = new Car("saab", "to");
    }

    @Test
    public void testToString() {
        assertEquals("Car{make=Saab, model=9-3}", new Car("Saab", "9-3").toString());
    }

}
