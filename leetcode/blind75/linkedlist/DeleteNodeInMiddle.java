package leetcode.blind75.linkedlist;



public class DeleteNodeInMiddle {



    public static ListNode deleteNodeInMiddle(ListNode head){
        if (head ==null ||head.next==null){
            return null;
        }

        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            len++;
        }

        if(len ==1){
            return null;
        }

        int mid = Math.floorDiv(len, 2);
        temp = head;

        for (int i =0; i<mid-1; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }


    public static ListNode deleteNodeInMiddle2(ListNode head){
        if (head ==null ||head.next==null){
            return null;
        }

        ListNode slow = head;
        ListNode faster = head;
        ListNode prev = null;

        while (faster!=null && faster.next!=null){
            prev = slow;
            slow = slow.next;
            faster = faster.next.next;
        }

        prev.next = slow.next;

        return head;
    }
}
