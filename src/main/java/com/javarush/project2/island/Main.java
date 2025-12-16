package com.javarush.project2.island;

import com.javarush.project2.island.engine.IslandEngine;
import com.javarush.project2.island.map.Island;

public class Main {
    public static void main(String[] args) {
        Island island = new Island(100, 20);
        IslandEngine islandEngine = new IslandEngine(island);
        islandEngine.startSimulation();

    }
}
