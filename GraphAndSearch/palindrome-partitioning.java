c class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public ArrayList<ArrayList<String>> partition(String s) {
        // write your code here
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(s == null){
            return res;
        }
        
        ArrayList<String> list = new ArrayList<String>();
        
        helper(res, list, s, 0);
        
        return res;
    }
    
    public void helper(ArrayList<ArrayList<String>> res, ArrayList<String> list, String s, int pos){
        if(isPalindrome(list)){
            res.add(new ArrayList<String>(list));
        }
        
        for(int i = pos; i < s.length(); i++){
            list.add(s.substring(i,i+1));
            helper(res, list, s, i+1);
            list.remove(list.size() - 1);
        }
    }
    
    public boolean isPalindrome(ArrayList<String> list){
        
        int start = 0;
        int end = list.size() - 1;
        while(start < end){
            if(!list.get(start).equals(list.get(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
