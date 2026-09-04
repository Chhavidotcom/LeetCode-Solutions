class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;

        while (true) {

            // 1. Find kth node
            ListNode kth = prevGroup;

            for (int i = 0; i < k; i++) {
                kth = kth.next;

                if (kth == null) {
                    return dummy.next;
                }
            }

            // 2. Save next group
            ListNode nextGroup = kth.next;

            // 3. Reverse current group
            ListNode prev = nextGroup;
            ListNode curr = prevGroup.next;

            while (curr != nextGroup) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // 4. Connect previous group
            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        }
    }
}