package java_rush_projectt2.island.model.organizm.plant;
import java.util.concurrent.ThreadLocalRandom;

public class Grass extends Plant {
    private int mass = 1;
    private static final int MAX_MASS = 5;

    @Override
    public void grov() {
        if (mass < MAX_MASS) {
            mass++;
            System.out.println("Grass росте, масса: " + mass);
        } else {
            System.out.println("Grass досягла максимального розміру: " + MAX_MASS);
        }
    }

    @Override
    public void reproduce() {
        if (mass == MAX_MASS) {
            int chans = 20;
            int random = ThreadLocalRandom.current().nextInt(100);
            if (random < chans) {
                Grass newGrass = new Grass();
                newGrass.setLocation(location);
                location.addOrganism(newGrass);
            }
        }
    }

    public void decrease() {
        mass--;
        if (mass <= 0) {
            location.remuvOrganism(this);
            System.out.println("Grass була повністю зїдена ");
        } else {
            System.out.println("Grass втратила массу, нинішня масса: " + mass);
        }
    }
}
