package com.javarush.project2.island.island.services;

import com.javarush.project2.island.map.Island;
import com.javarush.project2.island.map.Location;
import com.javarush.project2.island.model.organism.Organism;
import com.javarush.project2.island.model.organism.animal.Animal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class MovementService {

    public void moveAll(Island island) {
        Location[][] map = island.getMap();
        Set<Organism> movedOrganisms = new HashSet<>();

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                Location currentLocation = map[x][y];

                List<Animal> animalsToMove = currentLocation.getResidents().values().stream()
                        .flatMap(List::stream)
                        .filter(it -> it instanceof Animal)
                        .map(Animal.class::cast)
                        .toList();

                for (Animal animal : animalsToMove) {
                    if (movedOrganisms.contains(animal)) {
                        continue;
                    }

                    int[] newPosition = calculateNewPosition(x, y, island, animal);
                    int positionX = newPosition[0];
                    int positionY = newPosition[1];

                    if (positionX == x && positionY == y) {
                        continue;
                    }

                    Location newLocation = map[positionX][positionY];

                    if (currentLocation.getResidents().containsKey(animal.getClass().getSimpleName().toUpperCase())) {
                        currentLocation.removeOrganism(animal);
                        newLocation.addOrganism(animal);

                        movedOrganisms.add(animal);
                    }
                }
            }
        }
    }

    private int[] calculateNewPosition(int x, int y, Island island, Animal animal) {
        int speed = animal.getConfig().getMaxSpeed();
        if (speed <= 0) {
            return new int[]{x, y};
        }

        int randomX = ThreadLocalRandom.current().nextInt(speed * 2 + 1) - speed;
        int randomY = ThreadLocalRandom.current().nextInt(speed * 2 + 1) - speed;

        int positionX = Math.max(0, Math.min(island.getWidth() - 1, x + randomX));
        int positionY = Math.max(0, Math.min(island.getHeight() - 1, y + randomY));

        return new int[]{positionX, positionY};
    }
}


