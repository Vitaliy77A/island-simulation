package java_rush_project2.island.utilits;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class EatingTabletServise {

    private static final Map<String, Map<String, Integer>> eatingPossibilities = new HashMap<>();

    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                EatingTabletServise.class.getResourceAsStream("/eatingPossibilitiesOrganism.csv")))) {
            String[] hadersOrganism = reader.readLine().split("\\|");
            for (int i = 1; i < hadersOrganism.length; i++) {
                hadersOrganism[i] = hadersOrganism[i].trim();
            }
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] values = line.split("\\|");
                String animal = values[0].trim();

                Map<String, Integer> preyMap = new HashMap<>();
                for (int i = 1; i < values.length; i++) {
                    int probability = Integer.parseInt(values[i].trim());
                    preyMap.put(hadersOrganism[i], probability);
                }
                eatingPossibilities.put(animal, preyMap);

            }
        } catch (Exception e) {
            throw new RuntimeException("Помилка при читанні таблиці ймовірностей ", e);
        }

    }

    public static int getChans(String predator, String pray) {

        return eatingPossibilities.getOrDefault(predator, Map.of())
                .getOrDefault(pray, 0);
    }
}
