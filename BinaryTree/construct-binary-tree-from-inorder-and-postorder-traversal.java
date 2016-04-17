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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        return helper(inorder, 0, inorder.length -1, postorder, 0, postorder.length - 1);
    }
    
    public int findPosition(int[] inorder, int istart, int iend, int key){
        for(int i = istart; i <= iend; i++){
            if(inorder[i] == key){
                return i;
            }
        }
        return -1;
    }
    
    public TreeNode helper(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend){
        if(istart > iend){
            return null;
        }
        int pos = findPosition(inorder, istart, iend, postorder[pend]);
        TreeNode root = new TreeNode(postorder[pend]);
        root.left = helper(inorder, istart, pos-1, postorder, pstart, pstart + pos - istart-1);
        root.right = helper(inorder, pos+1, iend, postorder, pstart + pos - istart, pend-1);
        
        return root;
    }
    
    
}
