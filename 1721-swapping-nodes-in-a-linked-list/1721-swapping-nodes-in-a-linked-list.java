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
    public ListNode swapNodes(ListNode head, int k) {
        ArrayList<Integer> list=new ArrayList<>();
          ListNode temp=head;
          while(temp!=null){
              list.add(temp.val);
              temp=temp.next;
          }

        int x=list.get(k-1);
        int y=list.get(list.size()-k);
          list.set(k-1,y);
          list.set(list.size()-k,x);
          ListNode dum=new ListNode();
          ListNode jh=dum;
        for(int i=0;i<list.size();i++){
              ListNode t=new ListNode(list.get(i));
              jh.next=t;
              jh=jh.next;
        }
     return dum.next;
    }
}