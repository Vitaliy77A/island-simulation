package java_rush_project2.island.utilits.factory;

import java_rush_project2.island.model_organizm.Organism;
import java_rush_project2.island.model_organizm.animal.herbivore.*;
import java_rush_project2.island.model_organizm.animal.predator.*;
import java_rush_project2.island.model_organizm.plant.Grass;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class OrganismFactory {

    private static final Map<TypeOrganism, Supplier<? extends Organism>> addition = new HashMap<>();

    static {
        addition.put(TypeOrganism.BEAR, Bear::new);
        addition.put(TypeOrganism.BOA, Boa::new);
        addition.put(TypeOrganism.FOX, Fox::new);
        addition.put(TypeOrganism.EAGLE, Eagle::new);
        addition.put(TypeOrganism.WOLF, Wolf::new);

        addition.put(TypeOrganism.CATERPILLAR,Caterpillar::new);
        addition.put(TypeOrganism.GOAT, Goat::new);
        addition.put(TypeOrganism.DUCK,Duck::new);
        addition.put(TypeOrganism.HORSE, Horse::new);
        addition.put(TypeOrganism.BOAR, Boar::new);
        addition.put(TypeOrganism.BUFFALO,Buffalo::new);
        addition.put(TypeOrganism.DEER, Deer::new);
        addition.put(TypeOrganism.MOUSE,Mouse::new);
        addition.put(TypeOrganism.RABIT, Rabit::new);
        addition.put(TypeOrganism.SHEEP,Sheep::new);

        addition.put(TypeOrganism.GRASS,Grass::new);
    }

    public static <T extends Organism> T createOrganism(TypeOrganism type) {
        Supplier<? extends Organism> supplier = addition.get(type);

        if (supplier == null) {
            throw new IllegalArgumentException("Uknown typy opganism " + type);
        }

        return (T) supplier.get();
    }
}
