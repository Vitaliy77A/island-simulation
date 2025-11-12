package java_rush_projectt2.island.map;

public class Island {
    private final int widht;
    private final int height;
    private final Location[][] map;

    public Island(int widht, int height) {
        this.widht = widht;
        this.height = height;
        this.map = new Location[height][widht];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < widht; x++) {
                map[y][x] = new Location();

            }
        }
    }

    public Location getLocation(int x, int y) {
        return map[y][x];
    }

    public int getWidht() {
        return map.length;
    }

    public int getHeight() {
        return map[0].length;
    }
    public void step() {
        System.out.println("Новая симуляция");
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                System.out.println("\nКлетка [" + y + "," + x + "]");
                Location location = map[y][x];
                location.printResidents();
                location.movementOrganism();
            }
        }
    }
}
