package com.javarush.project2.island.model.organism.animal.predator;

import com.javarush.project2.island.model.organism.animal.Animal;
import com.javarush.project2.island.utilits.factory.OrganismConfig;

public abstract class Predator extends Animal {
    public Predator(OrganismConfig config) {
        super(config);
    }
}
