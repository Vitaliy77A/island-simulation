package java_rush_projectt2.island.model.animal.herbivore;

public class Duck extends Herbivore {
    public Duck(double weight, int maxCount, int spead, double foodNeeded) {
        super(weight, maxCount, spead, foodNeeded);
    }

    public Duck() {
        super(1,200,4,0.15);
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
