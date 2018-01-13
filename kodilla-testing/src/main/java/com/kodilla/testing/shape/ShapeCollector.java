package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public void addFigure(Shape shape){
        shapes.add(shape);
        System.out.println("Dodano figurę --> " + shape);
    }

    public boolean removeFigure(Shape shape){
        boolean result = false;
        if (!shapes.isEmpty()) {
            shapes.remove(shape);
            System.out.println("Usunięto figurę --> " + shape);
            result = true;
        } else {
            System.out.println("Brak na liście figur do usunięcia");
        }
        return result;
    }

    public Shape getFigure(int i) {
        Shape theFigure = null;
        if (i >= 0 && i < shapes.size()) {
            System.out.println("Pobrano figurę <-- " + shapes.get(i));
            theFigure = shapes.get(i);
        } else {
            System.out.println("Figura o indeksie " + i + " nie istnieje na liście");
        }
        return theFigure;
    }

    public ArrayList<Shape> showFigures() {
        if (shapes.size() > 0) {
            int counterShapes = 0;
            for (Shape shape : shapes) {
                counterShapes++;
                System.out.println("Figura nr " + counterShapes + " z " + shapes.size() + " --> " + shape);
            }
        } else {
            System.out.println("Lista nie zawiera żadnych figur");
        }
        return shapes;
    }

}
