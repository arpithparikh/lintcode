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
     int single;
     int max;
     ReturnType(int a, int b){
         single = a;
         max = b;
     }
 }
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        return helper(root).max;
    }
    private ReturnType helper(TreeNode root){
        if(root == null){
            return new ReturnType(0, Integer.MIN_VALUE);
        }
        
        //divide
        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);
        
        //conquer
        //这一行非常关键，和0 的比较。
        int single = Math.max(0, Math.max(left.single,right.single) + root.val);
        //这一行是最关键的。
        int max = Math.max(Math.max(left.max, right.max), left.single+ right.single + root.val);
        
        return new ReturnType(single, max);
        
    }
}
