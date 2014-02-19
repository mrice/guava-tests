package com.michaelrice.demo.motoring;

import com.google.common.base.Objects;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {

    @Test
    public void testHashCode() {
        String make = "Saab";
        String model = "9-3";
        Car saab = new Car(make, model);
        int independentHash = Objects.hashCode(make, model);
        int saabHash = saab.hashCode();
        assertEquals(independentHash, saabHash);
    }

}
