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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        return helper(preorder, 0, preorder.length -1, inorder, 0, inorder.length -1);
        
    }
    public TreeNode helper(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend){
        if(istart > iend){
            return null;
        }
        int pos = findPosition(inorder, istart, iend, preorder[pstart]);
        TreeNode root = new TreeNode(preorder[pstart]);
        
        root.left = helper(preorder, pstart + 1, pstart + pos - istart, inorder, istart,  pos-1);
        //point1: 坐标容易错
        root.right = helper(preorder, pend + pos - iend + 1, pend, inorder, pos + 1, iend);
        
        return root;
    }
    //point2: 注意是从 start 开始， <= end
    public int findPosition(int[] inorder, int istart, int iend, int key){
        for(int i = istart; i <= iend; i++){
            if(inorder[i] == key){
                return i;
            }
        }
        return -1;
    }
}
