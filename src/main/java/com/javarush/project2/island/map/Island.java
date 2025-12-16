package com.javarush.project2.island.map;

public class Island {
    private final int width;
    private final int height;
    private final Location[][] map;


    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new Location[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                map[x][y] = new Location();

            }
        }
    }

    public Location[][] getMap() {
        return map;
    }
    public Location getLocation(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IllegalArgumentException("Coordinates " + x + " // " + y +
                    " are outside the island " + width + "x" + height );
        }
        return map[x][y];
    }

    public int getWidth() {
       return width;
    }

    public int getHeight() {
        return height;
    }

}
