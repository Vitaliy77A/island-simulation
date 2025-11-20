package java_rush_projectt2.island.island_services;

import java_rush_projectt2.island.map.Location;
import java_rush_projectt2.island.model_organizm.GameSimulation;
import java_rush_projectt2.island.model_organizm.Organism;
import java_rush_projectt2.island.model_organizm.animal.Animal;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

    public class FoodServise {
            public void timeToEat(Location location) {
                ConcurrentHashMap<String, List<Organism>> residents = location.getResidents();
                List<Animal> animalsCoppy = residents.values().stream()
                        .flatMap(List::stream)
                        .filter(it   -> it   instanceof Animal)
                        .map(it -> (Animal) it)
                        .toList();
                for (Animal animal : animalsCoppy) {
                    animal.eat(residents);
                }
            }
        }

