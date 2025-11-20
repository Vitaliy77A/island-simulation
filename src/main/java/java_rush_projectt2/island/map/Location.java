package java_rush_projectt2.island.map;

import java_rush_projectt2.island.model_organizm.Organism;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Location {

    private final ConcurrentHashMap<String, List<Organism>> residents = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, List<Organism>> getResidents() {
        return residents;
    }

    public void addOrganism(Organism organism) {
        String key = organism.getClass().getSimpleName().toUpperCase();
        residents.computeIfAbsent(key, k -> new ArrayList<>())
                .add(organism);
    }

    public void printResidents() {
        if (residents.isEmpty()) {
            System.out.println("Локация пустая.");
            return;
        }
        System.out.println("Локация заселена:");
        residents.forEach((key, list) ->
                System.out.println(" - " + key + " : " + list.size()));
    }

    public void removeOrganism(Organism organism) {
        String key = organism.getClass().getSimpleName().toUpperCase();
        residents.computeIfPresent(key, (k, list) -> {
            list.remove(organism);
            return list.isEmpty() ? null : list;
        });
    }
}


