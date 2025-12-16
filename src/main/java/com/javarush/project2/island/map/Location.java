package com.javarush.project2.island.map;

import com.javarush.project2.island.model.organism.Organism;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Location {

    private final ConcurrentHashMap<String, List<Organism>> residents = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, List<Organism>> getResidents() {
        return residents;
    }

    public void addOrganism(Organism organism) {
        String key = organism.getClass().getSimpleName().toUpperCase();
        residents.computeIfAbsent(key, it -> new CopyOnWriteArrayList<>())
                .add(organism);
    }

    public void removeOrganism(Organism organism) {
        String key = organism.getClass().getSimpleName().toUpperCase();
        List<Organism> list = residents.get(key);

        if (list != null) {

            list.remove(organism);
        }
    }
}


