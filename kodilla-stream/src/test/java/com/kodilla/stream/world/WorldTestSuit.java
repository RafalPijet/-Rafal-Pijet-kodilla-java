package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuit {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        World world = new World();

        //When
        BigDecimal expectedResult = new BigDecimal("4404362591");
        BigDecimal resultFromWorld = world.getPeopleQuantity();

        //Then
        Assert.assertEquals(expectedResult, resultFromWorld);
    }
}
