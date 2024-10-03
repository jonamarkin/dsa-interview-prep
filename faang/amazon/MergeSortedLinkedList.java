package faang.amazon;

import java.util.List;

public class MergeSortedLinkedList {
    /*
    You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists into one sorted linked list and return the head of the merged list.
    The merged list should be made by splicing together the nodes of the two input lists.
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // your solution here

        ListNode dummy = new ListNode(1);
        ListNode current = dummy;

        while(list1!=null && list2!=null){
            if (list1.val<=list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }


        if (list1!=null){
            current.next = list1;
        }else{
            current.next = list2;
        }

        return dummy.next;

    }
}
