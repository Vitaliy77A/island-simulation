package java_rush_projectt2.island.island_services;

import java_rush_projectt2.island.map.Island;
import java_rush_projectt2.island.map.Location;
import java_rush_projectt2.island.model_organizm.animal.Animal;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MovementService {
    public void moveAll(Island island) {
        Location[][] map = island.getMap();
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                Location currentLocation = map[x][y];
                List<Animal> animalsInLocation = currentLocation.getResidents().values().stream()
                        .flatMap(List::stream)
                        .filter(organism -> organism instanceof Animal)
                        .map(organism -> (Animal) organism)
                        .toList();
                for (Animal animal : animalsInLocation) {
                    int[] newPosition = calculateNewPosition(x, y, island, animal);
                    int positionX = newPosition[0];
                    int positionY = newPosition[1];

                    if (positionX == x && positionY == y) {
                        continue;
                    }

                    Location newLocation = map[positionX][positionY];
                    currentLocation.removeOrganism(animal);
                    newLocation.addOrganism(animal);
                }
            }
        }
    }
    private int[] calculateNewPosition(int x, int y, Island island, Animal animal) {
        int spead = animal.getConfig().getMaxSpeed();
        if (spead <= 0) {
            return new int[]{x, y};
        }

        int randomX = (int) (ThreadLocalRandom.current().nextInt(spead * 2 + 1)) - spead;
        int randomY = (int) (ThreadLocalRandom.current().nextInt(spead * 2 + 1)) - spead;

        int positionX = Math.max(0, Math.min(island.getWidht() - 1, x + randomX));
        int positionY = Math.max(0, Math.min(island.getHeight() - 1, y + randomY));

        return new int[]{positionX, positionY};
    }
}


