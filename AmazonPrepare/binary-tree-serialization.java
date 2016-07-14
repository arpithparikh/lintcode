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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null){
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        sb.append("{");
        while(!queue.isEmpty()){
            TreeNode crt = queue.poll();
            if(crt == null){
                sb.append("#,");
            }else{
                sb.append(crt.val + ",");
                queue.offer(crt.left);
                queue.offer(crt.right);
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data.equals("{}")){
            return null;
        }
        String[] array = data.substring(1, data.length()-1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.valueOf(array[0]));
        int index = 0;
        boolean leftChild = true;
        queue.add(root);
        for(int i = 1; i < array.length; i++){
            if(!array[i].equals("#")){
                TreeNode newNode = new TreeNode(Integer.valueOf(array[i]));
                queue.add(newNode);
                if(leftChild){
                    queue.get(index).left = newNode;
                }else{
                    queue.get(index).right = newNode;
                }
            }
            if(!leftChild){
                index++;
            }
            leftChild = !leftChild;
        }
        return root;
    }
}

