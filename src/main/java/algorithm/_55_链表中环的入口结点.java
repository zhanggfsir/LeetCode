package algorithm;

import algorithm.common.ListNode;

//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
// 结合图 会比较容易理解

/*
思路

1）设置快慢指针，都从链表头出发，快指针每次走两步，慢指针一次走一步，假如有环，一定相遇于环中某点(结论1)。
2）接着让两个指针分别从相遇点和链表头出发，两者都改为每次走一步，最终相遇于环入口(结论2)。
 */
public class _55_链表中环的入口结点 {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode low=pHead;
        ListNode fast=pHead.next;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            if(fast==low)
                break;

        }
        if(fast==null||fast.next==null)
            return null;
        low=pHead;
        while(fast!=low){
            fast=fast.next;
            low=low.next;
        }
        return low;
    }

}
