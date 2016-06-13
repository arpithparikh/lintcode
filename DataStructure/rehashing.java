//这道题是hashtable 的基本原理
/**
 * Definition for ListNode
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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
       int capacity = hashTable.length * 2;
       ListNode[] newTable = new ListNode[capacity];
       for(int i = 0; i < hashTable.length; i++){
           while(hashTable[i] != null){
               int newIndex = (hashTable[i].val % capacity + capacity)%capacity;
               if(newTable[newIndex] == null){
                   newTable[newIndex] = new ListNode(hashTable[i].val);
               }else{
                   ListNode dummy = newTable[newIndex];
                   while(dummy.next != null){
                       dummy = dummy.next;
                   }
                   dummy.next = new ListNode(hashTable[i].val);
               }
               hashTable[i] = hashTable[i].next;
           }
       }
       return newTable;
    }
};

