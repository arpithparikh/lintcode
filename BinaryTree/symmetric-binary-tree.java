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
     * @param root, the root of binary tree.
     * @return true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if(root == null){
            return true;
        }
        return helper(root.left, root.right);
    }
    boolean helper(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;//这里比较关键
        }
        return helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }
}
