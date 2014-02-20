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

}
