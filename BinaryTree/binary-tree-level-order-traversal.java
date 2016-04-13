tion of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //point 1: 要先把第一个root加进去。
        queue.offer(root);
        while(!queue.isEmpty()){
            //point 2:重建level
            ArrayList<Integer> level = new ArrayList<Integer>();
            
            int size = queue.size();
            //point3: 历遍level的element,然后加进新的element.
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
                level.add(current.val);
            }
            //point4: 加进res里面
             res.add(level);
            }
           
           return res;
        }
        
    
}
