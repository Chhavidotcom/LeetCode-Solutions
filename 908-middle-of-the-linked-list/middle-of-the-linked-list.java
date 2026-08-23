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
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;

while(temp != null) {
    count++;
    temp = temp.next;

}

if(count % 2 == 0) {
    ListNode temp2 = head;
    for(int i =0;i<count/2 && temp2!=null ;i++){
        temp2=temp2.next;
    }

    return temp2;
    
} else {
    ListNode temp3 = head;
    for(int i =0;i<count/2  && temp3!= null ;i++){
        temp3=temp3.next;
    }

    return temp3;
}
    }
}