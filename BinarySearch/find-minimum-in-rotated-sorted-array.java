c class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length == 0){
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        //这道题其实在找第一个 <= end element的数字
        int target = num[end];
        while(start + 1 < end){
            int mid = (start + end) / 2;
            if(num[mid] > target){
                start = mid;//because the array is rotated.
            }else{
                end = mid;//because the array is rotated.
            }
        }
        //不要忘记等号
        if(num[start] <= target){
            return num[start];
        }
        if(num[end] <= target){
            return num[end];
        }
        return -1;
    }
}
