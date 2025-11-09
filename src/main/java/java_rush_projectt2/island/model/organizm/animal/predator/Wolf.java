package java_rush_projectt2.island.model.organizm.animal.predator;

public class Wolf extends Predator {

    public Wolf () {
        super(50,30,3,8);
    }

    @Override
    public void move() {
        System.out.println("Волк охотися на добычу");
    }

    @Override
    public void eat() {
        System.out.println("Волк ест пойманую добычу");
    }

    @Override
    public void reproduce() {
        System.out.println("Волк размножается");
    }
}
