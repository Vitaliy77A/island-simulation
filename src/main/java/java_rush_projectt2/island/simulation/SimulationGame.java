package java_rush_projectt2.island.simulation;

import java_rush_projectt2.island.utilits.OrganismFactory;
import java_rush_projectt2.island.utilits.TypeOrganism;
import java_rush_projectt2.island.map.Island;
import java_rush_projectt2.island.map.Location;

public class SimulationGame {

    public static void main(String[] args) {

        Island island = new Island(4,4);

        Location location = island.getLocation(0,0);

//        location.addOrganism(OrganismFactory.createOrganism(TypeOrganism.WOLF));
//        location.addOrganism(OrganismFactory.createOrganism(TypeOrganism.RABIT));
//        location.addOrganism(OrganismFactory.createOrganism(TypeOrganism.GRASS));
//
//        Location location2 = island.getLocation(1,1);
//        location2.addOrganism(OrganismFactory.createOrganism(TypeOrganism.BEAR));
//        location2.addOrganism(OrganismFactory.createOrganism(TypeOrganism.DEER));
//        location2.addOrganism(OrganismFactory.createOrganism(TypeOrganism.GRASS));

        Location location3 = island.getLocation(2,2);
        location3.addOrganism(OrganismFactory.createOrganism(TypeOrganism.BOA));
        location3.addOrganism(OrganismFactory.createOrganism(TypeOrganism.DUCK));
        location3.addOrganism(OrganismFactory.createOrganism(TypeOrganism.GRASS));

        for (int i = 0; i <= 4 ; i++) {
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
