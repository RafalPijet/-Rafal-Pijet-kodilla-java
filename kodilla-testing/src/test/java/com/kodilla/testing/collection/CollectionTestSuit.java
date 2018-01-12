package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuit {
    @Before
    public void before(){
        System.out.println("\nRozpoczęcie przypadku testowego");
    }
    @After
    public void after() {
        System.out.println("Zakończenie przypadku testowego");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("POCZĄTEK ZESTAWU TESTÓW");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("\nKONIEC ZESTAWU TESTÓW");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumberExterminator = new OddNumbersExterminator();
        ArrayList<Integer> emptyList = new ArrayList<Integer>();
        //When
        ArrayList<Integer> checkList = oddNumberExterminator.exterminate(emptyList);
        //Then
        Assert.assertEquals(emptyList.size(), checkList.size());
    }
    @Test
    public void testOddNumberExterminatorNormalList() {
        //Given
        ArrayList<Integer> numbersList = new ArrayList<Integer>();
        for (int i = 1; i < 11; i++) {
            numbersList.add(i);
        }
        OddNumbersExterminator oddNumberExterminator = new OddNumbersExterminator();
        //When
        ArrayList<Integer> checkList = oddNumberExterminator.exterminate(numbersList);
        //Then
        Assert.assertEquals(numbersList.get(1), checkList.get(0));
        Assert.assertEquals(numbersList.get(9), checkList.get(4));
    }
}
