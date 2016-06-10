/**
 * Definition for Directed graph.
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
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        //存入每个点前继节点的个数
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        for(DirectedGraphNode node: graph){
            for(DirectedGraphNode neighbor: node.neighbors){
                if(map.containsKey(neighbor)){
                    map.put(neighbor, map.get(neighbor) + 1);
                }else{
                    map.put(neighbor, 1);
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        //加入没有前继节点的点
        for(DirectedGraphNode node: graph){
            if(!map.containsKey(node)){
                q.offer(node);
                result.add(node);
            }
        }
        while(!q.isEmpty()){
            DirectedGraphNode node = q.poll();
            for(DirectedGraphNode n: node.neighbors){
                map.put(n, map.get(n) -1);
                if(map.get(n) == 0){
                    result.add(n);
                    q.offer(n);
                }
            }
        }
        return result;
    }
}
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
