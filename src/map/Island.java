package map;

public class Island {
        private final int width;
        private final int height;
        private final Location[][] grid;

        public Island(int width, int height) {
            this.width = width;
            this.height = height;
            this.grid = new Location[height][width];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    grid[y][x] = new Location(x, y);
                }
            }
        }

        public Location[][] getGrid() {
            return grid;
        }

        public Location getLocation(int x, int y) {
            if (x >= 0 && x < width && y >= 0 && y < height) {
                return grid[y][x];
            }
            return null;
        }
}
