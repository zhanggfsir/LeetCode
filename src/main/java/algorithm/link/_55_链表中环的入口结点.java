package algorithm.link;

import algorithm.common.ListNode;

//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
// 结合图 会比较容易理解

/*
思路

1）设置快慢指针，都从链表头出发，快指针每次走两步，慢指针一次走一步，假如有环，一定相遇于环中某点(结论1)。
2）接着让两个指针分别从相遇点和链表头出发，两者都改为每次走一步，最终相遇于环入口(结论2)。

引入 a 环入口 b 相遇点 c
在相遇点
快指针路程=a+(b+c)k+b
慢指针路程=a+b
其中 快指针走的路程是慢指针的2倍
则有 a+(b+c)k+b=2*(a+b)
化简得到 a=(k-1)(b+c)+c   链表头到环入口的距离=相遇点到环入口的距离+（k-1）圈环长度。
当k=1 时 a=c 结论：两个指针分别从链表头和相遇点出发，最后一定相遇于环入口。

方法论
1.声明快慢指针 while循环快指针不为空且快指针下一个不为空；
快指针一次2步，慢指针一次1步；如果快慢指针相等，break--- 得到相遇点

2.慢指针指向头指针，while循环快指针不等于慢指针；
快指针一次2步，慢指针一次1步；得到入口结点。返回慢指针。
 */
public class _55_链表中环的入口结点 {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode fast=pHead;
        ListNode low=pHead;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            if(fast==low)  // 相遇点
                break;
        }

        if(fast==null||fast.next==null) //  万一没有环的情况
            return null;
        low=pHead;                      // 慢指针从头继续开始
        while(fast!=low){
            fast=fast.next;
            low=low.next;
        }
        return low;
    }

}
