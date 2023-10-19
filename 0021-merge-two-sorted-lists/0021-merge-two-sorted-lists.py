class Solution:
    def mergeTwoLists(self,list1:List[int],list2:List[int]) -> List[int]:
        dummy = ListNode() ##dummy node
        temp = dummy ## pointer to traverse in dummy node
        while list1 and list2:
            if list1.val<list2.val:
                temp.next = list1
                list1 = list1.next
            else:
                temp.next = list2
                list2 = list2.next
            temp = temp.next
        if list1:
            temp.next = list1
            list1 = list1.next
        if list2:
            temp.next = list2
            list2 = list2.next
        return dummy.next
       