public class Grid {
    private static final int GRID_SIZE = 25;

    private Tile[][] grid = new Tile[GRID_SIZE][GRID_SIZE];
    private Tile[][] nextGrid = grid.clone();

    public Grid() {
        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int col = 0; col < GRID_SIZE; ++col) grid[row][col] = new Tile(Math.random() > 0.5 ? true : false);
        }
    }

    private Tile[] countNeighbors(int x, int y) {
        // Will clean this up later

        Tile[] neighbors = {
                            grid[x-1][y-1], grid[x][y-1], grid[x+1][y-1],
                            grid[x-1][y],                 grid[x+1][y],
                            grid[x-1][y+1], grid[x][y+1], grid[x+1][y+1]
                        };

        return neighbors;
    }

    public void show() {
        for (Tile[] x : grid) { 
            for (Tile y : x) System.out.print(y.show() + " ");
            System.out.println();
        }
        System.out.println();

        //Test
        for (Tile x : countNeighbors(1, 1)) System.out.print(x.show() + " ");
    }
}