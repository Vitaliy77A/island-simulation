package com.javarush.project2.island.island.services;

import com.javarush.project2.island.map.Location;
import com.javarush.project2.island.model.organism.Organism;
import com.javarush.project2.island.model.organism.animal.Animal;
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

