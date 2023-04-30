package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicStampedReference;


public class Main {
    protected static AtomicBoolean gameOver = new AtomicBoolean(false);
    protected static AtomicBoolean pause = new AtomicBoolean(true);
    public static ConcurrentHashMap<Integer, OlympicRunner> mapDistance = new ConcurrentHashMap<>();


    public static void main(String[] args) {
        String[] city = {"Israel", "United Kingdom", "USA", "Egypt" ,"Germany", "France",
                "Poland", "Cyprus", "India" ,"Japan", "China", "Morocco", "Hungary","Switzerland",
                "Russia", "Ukraine", "Greece", "Italy", "Argentina", "Sri Lanka" };

        for (int i = 0; i < city.length; i++) {
            new OlympicRunner(city[i]).start();

        }
    }


}