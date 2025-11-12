package java_rush_projectt2.island.map;

import java_rush_projectt2.island.model.organizm.GameSimulation;
import java_rush_projectt2.island.model.organizm.animal.Animal;
import java_rush_projectt2.island.model.organizm.plant.Plant;

import java.util.*;

public class Location {

    public final Map<String, Set<GameSimulation>> residents = new HashMap<>();

    public Location() {
    }

    public Map<String, Set<GameSimulation>> getResidents() {
        return residents;
    }

    public void addOrganism(GameSimulation organism) {
        String key = organism.getClass().getSimpleName().toUpperCase();
        residents.computeIfAbsent(key, it -> new HashSet<>()).add(organism);
    }

    public void printResidents() {
        if (residents.isEmpty()) {
            System.out.println("Локация пустая. ");
            return;
        }
        System.out.println("Локация заселена: ");
        residents.forEach((key, set) ->
                System.out.println(" - " + key + " : " + set.size()));
    }

    public void remuvOrganism(GameSimulation gameSimulation) {
        String key = residents.getClass().getSimpleName().toUpperCase();
        if (!residents.containsKey(key)) {
            System.out.println("а локации не такого вида организма: " + key);
        }
        residents.computeIfPresent(key, (it, set) -> {
          boolean remove = set.remove(gameSimulation);
          if (remove) {
              System.out.println("Удалено даный организм: " + gameSimulation.getClass().getSimpleName());
          } else {
              System.out.println("Организм: " + gameSimulation.getClass().getSimpleName() + " не найден.");
          }
            return set.isEmpty() ? null : set;
        });

    }

    public void movementOrganism() {
        for (Set<GameSimulation> group : residents.values()) {
            for (GameSimulation gameSimulation : group) {
                if (gameSimulation instanceof Animal animal) {
                   animal.play();
                } else if (gameSimulation instanceof Plant plant) {
                    plant.play();
                }
            }
        }
    }
}
