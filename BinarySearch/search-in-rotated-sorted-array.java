c class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end){
            int mid = (start + end)/2;
            if(A[mid] == target){
                return mid;
            }
            //这一部分一共包含了4中情况
            //1. target and mid are both on red
            //2. target and mid are both on green
            //3. target on red and mid on green
            //4. target on green and mid on red
            
            //on red line
            if(A[start] < A[mid]){
                if(target >= A[start] && target <= A[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                //on green line
                if(target >= A[mid] && target <= A[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        if(A[start] == target){
            return start;
        }else if(A[end] == target){
            return end;
        }
        return -1;
    }
}

