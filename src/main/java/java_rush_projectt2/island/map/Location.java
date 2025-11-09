package java_rush_projectt2.island.map;

import java_rush_projectt2.island.model.organizm.Organism;
import java_rush_projectt2.island.model.organizm.animal.Animal;
import java_rush_projectt2.island.model.organizm.plant.Plant;

import java.util.*;

public class Location {

    public final Map<String, Set<Organism>> residents = new HashMap<>();

    public Location() {
    }

    public Map<String, Set<Organism>> getResidents() {
        return residents;
    }

    public void addOrganism(Organism organism) {
        String key = residents.getClass().getSimpleName().toUpperCase();
        residents.computeIfAbsent(key, it -> new HashSet<>()).add(organism);
    }

    public void printResidents(Organism organism) {
        if (residents.isEmpty()) {
            System.out.println("Локация пустая. ");
            return;
        }
        System.out.println("Локация заселена: ");
        residents.forEach((key, set) ->
                System.out.println(" - " + key + " : " + set.size()));
    }

    public void remuvOrganism(Organism organism) {
        String key = residents.getClass().getSimpleName().toUpperCase();
        if (!residents.containsKey(key)) {
            System.out.println("а локации не такого вида организма: " + key);
        }
        residents.computeIfPresent(key, (it, set) -> {
          boolean remove = set.remove(organism);
          if (remove) {
              System.out.println("Удалено даный организм: " + organism.getClass().getSimpleName());
          } else {
              System.out.println("Организм: " + organism.getClass().getSimpleName() + " не найден.");
          }
            return set.isEmpty() ? null : set;
        });

    }

    public void movementOrganism() {
        for (Set<Organism> group : residents.values()) {
            for (Organism organism : group) {
                if (organism instanceof Animal animal) {
                    animal.move();
                    animal.eat();
                    animal.reproduce();
                } else if (organism instanceof Plant plant) {
                    plant.reproduce();
                }
            }
        }
    }
}
