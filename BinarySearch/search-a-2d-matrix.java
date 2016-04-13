c class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        //to check the precondition
        if(matrix == null || matrix.length == 0){
            return false;
        }
        //row size means the size of the matrix and column size is the column of the matrix.
        int row = matrix.length;
        int col=matrix[0].length;
        //row index
        int start = 0;
        int end = row-1;
        while(start + 1 < end ){
            int mid = start + (end-start)/2;
            if(matrix[mid][0] == target){
                return true;
            }else if(matrix[mid][0] < target){
                start = mid;
            }else{
                end=mid;
            }
        }
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }
        //column index
        start=0;
        end=col-1;
          while(start + 1 < end ){
            int mid = start + (end-start)/2;
            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid] < target){
                start = mid;
            }else{
                end=mid;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        } else if (matrix[row][end] == target) {
            return true;
        }
        return false;
    }

    
    
}

