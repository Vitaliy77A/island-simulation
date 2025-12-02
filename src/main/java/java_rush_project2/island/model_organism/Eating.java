package java_rush_project2.island.model_organism;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface Eating {
    void eat(ConcurrentHashMap<String, List<Organism>> residents);
}
