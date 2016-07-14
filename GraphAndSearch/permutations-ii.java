ass Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.size()];
        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        helper(res, list, nums, visited);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, ArrayList<Integer> nums, boolean[] visited){
        if( list.size() == nums.size() && !res.contains(list)){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.size(); i++){
            if(visited[i] == true){
                continue;
            }
            visited[i] = true;
            list.add(nums.get(i));
            helper(res, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}

