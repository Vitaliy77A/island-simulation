package java_rush_projectt2.island.model.organizm.plant;

import java_rush_projectt2.island.model.organizm.Organism;

public abstract class Plant implements Organism {
    @Override
    public void reproduce() {
        System.out.println(getClass().getSimpleName() + " Растет");
    }
}
