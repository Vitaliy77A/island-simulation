package java_rush_projectt2.island.model_organizm;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface Eating {
    void eat(ConcurrentHashMap<String, List<Organism>> residents);
}
