c class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here
        int row = board.length;
        if(row == 0) return;
        int col = board[0].length;
        if(col == 0) return;
        for(int i = 0; i < row; i++){
            bfs(board, i, 0);
            bfs(board, i, col-1);
        }
        for(int j = 1; j < col-1; j++){
            bfs(board, 0, j);
            bfs(board, row-1, j);
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                switch(board[i][j]){
                    case 'O':
                        board[i][j] = 'X';
                        break;
                    case 'F':
                        board[i][j] = 'O';
                }
            }
        }
    }
    public void bfs(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }
        if(board[i][j] == 'O'){
            board[i][j] = 'F';
            bfs(board, i+1, j);
            bfs(board, i-1, j);
            bfs(board, i, j+1);
            bfs(board, i, j-1);
        }
    }
}
