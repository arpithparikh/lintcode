//这道题是问乘积最大子序列，我所求的是乘积最大的子
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
     static int max;
    public static int maxProduct(int[] nums) {
	    // write your code here
	    ArrayList<Integer> res = new ArrayList<Integer>();
	   max = Integer.MIN_VALUE;
	    helper(res, nums, 0);
	    return max;
	}
	public static int helper(ArrayList<Integer> res, int[] nums, int pos){
	    if(multiply(res) > max){
	        max = multiply(res);
	        //System.out.println(max);
	    }
	    for(int i = pos; i < nums.length; i++){
	        res.add(nums[i]);
	        helper(res, nums, i + 1);
	        res.remove(res.size() - 1);
	    }
	    return max;
	}
	public static int multiply(ArrayList<Integer> list){
	    if(list == null || list.size() == 0){
	        return Integer.MIN_VALUE;
	    }
	    int res = 1;
	    for(int i = 0; i < list.size(); i++){
	        res = res * list.get(i);
	    }
	    return res;
	}
}
