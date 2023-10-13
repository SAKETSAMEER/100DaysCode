class Solution {
  public ListNode deleteMiddle(ListNode head) {
    ListNode fh = new ListNode(-1, head), fast;
    
    for(fast = head = fh; fast.next != null && (fast = fast.next.next) != null; ) head = head.next;
    head.next = head.next.next;
    
    return fh.next;
  }
}