ass Element{
    int row;
    int col;
    int val;
    Element(int a, int b, int c){
        row = a;
        col = b;
        val = c;
    }
}
public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();
        if(arrays == null || arrays.length == 0 || arrays[0].length == 0){
            return res; 
        }
        Comparator<Element> comparator = new Comparator<Element>(){
            public int compare(Element a, Element b){
                return a.val - b.val;
            }
        };
       
        Queue<Element> queue = new PriorityQueue<Element>(arrays.length, comparator);
        for(int i = 0; i < arrays.length; i++){
            queue.add(new Element(i, 0, arrays[i][0]));
        }
        
        while(!queue.isEmpty()){
             Element elem = queue.poll();
             res.add(elem.val);
             if(elem.col < arrays[elem.row].length - 1){
                 Element temp = new Element(elem.row, elem.col + 1, arrays[elem.row][elem.col + 1]);
                 queue.add(temp);
             }
        }
        return res;
       
    }
}
