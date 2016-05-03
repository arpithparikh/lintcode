ass Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        int pl = 0;
        int pr = nums.length - 1;
        int i = 0;
        //point1: 这里不能用for,因为nums[i] 和nums[pr] 交换， i是不变的。
        while(i <= pr){
            if(nums[i] == 0){
                //point2 
                swap(nums, i, pl);
                pl++;
                i++;
            }else if(nums[i] == 1){
                i++;
            }else{
                swap(nums, i, pr);
                pr--;
            }
        }
    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
