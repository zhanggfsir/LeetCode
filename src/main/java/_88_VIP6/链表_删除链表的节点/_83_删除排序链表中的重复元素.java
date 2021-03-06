package _88_VIP6.链表_删除链表的节点;


import algorithm.common.ListNode;

public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
