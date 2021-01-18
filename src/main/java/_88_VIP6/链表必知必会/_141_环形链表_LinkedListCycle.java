package _88_VIP6.链表必知必会;

import algorithm.common.ListNode;

//  快慢指针
//      如果快指针先到达 null ，意味着没有环；
//      如果他们能相遇，则他们 有环
public class _141_环形链表_LinkedListCycle {
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
