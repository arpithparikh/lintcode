tion for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                if(map.containsKey(neighbor)){
                    map.put(neighbor, map.get(neighbor) + 1);
                }else{
                    map.put(neighbor, 1);
                }
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        for(DirectedGraphNode node: graph){
            if(!map.containsKey(node)){
                queue.offer(node);//record the neighbors
                res.add(node);
            }
        }
        while(!queue.isEmpty()){
            DirectedGraphNode node = queue.poll();
            for(DirectedGraphNode neighbor : node.neighbors){
                map.put(neighbor, map.get(neighbor) - 1);
                if(map.get(neighbor) == 0){
                    res.add(neighbor);
                    queue.offer(neighbor);//important
                }
            }
        }
        return res;
        
    }
}
