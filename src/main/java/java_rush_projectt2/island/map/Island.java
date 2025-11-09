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
        if (y < 0 || y >= height || x < 0 || x >= widht) {
throw new IllegalArgumentException("Out of bounds " + x + "," + y);
        }
        return map[y][x];
    }
}
