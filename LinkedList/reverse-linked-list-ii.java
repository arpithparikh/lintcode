tion for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if (m >= n || head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for(int i = 1; i < m; i++){
            if(head == null){
                return null;
            }
            head = head.next;
        }
        //reverse
        ListNode prem = head;
        ListNode mNode = head.next;
        ListNode nNode = head.next;
        ListNode postN = nNode.next;
        for(int i = m; i < n; i++){
            if (postN == null) {
                return null;
            }
            //这里重要！
            ListNode temp = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = temp;
        }
        //这两行特别重要
        mNode.next = postN;
        prem.next = nNode;
        return dummy.next;
    }
}
