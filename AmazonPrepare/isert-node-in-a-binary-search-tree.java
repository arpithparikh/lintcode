//iterative method
c class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null){
            return node;
        }
        TreeNode dummy = root;
        TreeNode prev = null;
        while(root != null){
            prev = root;
            if(node.val > root.val){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        if(node.val < prev.val){
            prev.left = node;
        }else{
            prev.right = node;
        }
        return dummy;
    }
}
//recursion
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null){
            return node;
        }
        if(node.val < root.val){
            root.left = insertNode(root.left, node);
        }else{
            root.right = insertNode(root.right, node);
        }
        return root;
    }
}
