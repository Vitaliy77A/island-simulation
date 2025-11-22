package java_rush_projectt2.island;

import java_rush_projectt2.island.engine.IslandEngine;
import java_rush_projectt2.island.island_services.FoodServise;
import java_rush_projectt2.island.island_services.MovementService;
import java_rush_projectt2.island.island_services.ReproduceServise;
import java_rush_projectt2.island.map.Island;
import java_rush_projectt2.island.map.Location;
import java_rush_projectt2.island.model_organizm.Organism;
import java_rush_projectt2.island.model_organizm.animal.Animal;
import java_rush_projectt2.island.utilits.factory.OrganismFactory;
import java_rush_projectt2.island.utilits.factory.TypeOrganism;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Island island = new Island(100, 20);
        IslandEngine islandEngine = new IslandEngine(island);
        islandEngine.startSimulation();

    }
}
