package java_rush_projectt2.island.model.organizm.plant;

import java_rush_projectt2.island.model.organizm.GameSimulation;

public abstract class Plant implements GameSimulation {

    @Override
    public void play() {
        reproduce();
        grov();
    }

    @Override
    public void reproduce() {
        System.out.println(getClass().getSimpleName() + " розмножується");
    }

    @Override
    public void grov() {
        System.out.println(getClass().getSimpleName() + " росте");
    }
}
