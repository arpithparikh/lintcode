c class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        //f[i] means how many possible ways to reach position i
        if(n <= 1){
            return 1;
        }
        int[] f = new int[n];
        //initialization
        f[0] = 1;
        f[1] = 2;
        
        //function
        for(int i = 2; i < n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        
        return f[n-1];
    }
}
