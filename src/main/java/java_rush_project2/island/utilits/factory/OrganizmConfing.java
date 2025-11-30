package java_rush_project2.island.utilits.factory;

public enum OrganizmConfing {

    WOLF(50, 30, 3, 2, 50, 0.5, 35),
    BOA(15, 30, 1, 1, 80, 0.5, 35),
    FOX(8, 30, 2, 1, 85, 0.2, 35),
    BEAR(500, 5, 2, 15, 95, 12.0, 80),
    EAGLE(6, 20, 3, 1, 98, 0.1, 45),
    HORSE(400, 20, 4, 60, 95, 8.0, 70),
    DEER(300, 20, 4, 50, 90, 6.0, 70),
    BOAR(400, 50, 2, 50, 100, 10.0, 75),
    SHEEP(70, 140, 3, 15, 40, 2.0, 45),
    GOAT(60, 140, 3, 10, 48, 2.0, 40),
    BUFFALO(700, 10, 3, 100, 90, 10.0, 60),
    MOUSE(0.05, 500, 1, 0.01, 20, 0.002, 30),
    RABIT(2, 150, 2, 0.45, 30, 0.05, 40),
    DUCK(1, 200, 4, 0.15, 48, 0.05, 40),
    CATERPILLAR(0.01, 1000, 0, 0.002, 30, 0.001, 10),
    GRASS(1, 200, 0, 0, 100, 0, 100);


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
