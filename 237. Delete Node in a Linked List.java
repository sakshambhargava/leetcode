public class Solution {
     public void deleteNode(ListNode node) {
        if (node == null) return;
        ;
        if (node.next != null) {
            int nextValue = node.next.val;
            node.next = node.next.next;
            node.val = nextValue;
        }
    }
}
