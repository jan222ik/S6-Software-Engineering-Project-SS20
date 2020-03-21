package com.github.maru999.dagger.example;

import org.junit.Assert;
import org.junit.Test;

public class VehicleTest {
    @Test
    public void givenGeneratedComponent_whenBuildingCar_thenDependenciesInjected() {
        VehiclesComponent component = DaggerVehiclesComponent.create();

        Car carOne = component.buildCar();
        Car carTwo = component.buildCar();

        Assert.assertNotNull(carOne);
        Assert.assertNotNull(carTwo);
        Assert.assertNotNull(carOne.getEngine());
        Assert.assertNotNull(carTwo.getEngine());
        Assert.assertNotNull(carOne.getBrand());
        Assert.assertNotNull(carTwo.getBrand());
        Assert.assertNotEquals(carOne.getEngine(), carTwo.getEngine());
        Assert.assertEquals(carOne.getBrand(), carTwo.getBrand());
    }
}
