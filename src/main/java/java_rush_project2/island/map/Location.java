package java_rush_project2.island.map;

import java_rush_project2.island.model_organizm.Organism;

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

    public void printResidents() {
        if (residents.isEmpty()) {
            System.out.println("The location is empty.");
            return;
        }
        System.out.println("The location is inhabited: ");
        residents.forEach((key, list) -> {
            if (!list.isEmpty()) {
                System.out.println(" - " + key + " : " + list.size());
            }
        });
    }

    public void removeOrganism(Organism organism) {
        String key = organism.getClass().getSimpleName().toUpperCase();
        List<Organism> list = residents.get(key);

        if (list != null) {

            list.removeIf(it -> it == organism);
        }
    }
}


