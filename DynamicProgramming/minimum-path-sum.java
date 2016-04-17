c class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];
        
        //initialization
        for(int i = 1; i < m; i++){
            f[i][0] = f[i-1][0] + grid[i][0];
        }
        for(int j = 1; j < n; j++){
            f[0][j] = f[0][j-1] + grid[0][j];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + grid[i][j];
            }
        }
        
        return f[m-1][n-1];
    }
}

