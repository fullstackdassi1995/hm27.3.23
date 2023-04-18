package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicStampedReference;


public class Main {
    public static AtomicInteger meet = new AtomicInteger(0);
    protected static AtomicBoolean gameOver = new AtomicBoolean(false);


    public static void main(String[] args) {
        String[] city = {"Israel", "United Kingdom", "USA", "Egypt" ,"Germany", "France",
                "Poland", "Cyprus", "India" ,"Japan", "China", "Morocco", "Hungary","Switzerland",
                "Russia", "Ukraine", "Greece", "Italy", "Argentina", "Sri Lanka" };

        for (int i = 0; i < city.length; i++) {
            new OlympicRunner(city[i]).start();

        }
    }


}