package com.kodilla.testing;

import com.kodilla.testing.caclulator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Rozpoczęcie wykonywania testów dla dwóch metod 'add()' i 'subtract()' klasy 'Calculator'");
        if (calculator.add(75,25) == 100) {
            System.out.println("\nTest jednostkowy dla metody 'add()' zakończony SUKCESEM");
        } else {
            System.out.println("\nPodczas testu jednostkowego dla metody 'add()' wystąpił Błąd!!!");
        }
        if (calculator.subtract(75,25) == 50) {
            System.out.println("\nTest jednostkowy dla metody 'subtract()' zakończony SUKCESEM");
        } else {
            System.out.println("\nPodczas testu jednostkowego dla metody 'subtract()' wystąpił Błąd!!!");
        }
    }
}
