tion for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        mergeHelper(lists, start, end);
    }
    mergeHelper(lists, start, end){
        if(start > end){
            return null;
        }
        int mid = (start + end);
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lsits, mid, end);
        merge(left, right);
    }
}

