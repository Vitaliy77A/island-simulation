package com.javarush.project2.island.model.organism.plant;



public class Grass extends Plant {
    private double mass = 1;
    private static final double EATEN_UNIT = 1.0;

    public double getMass() {
        return mass;
    }

    public double decrease() {
        double eaten;

        if (mass >= EATEN_UNIT) {
            mass -= EATEN_UNIT;
            eaten = EATEN_UNIT;
        } else {
            eaten = mass;
            mass = 0.0;
            System.out.println("Grass was completely eaten ");
        }

        return eaten;
    }
}
