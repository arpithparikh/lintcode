//解法1:dfs
public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
     boolean result = false;
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here  
        ArrayList<String> list = new ArrayList<String>();
        helper(s, dict, 0, list);
        return result;
    }
    public void helper(String s, Set<String> dict, int start, ArrayList<String> list){
        if(start == s.length()){
            result = true;
            return;
        }
        for(int i = start+1; i < s.length()+1; i++){
            String prefix = s.substring(start, i);
            if(!dict.contains(prefix)){
                continue;
            }
            list.add(prefix);
            helper(s, dict, i, list);
            list.remove(list.size() - 1);
        }
    }
    
}

//解法2: dp

