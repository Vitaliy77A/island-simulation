package java_rush_projectt2.island.simulation;

import java_rush_projectt2.island.factory.OrganismFactory;
import java_rush_projectt2.island.factory.TypeOrganism;
import java_rush_projectt2.island.map.Island;
import java_rush_projectt2.island.map.Location;
import java_rush_projectt2.island.model.organizm.Organism;
import java_rush_projectt2.island.model.organizm.animal.Animal;
import java_rush_projectt2.island.model.organizm.plant.Plant;

public class SimulationGame {

    public static void main(String[] args) {

        Island island = new Island(2,2);

        Location location = island.getLocation(0,0);

        location.addOrganism(OrganismFactory.createOrganism(TypeOrganism.WOLF));
        location.addOrganism(OrganismFactory.createOrganism(TypeOrganism.RABIT));
        location.addOrganism(OrganismFactory.createOrganism(TypeOrganism.GRASS));

        Location location2 = island.getLocation(1,1);
        location2.addOrganism(OrganismFactory.createOrganism(TypeOrganism.BEAR));
        location2.addOrganism(OrganismFactory.createOrganism(TypeOrganism.GRASS));

        for (int i = 0; i <= 3 ; i++) {
            System.out.println("Начало симуляции " + i);
            island.step();
        }



//        Animal wolf = OrganismFactory.createOrganism(TypeOrganism.WOLF);
//        System.out.println("Создали: " + wolf.getClass().getSimpleName());
//        wolf.move();
//        wolf.eat();
//        wolf.reproduce();
//        System.out.println("__________________________________________");
//
//        Animal rabit = OrganismFactory.createOrganism(TypeOrganism.RABIT);
//        System.out.println("Создали: " + rabit.getClass().getSimpleName());
//        rabit.move();
//        rabit.eat();
//        rabit.reproduce();
//        System.out.println("_____________________________________________");
//
//        Plant grass = OrganismFactory.createOrganism(TypeOrganism.GRASS);
//        System.out.println("Создали: " + grass.getClass().getSimpleName());
//        grass.reproduce();
    }
}
