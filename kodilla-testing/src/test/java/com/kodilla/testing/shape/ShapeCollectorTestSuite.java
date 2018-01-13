package com.kodilla.testing.shape;

import org.junit.*;

import java.util.ArrayList;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("POCZĄTEK ZESTAWU TESTÓW\n");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("\nKONIEC ZESTAWU TESTÓW");
    }

    @Before
    public void beforeTest() {
        testCounter++;
        System.out.println("\nRozpoczęcie przypadku testowego nr " + testCounter);
    }

    @After
    public void afterTest() {
        System.out.println("Zakończenie przypadku testowego nr " + testCounter);
    }

    @Test
    public void testAddGetFigure() {
        //Given
        Shape shapeCircle = new Circle(5);
        Shape shapeSquare = new Square(8);
        Shape shapeTriangle = new Triangle(6, 10);
        ShapeCollector collector = new ShapeCollector();

        //When
        collector.addFigure(shapeCircle);
        collector.addFigure(shapeSquare);
        collector.addFigure(shapeTriangle);

        //Then
        Assert.assertEquals(shapeCircle, collector.getFigure(0));
        Assert.assertEquals(shapeSquare, collector.getFigure(1));
        Assert.assertEquals(shapeTriangle, collector.getFigure(2));
    }

    @Test
    public void testGetFigureNotExisting() {
        //Given
        Shape shapeCircle = new Circle(3);
        Shape shapeSquare = new Square(6);
        Shape shapeTriangle = new Triangle(9, 10);
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(shapeCircle);
        collector.addFigure(shapeSquare);
        collector.addFigure(shapeTriangle);
        Shape sampleFigure = null;

        //When
        Shape testFigure = collector.getFigure(9);

        //Then
        Assert.assertEquals(sampleFigure, testFigure);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        Shape shapeCircle = new Circle(9);
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(shapeCircle);

        //When
        boolean result = collector.removeFigure(shapeCircle);

        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testRemoveFigureNotExisting() {
        //Given
        Shape shapeSquare = new Square(9);
        ShapeCollector collector = new ShapeCollector();

        //When
        boolean result = collector.removeFigure(shapeSquare);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testShowFigures() {
        //Given
        Shape shapeCircle = new Circle(12);
        Shape shapeSquare = new Square(15);
        Shape shapeTriangle = new Triangle(15, 12);
        ArrayList<Shape> sampleShapes = new ArrayList<Shape>();
        sampleShapes.add(shapeCircle);
        sampleShapes.add(shapeSquare);
        sampleShapes.add(shapeTriangle);
        ShapeCollector collector = new ShapeCollector();

        //When
        collector.addFigure(shapeCircle);
        collector.addFigure(shapeSquare);
        collector.addFigure(shapeTriangle);

        //Then
        Assert.assertEquals(sampleShapes, collector.showFigures());
    }

    @Test
    public void testShowFiguresIfListIsEmpty() {
        //Given
        ArrayList<Shape> sampleShapes = new ArrayList<Shape>();
        ShapeCollector collector = new ShapeCollector();

        //When
        ArrayList<Shape> testShapes = collector.showFigures();

        //Then
        Assert.assertEquals(sampleShapes, testShapes);
    }

}