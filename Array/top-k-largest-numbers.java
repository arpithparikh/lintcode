ass Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        int[] res = new int[k];
        Comparator<Integer> ElementComparator = new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b.intValue() - a.intValue();
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, ElementComparator);
        for(int i = 0; i < nums.length; i++){
            queue.offer(nums[i]);
        }
        for(int i = 0; i < k; i++){
            res[i] = queue.poll();
        }
        return res;
    }
};


