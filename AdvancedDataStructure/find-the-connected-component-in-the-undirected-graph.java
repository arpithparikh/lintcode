c class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public ArrayList<ArrayList<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashMap<UndirectedGraphNode, Boolean> visited = new HashMap<UndirectedGraphNode, Boolean>();
        for(UndirectedGraphNode node: nodes){
            visited.put(node, false);
        }
        for(UndirectedGraphNode node: nodes){
            if(visited.get(node) == false){
                bfs(node, result, visited);
            }
        }
        return result;
    }
    
    public void bfs(UndirectedGraphNode node, ArrayList<ArrayList<Integer>> result,  HashMap<UndirectedGraphNode, Boolean> visited){
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        visited.put(node, true);
        while(!queue.isEmpty()){
            UndirectedGraphNode crt = queue.poll();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(UndirectedGraphNode neighbor : crt.neighbors){
                if(visited.get(neighbor) == false){
                    visited.put(neighbor, true);
                    queue.offer(neighbor);
                }
            }
            result.add(list);
        }
    }
}
