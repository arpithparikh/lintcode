c class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < num.length; i++){
            set.add(num[i]);
        }
        int longest = Integer.MIN_VALUE;
        for(int i = 0; i < num.length; i++){
            int current = num[i];
            int up = current + 1;
            int down = current - 1;
            while(set.contains(up)){
                up++;
            }
            while(set.contains(down)){
                down--;
            }
            longest = up - down - 1 > longest ? up - down - 1 : longest;
        }
        return longest;
    }
}
