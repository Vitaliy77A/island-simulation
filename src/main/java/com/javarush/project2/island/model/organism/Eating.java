package com.javarush.project2.island.model.organism;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface Eating {
    void eat(ConcurrentHashMap<String, List<Organism>> residents);
}
