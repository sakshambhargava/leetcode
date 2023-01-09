# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        slow = fast = head
        # Do a loop using
        # slow and fast pointers 
        while fast and fast.next:
            # Move slow and fast 1
            # and 2 steps ahead
            # respectively.
            slow = slow.next
            fast = fast.next.next
            # slow == fast mean loop exist
            if slow == fast:
                slow1 = head
                # If loop exists. Start slow1 from
                # head and fast from meeting point.
                while slow1 != fast:
                    slow1 = slow1.next
                    fast = fast.next
                return slow1

        return None
