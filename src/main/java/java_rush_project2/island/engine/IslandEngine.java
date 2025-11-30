package java_rush_project2.island.engine;

import java_rush_project2.island.island_services.*;
import java_rush_project2.island.map.Island;
import java_rush_project2.island.map.Location;
import java_rush_project2.island.model_organizm.Organism;
import java_rush_project2.island.utilits.factory.OrganismFactory;
import java_rush_project2.island.utilits.factory.OrganizmConfing;
import java_rush_project2.island.utilits.factory.TypeOrganism;

import java.util.concurrent.*;

public class IslandEngine {

    private final Island island;

    private final ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    private final FoodServise foodServise = new FoodServise();
    private final MovementService movementService = new MovementService();
    private final ReproduceServise reproduceServise = new ReproduceServise();
    private final StatisticServis statisticServis = new StatisticServis();
    private final DeathService deathService = new DeathService();

    private int currentTike = 0;

    public IslandEngine(Island island) {
        this.island = island;
        this.settlementRundom();
    }

    public void settlementRundom() {
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();

        for (OrganizmConfing confing : OrganizmConfing.values()) {
            int initialcount = confing.getMaxPopulation();
            if (initialcount < 10) {
                initialcount = 10;
            }
            TypeOrganism type = TypeOrganism.valueOf(confing.name());
            for (int i = 0; i < initialcount; i++) {
                Organism newOrganizm = OrganismFactory.createOrganism(type);

                int randomX = localRandom.nextInt(island.getWidht());
                int randomY = localRandom.nextInt(island.getHeight());

                Location location = island.getLocation(randomX, randomY);
                location.addOrganism(newOrganizm);
            }
        }

        System.out.println("The island has been successfully settled: ");
    }

    public void startSimulation() {
        service.scheduleAtFixedRate(this::runCycle, 0, 1, TimeUnit.SECONDS);
    }

    public void runCycle() {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        deathService.applyStarvationAndAging(island);
        Location[][] map = island.getMap();
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                Location location = map[x][y];
                executorService.submit(() -> {
                    foodServise.timeToEat(location);
                });

            }
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        movementService.moveAll(island);
        reproduceServise.timeToReproduce(island);
        deathService.checkDeathConditions(island);

        if (statisticServis.isIslandEmpty(island)) {
            service.shutdown();
            System.out.println("Simulation ended: All organisms are extinct.");
            return;
        }

        currentTike++;
        statisticServis.printStatistic(island, currentTike);

    }
}
