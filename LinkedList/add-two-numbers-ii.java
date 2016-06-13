tion for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */

//这道题要注意：三种情况，l1 not null, l2 not null, count not zero

public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        ListNode list1 = reverse(l1); 
        ListNode list2 = reverse(l2); 
        return reverse(add(list1, list2));
        
    }  
    public ListNode add(ListNode l1, ListNode l2){
        ListNode tail1 = l1;
        ListNode tail2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int count = 0;
        while(tail1 != null && tail2 != null){
            int sum = tail1.val + tail2.val + count;
            int digit = sum % 10;
            count = sum/10;
            tail.next = new ListNode(digit);
            tail = tail.next;
            tail1 = tail1.next;
            tail2 = tail2.next;
        }
        while(tail1 != null){
            int sum = tail1.val + count;
            int digit = sum % 10;
            count = sum /10;
            tail.next = new ListNode(digit);
            tail = tail.next;
            tail1 = tail1.next;
        }
        while(tail2 != null){
            int sum = tail2.val + count;
            int digit = sum % 10;
            count = sum /10;
            tail.next = new ListNode(digit);
            tail = tail.next;
            tail2 = tail2.next;
        }
        while(count != 0){
            int sum = count;
            int digit = sum % 10;
            count = sum /10;
            tail.next = new ListNode(digit);
            tail = tail.next;
        }
        
        return dummy.next;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}
