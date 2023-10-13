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
    public ListNode removeElements(ListNode head, int value) {  
        if(head==null){
            return head;
        }  
        while (head!=null&&head.val==value){   // There we check if all number are same for an example {value = 3} and this is the linklist {3 -> 3 -> 3 -> 3 ->3 } so in that case we have to remove all those element right.
            head=head.next;
            if(head==null){  // After traverse if we arive in the null pointer, that mean we dont have any another element, right so we have to return null. 
                return null;
            }
        }
        
        ListNode pointer=head;
        while (pointer.next!=null){
            if(pointer.next.val==value){   // There we check the node value they are some or not.
                pointer.next=pointer.next.next;   // If same when we take next pointer address and paste the address in (pointer -> next ) pointer.
            }else{
                pointer=pointer.next;   // If not same we have move forward one by one.
            }
        }
        return head;

        
    }
}