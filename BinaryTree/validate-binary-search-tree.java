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
 class ReturnType{
     boolean isBST;
     int min;
     int max;
     ReturnType(boolean a, int b, int c){
         isBST = a;
         min = b;
         max = c;
     }
 }
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return helper(root).isBST;
    }
    
    private ReturnType helper(TreeNode root){
        if(root == null){
            return new ReturnType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
            //这行有三个点，很容易出错。
        }
        
        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);
        
        if(!left.isBST || !right.isBST){
            return new ReturnType(false, 0, 0);
        }
        
        if(root.left != null && left.max >= root.val || root.right != null && right.min <= root.val){
            return new ReturnType(false, 0, 0);
        }
        
        return new ReturnType(true,
                              Math.min(root.val, left.min),
                              Math.max(root.val, right.max));
    }
}
