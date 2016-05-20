ass Pair{
    String value;
    int count;
    Pair(String a, int b){
        value = a;
        count = b;
    }
}
public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        Comparator<Pair> comparator = new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return b.count - a.count;
            }
        };
        // Write your code here
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])){
                map.put(words[i], map.get(words[i]) + 1);
            }else{
                map.put(words[i], 1);
            }
        }
        Queue<Pair> queue = new PriorityQueue<Pair>(map.size(), comparator);
        for(String word : map.keySet()){
            queue.add(new Pair(word, map.get(word)));
        }
        String[] res = new String[k];
        for(int i = 0; i < k; i++){
            Pair temp = queue.poll();
            res[i] = temp.value;
        }
        return res;
    }
}
