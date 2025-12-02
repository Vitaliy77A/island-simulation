package java_rush_project2.island.island_services;

import java_rush_project2.island.map.Location;
import java_rush_project2.island.model_organism.Organism;
import java_rush_project2.island.model_organism.animal.Animal;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

    public class FoodService {
            public void timeToEat(Location location) {
                ConcurrentHashMap<String, List<Organism>> residents = location.getResidents();
                List<Animal> animalsCopy = residents.values().stream()
                        .flatMap(List::stream)
                        .filter(it   -> it   instanceof Animal)
                        .map(it -> (Animal) it)
                        .toList();
                for (Animal animal : animalsCopy) {
                    animal.eat(residents);
                }
            }
        }

