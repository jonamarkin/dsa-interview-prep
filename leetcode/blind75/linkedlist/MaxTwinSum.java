package leetcode.blind75.linkedlist;

public class MaxTwinSum {

    /*
    In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

    For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
    The twin sum is defined as the sum of a node and its twin.

    Given the head of a linked list with even length, return the maximum twin sum of the linked list.
     */

    public int pairSum(ListNode head) {
        if(head==null || head.next==null){
            return 0;
        }

        //Find the middle
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseList(slow);

        ListNode firstHalf = head;
        int maxTwinSum = 0;

        while(secondHalf!=null){
            maxTwinSum = Math.max(maxTwinSum, firstHalf.val + secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return maxTwinSum;

    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        return prev;
    }
}
