package java_rush_project2.island.utilits.factory;

public enum OrganismConfig {

    WOLF(50, 30, 3, 8, 15, 0.35, 35),
    BOA(15, 30, 1, 3, 16, 0.12, 35),
    FOX(8, 30, 2, 2, 15, 0.08, 35),
    BEAR(500, 5, 2, 80, 19, 3.5, 80),
    EAGLE(6, 20, 3, 1, 15, 0.04, 45),
    HORSE(400, 20, 4, 60, 20, 2.5, 70),
    DEER(300, 20, 4, 50, 20, 2.0, 70),
    BOAR(400, 50, 2, 50, 20, 2.0, 75),
    SHEEP(70, 140, 3, 15, 25, 0.6, 45),
    GOAT(60, 140, 3, 10, 25, 0.4, 40),
    BUFFALO(700, 10, 3, 100, 15, 4.0, 60),
    MOUSE(0.05, 500, 1, 0.01, 40, 0.0004, 30),
    RABBIT(2, 150, 2, 0.45, 40, 0.02, 40),
    DUCK(1, 200, 4, 0.15, 30, 0.006, 40),
    CATERPILLAR(0.01, 1000, 0, 0.002, 70, 0.0001, 10),
    GRASS(1, 200, 0, 0, 100, 0, 100);


    private final double maxWeight;
    private final int maxPopulation;
    private final int maxSpeed;
    private final double foodNeeded;
    private final int reproduceChance;
    private final double hungerLossRate;
    private final int maxLifespan;

    OrganismConfig(double maxWeight, int maxPopulation, int maxSpeed, double foodNeeded,
                   int reproduceChance, double hungerLossRate, int maxLifespan) {
        this.maxWeight = maxWeight;
        this.maxPopulation = maxPopulation;
        this.maxSpeed = maxSpeed;
        this.foodNeeded = foodNeeded;
        this.reproduceChance = reproduceChance;
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

    public int getReproduceChance() {
        return reproduceChance;
    }

    public double getHungerLossRate() {
        return hungerLossRate;
    }

    public int getMaxLifespan() {
        return maxLifespan;
    }
}
