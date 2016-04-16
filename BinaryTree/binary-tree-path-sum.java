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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        List<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        int sum = root.val;
        
        helper(root, target, sum, path, res);
        return res;
    }
    
    public void helper(TreeNode root, int target, int sum, List<Integer> path, List<List<Integer>> res){
        // meet the leaf
        if(root.left == null && root.right == null){//为什么这里是root.left && root.right
            if(sum == target){
                res.add(new ArrayList<Integer>(path));
            }else{
                return;
            }
        }
        
        //go left
        if(root.left != null){
            path.add(root.left.val);
            helper(root.left, target, sum + root.left.val, path, res);
            path.remove(path.size() -1);
        }
        
        if(root.right != null){
            path.add(root.right.val);
            helper(root.right, target, sum + root.right.val, path, res);
            path.remove(path.size() -1);
        }
        
        
    }
    
    
}
