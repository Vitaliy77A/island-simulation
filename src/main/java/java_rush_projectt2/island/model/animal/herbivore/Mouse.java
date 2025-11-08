package java_rush_projectt2.island.model.animal.herbivore;

public class Mouse extends Herbivore {
    public Mouse(double weight, int maxCount, int spead, double foodNeeded) {
        super(weight, maxCount, spead, foodNeeded);
    }

    public Mouse() {
        super(0.05,500,1,0.01);
    }

    @Override
    public void move() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void reproduce() {

    }
}
