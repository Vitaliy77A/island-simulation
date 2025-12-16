package com.javarush.project2.island.model.organism.animal.herbivore;

import com.javarush.project2.island.model.organism.animal.Animal;
import com.javarush.project2.island.utilits.factory.OrganismConfig;

public abstract class Herbivore extends Animal  {
    public Herbivore(OrganismConfig config) {
        super(config);
    }
}
