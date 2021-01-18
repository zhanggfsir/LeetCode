package _88_VIP6.链表归类.链表归类dummyHead;

import high_frequency.link.Link.ListNode;

//  快慢指针
//      如果快指针先到达 null ，意味着没有环；
//      如果他们能相遇，则他们 有环
//  todo  快慢指针 一次走2步
public class _141_环形链表_LinkedListCycle {

    //  环形链表 虚拟头指针版
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next==null)
            return false;

        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode fast = dummy.next;
        ListNode slow = dummy;


        while ( fast != null && fast.next != null){
            if(slow == fast ) //相遇了
                return true;
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }




        // 到尾了，还没有相遇。 直接    return false
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next==null)
                return false;

            ListNode slow = head;
            ListNode fast = head.next;
            while ( fast != null && fast.next != null){
                if(slow == fast ) //相遇了
                    return true;
                slow=slow.next;
                fast=fast.next.next;
            }
            return false;
        }





}
