package java_rush_projectt2.island.map;

import java_rush_projectt2.island.model.organizm.Organism;

import java.util.*;

public class Location {

    public final Map<String, Set<Organism>> residents = new HashMap<>();

    public Location() {
    }

    public Map<String, Set<Organism>> getResidents() {
        return residents;
    }
}
