c class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        Arrays.sort(numbers);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                for(int k = j + 1; k < numbers.length; k++){
                    if(numbers[i] + numbers[j] + numbers[k] == 0){
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[k]);
                        if(!res.contains(list)){
                            res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }

}
