/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }

        int deleteIndex = count- n;
        if(deleteIndex == 0) {
    return head.next;
}
        ListNode temp2=head;
       
        for(int i =0;i<deleteIndex-1 ;i++){
            temp2=temp2.next;
           
        }
     temp2.next= temp2.next.next;

return head;
        
    }
}