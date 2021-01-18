package _88_VIP6.链表归类.链表归类dummyHead;


import algorithm.common.ListNode;

public class _83_删除排序链表中的重复元素_可在第二次记忆 {
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

    //  _83_删除排序链表中的重复元素 虚拟头指针版 如下也是可以的 ，就是dummy为-2 跳过官方测试用例的 0 -1 哈哈哈 ~
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy=new ListNode(-2);
        dummy.next=head;
        ListNode cur=head;

        while (cur.next!=null){
            if (cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else {
                cur=cur.next;
            }
        }
                return dummy.next;
    }


    }
