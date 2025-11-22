package java_rush_projectt2.island.island_services;

import java_rush_projectt2.island.map.Island;
import java_rush_projectt2.island.map.Location;
import java_rush_projectt2.island.model_organizm.Organism;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StatisticServis {

    public void printStatistic(Island island, int tick) {
        Map<String, Integer> statistic = new HashMap<>();
        Location[][] map = island.getMap();

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {

                Location location = map[x][y];

                for (Map.Entry<String, List<Organism>> entry : location.getResidents().entrySet()) {
                    String type = entry.getKey();
                    List<Organism> organismList = entry.getValue();
                    int count = organismList.size();

                    statistic.merge(type, count, Integer::sum);

                }
            }
        }
        System.out.println("Такт: " + tick + " ");
        System.out.println("Загальна кількість локацій: " + (island.getWidht() * island.getHeight()));

        statistic.forEach((type, statistics) -> {
            System.out.println(String.format(" %-15s: %d ", type, statistics));
        });

        System.out.println("_______________________________");
    }
}
