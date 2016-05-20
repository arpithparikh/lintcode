ass Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        ArrayList<Integer> ugly = new ArrayList<Integer>();
        int p1 = 0, p2 = 0, p3 = 0;
        int min1, min2, min3;
        int cur = 2;
        ugly.add(1);
        while(ugly.size() < n){
            while(ugly.get(p1) * 2 < cur){
            p1++;
            }
            min1 = ugly.get(p1)*2;
            
            while(ugly.get(p2) * 3 < cur){
                p2++;
            }
            min2 = ugly.get(p2)*3;
            
            while(ugly.get(p3) * 5 < cur){
                p3++;
            }
            min3 = ugly.get(p3)*5;
            
            int min = min1 < min2 ? min1 : min2;
            min = min < min3 ? min : min3;
            ugly.add(min);
            cur = min + 1;
        }
        return ugly.get(n-1);
    }
};

