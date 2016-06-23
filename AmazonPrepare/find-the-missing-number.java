c class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i && nums[i] < nums.length){
                int t = nums[i];
                nums[i] = nums[t];
                nums[t] = t;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }
}
