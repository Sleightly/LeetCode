class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    updateGrid(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public static void updateGrid(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i > 0 && grid[i-1][j] == '1'){
            updateGrid(grid, i-1,j);
        }
        if (j < grid[0].length-1 && grid[i][j+1] == '1'){
            updateGrid(grid, i,j+1);
        } 
        if (j > 0 && grid[i][j-1] == '1'){
            updateGrid(grid, i,j-1);
        } 
        if (i < grid.length-1 && grid[i+1][j] == '1'){
            updateGrid(grid, i+1,j);
        }
    }
}