package com.javarush.project2.island.utilits;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class EatingTable {

    private static final Map<String, Map<String, Integer>> eatingPossibilities = new HashMap<>();

    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(java.util.Objects.requireNonNull(
                EatingTable.class.getResourceAsStream("/eatingPossibilitiesOrganism.csv"), "File not found")))) {
            String[] hadesOrganism = reader.readLine().split("\\|");
            for (int i = 1; i < hadesOrganism.length; i++) {
                hadesOrganism[i] = hadesOrganism[i].trim();
            }
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                String[] values = line.split("\\|");
                String animal = values[0].trim();

                Map<String, Integer> preyMap = new HashMap<>();
                for (int i = 1; i < values.length; i++) {
                    int probability = Integer.parseInt(values[i].trim());
                    preyMap.put(hadesOrganism[i], probability);
                }
                eatingPossibilities.put(animal, preyMap);

            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading probability table ", e);
        }

    }

    public static int getChance(String predator, String pray) {

        return eatingPossibilities.getOrDefault(predator, Map.of())
                .getOrDefault(pray, 0);
    }
}
