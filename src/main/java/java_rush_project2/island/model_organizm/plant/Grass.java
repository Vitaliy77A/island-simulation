package java_rush_project2.island.model_organizm.plant;
import java_rush_project2.island.model_organizm.Organism;

import java.util.concurrent.ThreadLocalRandom;

public class Grass extends Plant {
    private volatile double mass = 1;
    private static final double MAX_MASS = 5;
    private static final double EATEN_UNIT = 1.0;

    public double getMass() {
        return mass;
    }

    public void grov() {
        if (mass < MAX_MASS) {
            mass++;
            System.out.println("Grass росте, масса: " + mass);
        } else {
            System.out.println("Grass досягла максимального розміру: " + MAX_MASS);
        }
    }

    @Override
    public Organism reproduce() {
        if (mass == MAX_MASS) {
            int chans = 20;
            int random = ThreadLocalRandom.current().nextInt(100);
            if (random < chans) {
              return new Grass();
            }
        }
        return null;
    }

    public double decrease() {
        double eaten;

        if (mass >= EATEN_UNIT) {
            mass -= EATEN_UNIT;
            eaten = EATEN_UNIT;
        } else {
            eaten = mass;
            mass = 0.0;
            System.out.println("Grass була повністю зїдена ");
        }

        return eaten;
    }
    }
