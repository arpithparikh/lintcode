ass Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] A, int target) {
        //write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(target == A[mid]){
                end = mid;
            }
            if(target < A[mid]){
                end = mid;
            }
            if(target > A[mid]){
                start = mid;
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
