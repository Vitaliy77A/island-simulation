package java_rush_projectt2.island.engine;

import java_rush_projectt2.island.map.Island;
import java_rush_projectt2.island.map.Location;
import java_rush_projectt2.island.model_organizm.animal.Animal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IslandEngine {

    private final Island island;

    private final ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public IslandEngine(Island island) {
        this.island = island;
    }

    public void startSimulation() {
        service.scheduleAtFixedRate(this::runCycle,0,1, TimeUnit.SECONDS);
    }

    public void runCycle() {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (Location location : island.getLocation()) {
            executorService.submit(
                    () -> {
                        for (Animal animal : location.getResidents()) {

                        }
                    });

        }
    }
}
