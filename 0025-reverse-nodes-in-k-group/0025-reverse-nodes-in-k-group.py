class Solution:
    def rev(self,head,k):
        prev = None
        temp = k
        thead = head
        while thead:
            thead = thead.next
            temp-=1
        if temp>0:
            return head,None,None,False
        tail = head
        while head and k>0:
            k-=1
            cur = head.next
            head.next = prev
            prev = head
            head = cur
        return prev,tail,head,True

    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        h,t,n,f = self.rev(head,k)
        while f:
            hh,tt,nn,f=self.rev(n,k)
            t.next=hh
            t = tt
            n = nn
        return h