package java_rush_project2.island.utilits.factory;

public enum OrganizmConfing {
    WOLF(50,30,3,8,20, 0.8, 24),
    FOX(8,30,2,2,30,0.5,25),
    EAGLE(6,20,3,1,32, 0.2, 40),
    BOA(15,30,1,3,10, 0.4,30),
    BEAR(500,2,5,80,24, 8.0, 17),
    BOAR(400,50,2,50,60,5.0,18),
    BUFFALO(700,10,3,100,10,10.0,20),
    CATERPILLAR(0.01,1000,0,0.005,95, 0.001, 5),
    DEER(300, 20,4,50,39, 5.0,25),
    DUCK(1,200,4,0.15,70,0.003,20),
    GOAT(60,140,3,10,42,1.0,20),
    HORSE(400, 20, 4,60,15,6.0,22),
    MOUSE(0.05,500,1,0.01,88,0.005,8),
    RABIT(2,150,2,0.45,80,0.09,10),
    SHEEP(70,140,3,15,37,1.5,22),
    GRASS(1,200,0,0,15,0,50);


    private final double maxWeight;
    private final int maxPopulation;
    private final int maxSpeed;
    private final double foodNeeded;
    private final int reproduceChans;
    private final double hungerLossRate;
    private final int maxLifespan;

    OrganizmConfing(double maxWeight, int maxPopulation, int maxSpeed, double foodNeeded,
                    int reproduceChans, double hungerLossRate, int maxLifespan) {
        this.maxWeight = maxWeight;
        this.maxPopulation = maxPopulation;
        this.maxSpeed = maxSpeed;
        this.foodNeeded = foodNeeded;
        this.reproduceChans = reproduceChans;
        this.hungerLossRate = hungerLossRate;
        this.maxLifespan = maxLifespan;
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

    public int getReproduceChans() {
        return reproduceChans;
    }

    public double getHungerLossRate() {
        return hungerLossRate;
    }

    public int getMaxLifespan() {
        return maxLifespan;
    }
}
