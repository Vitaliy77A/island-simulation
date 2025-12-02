package java_rush_project2.island.engine;

import java_rush_project2.island.island_services.*;
import java_rush_project2.island.map.Island;
import java_rush_project2.island.map.Location;
import java_rush_project2.island.model_organism.Organism;
import java_rush_project2.island.utilits.factory.OrganismFactory;
import java_rush_project2.island.utilits.factory.OrganismConfig;
import java_rush_project2.island.utilits.factory.TypeOrganism;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class IslandEngine {

    private final Island island;

    private final ScheduledExecutorService gameTimer = Executors.newScheduledThreadPool(1);

    private final ExecutorService workerPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    private final FoodService foodService = new FoodService();
    private final MovementService movementService = new MovementService();
    private final ReproduceService reproduceService = new ReproduceService();
    private final StatisticService statisticService = new StatisticService();
    private final DeathService deathService = new DeathService();

    private int currentTick = 0;

    public IslandEngine(Island island) {
        this.island = island;
        this.populateIsland();
    }

    public void populateIsland() {
        for (int x = 0; x < island.getWidth(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {
                Location currentLocation = island.getLocation(x, y);

                for (OrganismConfig config : OrganismConfig.values()) {


                    if (config == OrganismConfig.GRASS) {

                        int count = ThreadLocalRandom.current().nextInt(config.getMaxPopulation());
                        createOrganisms(config, currentLocation, count);
                        continue;
                    }


                    if (ThreadLocalRandom.current().nextInt(100) < 15) {

                        int maxInCell = config.getMaxPopulation();
                        int countToSpawn = ThreadLocalRandom.current().nextInt(1, maxInCell + 1);

                        createOrganisms(config, currentLocation, countToSpawn);
                    }
                }
            }
        }
        System.out.println("The island has been populated.");
    }

    private void createOrganisms(OrganismConfig config, Location location, int count) {
        TypeOrganism type = TypeOrganism.valueOf(config.name());
        for (int i = 0; i < count; i++) {
            Organism organism = OrganismFactory.createOrganism(type);
            location.addOrganism(organism);
        }
    }

    public void startSimulation() {

        gameTimer.scheduleAtFixedRate(this::runCycle, 0, 1, TimeUnit.MILLISECONDS);
    }

    public void runCycle() {
        deathService.applyStarvationAndAging(island);

        Location[][] map = island.getMap();
        List<Callable<Void>> tasks = new ArrayList<>();

        for (Location[] locations : map) {
            for (Location location : locations) {
                tasks.add(() -> {
                    foodService.timeToEat(location);
                    return null;
                });
            }
        }

        try {
            workerPool.invokeAll(tasks);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        movementService.moveAll(island);
        reproduceService.timeToReproduce(island);
        deathService.checkDeathConditions(island);

        if (statisticService.isIslandEmpty(island)) {
            gameTimer.shutdown();
            workerPool.shutdown();
            System.out.println("Simulation ended: All organisms are extinct.");
            return;
        }

        currentTick++;
        statisticService.printStatistic(island, currentTick);
    }
}
