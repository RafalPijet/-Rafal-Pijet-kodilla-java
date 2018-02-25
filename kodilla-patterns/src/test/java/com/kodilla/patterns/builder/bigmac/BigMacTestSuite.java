package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;

public class BigMacTestSuite {
    @Test
    public void testBuildBigMacFirstVersion() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .giveRoll(BigMac.YES)
                .giveIngredients(BigMac.CHEESE)
                .giveBurgers(5)
                .giveIngredients(BigMac.ONION)
                .giveIngredients(BigMac.SHRIMP)
                .giveSauce(BigMac.THOUSAND_ISLAND)
                .giveIngredients(BigMac.CUCUMBER)
                .build();
        System.out.println(bigMac);
        System.out.println();
        //When
        String result = "";
        for (String ingredient : bigMac.getIngredients()) {
            if (ingredient == "ONION") {
                result = ingredient;
            }
        }
        //Then
        Assert.assertEquals(4, bigMac.getIngredients().size());
        Assert.assertEquals(5, bigMac.getBurgers());
        Assert.assertTrue(bigMac.isSesame());
        Assert.assertEquals(BigMac.ONION, result);
        Assert.assertEquals(BigMac.THOUSAND_ISLAND, bigMac.getSauce());
    }
    @Test
    public void testBuildBigMacSecondVersion() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .giveRoll(BigMac.NO)
                .giveIngredients(BigMac.MUSHROOMS)
                .giveIngredients(BigMac.BACON)
                .giveSauce(BigMac.BARBECUE)
                .giveIngredients(BigMac.CHILLI)
                .giveIngredients(BigMac.SALAD)
                .build();
        System.out.println(bigMac);
        System.out.println();
        //When
        String result = bigMac.getIngredients().stream()
                .filter(i -> i.equals("BACON"))
                .collect(Collectors.joining());
        //Then
        Assert.assertEquals(4, bigMac.getIngredients().size());
        Assert.assertEquals(2, bigMac.getBurgers());
        Assert.assertFalse(bigMac.isSesame());
        Assert.assertEquals(BigMac.BACON, result);
        Assert.assertEquals(BigMac.BARBECUE, bigMac.getSauce());

    }
}
