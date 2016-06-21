ci
//这个题是两个stack，来做，然后有reverse标记。
 class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        boolean reverse = false;
        currentLevel.push(root);
        while(!currentLevel.isEmpty()){
            int size = currentLevel.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode crt = currentLevel.pop();
                level.add(crt.val);
                if(reverse){
                    if(crt.right != null){
                        nextLevel.push(crt.right);
                    }
                    if(crt.left != null){
                        nextLevel.push(crt.left);
                    }
                }else{
                    if(crt.left != null){
                        nextLevel.push(crt.left);
                    }
                    if(crt.right != null){
                        nextLevel.push(crt.right);
                    }
                }
            }
            result.add(level);
            reverse = !reverse;
            
            Stack<TreeNode> tmp = nextLevel;
            nextLevel = currentLevel;
            currentLevel = tmp;
        }
        return result;
    }
}
