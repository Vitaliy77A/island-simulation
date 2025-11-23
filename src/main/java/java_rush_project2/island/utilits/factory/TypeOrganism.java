package java_rush_project2.island.utilits.factory;
public enum TypeOrganism {

    WOLF(Category.ANIMAL),
    BEAR(Category.ANIMAL),
    BOA(Category.ANIMAL),
    EAGLE(Category.ANIMAL),
    FOX(Category.ANIMAL),
    BOAR(Category.ANIMAL),
    BUFFALO(Category.ANIMAL),
    CATERPILLAR(Category.ANIMAL),
    DEER(Category.ANIMAL),
    DUCK(Category.ANIMAL),
    GOAT(Category.ANIMAL),
    HORSE(Category.ANIMAL),
    MOUSE(Category.ANIMAL),
    RABIT(Category.ANIMAL),
    SHEEP(Category.ANIMAL),
    GRASS(Category.PLANT);

    private final Category category;

    TypeOrganism(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public enum Category {
        ANIMAL,
        PLANT
    }
}
