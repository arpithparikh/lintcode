c class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        String[] array = s.split(" ");
        return helper(array, array.length-1);
    }
    public String helper(String[] array, int index){
        if(index < 0){
            return "";
        }
        return array[index] + " " + helper(array, index-1);
    }
}

