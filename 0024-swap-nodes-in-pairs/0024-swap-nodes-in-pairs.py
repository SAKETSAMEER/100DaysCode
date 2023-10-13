
class Solution:
    def swapPairs(self,head:Optional[ListNode])->Optional[ListNode]:
        if not head or not head.next:
            return head

        head.next.next,head.next,head=head,self.swapPairs(head.next.next),head.next 
        return head  