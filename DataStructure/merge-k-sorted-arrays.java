class Element{
    int row;
    int col;
    int val;
    public Element(int a, int b, int c){
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
        List<Integer> list = new ArrayList<Integer>();
        if(arrays == null){
            return list;
        }
        Comparator<Element> comparator = new Comparator<Element>(){
            public int compare(Element a, Element b){
                return a.val - b.val;
            }
        };
       PriorityQueue<Element> queue = new PriorityQueue<Element>(arrays.length, comparator);
     
        for(int i = 0; i < arrays.length; i++){
            if(arrays[i].length > 0){//important
                queue.add(new Element(i, 0, arrays[i][0]));
            }
        }
        
        while(!queue.isEmpty()){
            Element elem = queue.poll();
            list.add(elem.val);
            int row = elem.row;
            int col = elem.col;
            if(col+1 < arrays[row].length){
                queue.add(new Element(row, col+1, arrays[row][col+1]));
            }
        }
        return list;
    }
}}
