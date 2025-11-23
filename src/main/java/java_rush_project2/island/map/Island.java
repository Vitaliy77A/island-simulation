package java_rush_project2.island.map;

public class Island {
    private final int widht;
    private final int height;
    private final Location[][] map;


    public Island(int widht, int height) {
        this.widht = widht;
        this.height = height;
        this.map = new Location[widht][height];

        for (int x = 0; x < widht; x++) {
            for (int y = 0; y < height; y++) {
                map[x][y] = new Location();

            }
        }
    }

    public Location[][] getMap() {
        return map;
    }
    public Location getLocation(int x, int y) {
        if (x < 0 || x >= widht || y < 0 || y >= height) {
            throw new IllegalArgumentException("оординати " + x + " // " + y +
                    " знаходяться за межами острова " + widht + "x" + height );
        }
        return map[x][y];
    }

    public int getWidht() {
        return map.length;
    }

    public int getHeight() {
        return map[0].length;
    }


}
