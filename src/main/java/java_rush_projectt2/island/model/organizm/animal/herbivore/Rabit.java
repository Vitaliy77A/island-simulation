package java_rush_projectt2.island.model.organizm.animal.herbivore;

public class Rabit extends Herbivore {


    public Rabit() {
     super(2,150,2,0.45);
    }

    @Override
    public void move() {
        System.out.println("Заец ищет траву");
    }

    @Override
    public void eat() {
        System.out.println("Заец сьел траву");
    }

    @Override
    public void reproduce() {
        System.out.println("Заец размножается");
    }
}
