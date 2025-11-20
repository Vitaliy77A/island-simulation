package java_rush_projectt2.island.utilits.factory;

public enum OrganizmConfing {
    WOLF(50,30,3,8),
    FOX(8,30,2,2),
    EAGLE(6,20,3,1),
    BOA(15,30,1,3),
    BEAR(500,2,5,80),
    BOAR(400,50,2,50),
    BUFFALO(700,10,3,100),
    CATERPILLAR(0.01,100,0,0),
    DEER(300, 20,4,50),
    DUCK(1,200,4,0.15),
    GOAT(60,140,3,10),
    HOURSE(400, 20, 4,60),
    MOUSE(0.05,500,1,0.01),
    RABIT(2,150,2,0.45),
    SHEEP(70,140,3,15),
    GRASS(1,200,0,0);


    private final double maxWeight;
    private final int maxPopulation;
    private final int maxSpeed;
    private final double foodNeeded;

    OrganizmConfing(double maxWeight, int maxPopulation, int maxSpeed, double foodNeeded) {
        this.maxWeight = maxWeight;
        this.maxPopulation = maxPopulation;
        this.maxSpeed = maxSpeed;
        this.foodNeeded = foodNeeded;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public int getMaxPopulation() {
        return maxPopulation;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getFoodNeeded() {
        return foodNeeded;
    }
}
