package java_rush_projectt2.island;

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
//        Island island = new Island(10, 10);
//        Location islandTestLocation = island.getLocation(5, 5);
//        FoodServise foodServise = new FoodServise();
//        MovementService movementService = new MovementService();
//        Animal wolf = (Animal) OrganismFactory.createOrganism(TypeOrganism.WOLF);
//        Animal rabit = (Animal) OrganismFactory.createOrganism(TypeOrganism.RABIT);
//
//        wolf.setCurrentSatiety(0.0);
//
//        islandTestLocation.addOrganism(wolf);
//        islandTestLocation.addOrganism(rabit);
//        try {
//            System.out.println("--- ДО ПЕРЕМІЩЕННЯ ---");
//            System.out.println("Тварин у (5, 5): " + islandTestLocation.getResidents().get("WOLF").size());
//            islandTestLocation.printResidents();
//            movementService.moveAll(island);
//            islandTestLocation.printResidents();
//            System.out.println("--- ПІСЛЯ ПЕРЕМІЩЕННЯ ---");
//
//        } catch (Exception e) {
//            System.err.println("--- АВАРІЙНИЙ ЗВІТ ---");
//            e.printStackTrace(); // Виведе, на якому рядку стався збій
//            System.err.println("--------------------");
//            return; // Завершити виконання
//        }
//
//      System.out.println("До полювання ");
//
//     foodServise.timeToEat(islandTestLocation);
//      System.out.println("Після полювання ");
//
//        int wolfCount = islandTestLocation.getResidents()
//                .getOrDefault("WOLF", Collections.emptyList()) // Якщо WOLF немає, повертаємо порожній список
//                .size();
//        System.out.println("Поїв вовк чи ні  " + wolf.getCurrentSatiety());

        Island island = new Island(1, 1);
        Location testLocation = island.getLocation(0, 0);
        ReproduceServise reproductionService = new ReproduceServise();

        Organism rabit1 = OrganismFactory.createOrganism(TypeOrganism.RABIT);
        Organism rabit2 = OrganismFactory.createOrganism(TypeOrganism.RABIT);

        testLocation.addOrganism(rabit1);
        testLocation.addOrganism(rabit2);


        int initialCount = testLocation.getResidents()
                .getOrDefault("RABIT", Collections.emptyList()).size();
        System.out.println("ДО РОЗМНОЖЕННЯ: ");
        System.out.println("Кількість Зайців: " + initialCount);

        reproductionService.timeToReproduce(island);


        int finalCount = testLocation.getResidents()
                .getOrDefault("RABIT", Collections.emptyList()).size();
        System.out.println("ПІСЛЯ РОЗМНОЖЕННЯ: ");
        System.out.println("Кількість Зайців: " + finalCount);


    }
}
