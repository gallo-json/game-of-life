public class Grid {
    private static final int GRID_SIZE = 30;

    // Alternate between grid and nextGrid instead of creating new arrays every time
    private Tile[][] grid = new Tile[GRID_SIZE][GRID_SIZE];
    private Tile[][] nextGrid = grid.clone();

    public Grid() {
        // Populate grid with random alive and dead tiles
        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int col = 0; col < GRID_SIZE; ++col) grid[row][col] = new Tile(Math.random() > 0.5 ? true : false);
        }
    }

    private int countNeighbors(int x, int y) {
        int count = 0;
        for(int i = y - 1; i < y + 2; i++){
            if(i < 0 || i >= grid.length) continue;
            for(int j = x - 1; j < x + 2; j++){
                if (j < 0 || j >= grid[i].length || (x == j && y == i)) continue;
                if (grid[j][i].getState()) count++;
            }
        }
        return count;
    }

    public void update() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                int alive = countNeighbors(i, j);

                // Rules
                // Any live cell with fewer than two live neighbours dies, as if by underpopulation. AND
                // Any live cell with more than three live neighbours dies, as if by overpopulation.
                if (grid[i][j].getState() && (alive < 2 || alive > 3)) nextGrid[i][j].setState(false);

                // Any live cell with two or three live neighbours lives on to the next generation.
                else if (!grid[i][j].getState() && (alive == 3)) nextGrid[i][j].setState(true);

                // All other live cells die in the next generation. Similarly, all other dead cells stay dead.
                else nextGrid[i][j].setState(grid[i][j].getState());
            }
        }

        grid = nextGrid.clone();
    }

    public void show() {
        for (Tile[] x : grid) { 
            for (Tile y : x) System.out.printf("%s ", y.show());
            System.out.println();
        }
        System.out.println();
    }
}