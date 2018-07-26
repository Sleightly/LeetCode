class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        char[][] answer = new char[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O'){
                answer[i][0] = 'O';
                updateAnswer(board, answer, i, 0);
            }
            if (board[i][board[0].length-1] == 'O') {
                answer[i][board[0].length-1] = 'O';
                updateAnswer(board, answer, i, board[0].length-1);
            }
        }
        
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                answer[0][i] = 'O';
                updateAnswer(board, answer, 0, i);
            }
            if (board[board.length-1][i] == 'O') {
                answer[board.length-1][i] = 'O';
                updateAnswer(board, answer, board.length-1, i);
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (answer[i][j] == 'O'){
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';   
                }
            }
        }
    }
    
    public static void updateAnswer(char[][] grid, char[][] answer, int i, int j) {
        if (i > 0 && grid[i-1][j] == 'O'){
            answer[i-1][j] = 'O';
            grid[i-1][j] = 'X';
            updateAnswer(grid, answer, i-1, j);
        }
        if (j < grid[0].length-1 && grid[i][j+1] == 'O'){
            answer[i][j+1] = 'O';
            grid[i][j+1] = 'X';
            updateAnswer(grid, answer, i, j+1);
        } 
        if (j > 0 && grid[i][j-1] == 'O'){
            answer[i][j-1] = 'O';
            grid[i][j-1] = 'X';
            updateAnswer(grid, answer, i, j-1);
        } 
        if (i < grid.length-1 && grid[i+1][j] == 'O'){
            answer[i+1][j] = 'O';
            grid[i+1][j] = 'X';
            updateAnswer(grid, answer, i+1, j);
        }
    }
}