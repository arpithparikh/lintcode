c class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    int left = 0;
	    int right = nums.length - 1;
	    for(; left <= right; left++){
	        if(nums[left] < k){
	           continue;
	        }
	        while(right >= left && nums[right] >= k){
	            right--;
	        }
	        if(right >= 0 && left < right){
	            int temp = nums[right];
	            nums[right] = nums[left];
	            nums[left] = temp;
	            right--;
	        }
	    }
	    return right + 1;
    }

}

//solution two:
public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    int left = 0;
	    int right = nums.length - 1;
	    while(left <= right){
	        if(nums[left] < k){
	            left++;
	        }else{
	            while(nums[right] >= k && right > left){
	                right--;
	            }
	            swap(nums, left, right);
	            right--;
	        }
	    }
	    return right + 1;
    }
    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
