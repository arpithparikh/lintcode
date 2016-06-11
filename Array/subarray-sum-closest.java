ass Pair{
    int sum;
    int index;
    public Pair(int a, int b){
        sum = a; 
        index = b;
    }
}

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        int ans = Integer.MAX_VALUE;
        int len = nums.length;
        Pair[] sum = new Pair[len];
        sum[0] = new Pair(nums[0], 0);
        for(int i = 1; i < nums.length; i++){
            sum[i] = new Pair(nums[i] + sum[i-1].sum, i);
        }
        Arrays.sort(sum, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.sum - b.sum;
            }
        });
        for(int i = 1; i < len; i++){
            if(sum[i].sum - sum[i-1].sum < ans){
                ans = sum[i].sum - sum[i-1].sum;
                int[] temp = new int[2];
                temp[0] = sum[i-1].index;
                temp[1] = sum[i].index;
                Arrays.sort(temp);
                res[0] = temp[0]+1;
                res[1] = temp[1];
                
            }
        }
        return res;
    }
}

