package com.kodilla.testing;

import com.kodilla.testing.caclulator.Calculator;

import java.util.Random;

public class TestingMain {
    public static void main(String[] args) {
        boolean isAddOk = false;
        boolean isSubOk = false;
        int loopCount = 1000;
        Random randGen = new Random();
        int randNumb[] = new int [loopCount];
        for (int i = 0; i < loopCount; i++) {
            randNumb[i] = randGen.nextInt(1000);
        }
        Calculator calculator = new Calculator();
        System.out.println("Rozpoczęcie wykonywania testów dla dwóch metod 'add()' i 'subtract()' klasy 'Calculator'");
        System.out.println("Ilość operacji testowych --> " + loopCount + " par argumentów");
        for (int i = 0; i < randNumb.length; i++) {
            if ((calculator.add(randNumb[i], randNumb[randNumb.length - i - 1])) == (randNumb[i] + randNumb[randNumb.length - i - 1])) {
                isAddOk = true;
            } else {
                isAddOk = false;
                break;
            }
        }
        for (int i = 0; i < randNumb.length; i++) {
            if ((calculator.subtract(randNumb[i], randNumb[randNumb.length - i - 1])) == (randNumb[i] - randNumb[randNumb.length - i - 1])) {
                isSubOk = true;
            } else {
                isSubOk = false;
                break;
            }
        }
        if (isAddOk) {
            System.out.println("\nTest jednostkowy dla metody 'add()' zakończony SUKCESEM");
        } else {
            System.out.println("\nPodczas testu jednostkowego dla metody 'add()' wystąpił Błąd!!!");
        }
        if (isSubOk) {
            System.out.println("\nTest jednostkowy dla metody 'subtract()' zakończony SUKCESEM");
        } else {
            System.out.println("\nPodczas testu jednostkowego dla metody 'subtract()' wystąpił Błąd!!!");
        }

    }
}
