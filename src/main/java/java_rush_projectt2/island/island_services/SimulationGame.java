package java_rush_projectt2.island.island_services;

import java_rush_projectt2.island.utilits.OrganismFactory;
import java_rush_projectt2.island.utilits.TypeOrganism;
import java_rush_projectt2.island.map.Island;
import java_rush_projectt2.island.map.Location;

public class SimulationGame {
    public static void main(String[] args) {

        Island island = new Island(4, 4);

        Location islandLocation = island.getLocation(1, 1);

        islandLocation.addOrganism(OrganismFactory.createOrganism(TypeOrganism.WOLF));
        islandLocation.addOrganism(OrganismFactory.createOrganism(TypeOrganism.RABIT));
        islandLocation.addOrganism(OrganismFactory.createOrganism(TypeOrganism.GRASS));

        System.out.println("До еды:");
        islandLocation.printResidents();

      FoodServise foodServise = new FoodServise();
        foodServise.timeToEat(islandLocation);

        System.out.println("После еды:");
        islandLocation.printResidents();
    }
}
