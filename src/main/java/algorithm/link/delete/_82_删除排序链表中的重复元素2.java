package algorithm.link.delete;

import algorithm.common.ListNode;

/*

给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3

 */
public class _82_删除排序链表中的重复元素2 {

    /*

 快慢指针,用快指针跳过那些有重复数组,慢指针负责和快指针拼接!
     */
    public  static ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null || pHead.next==null){return pHead;}
        ListNode dummyHead = new ListNode(0); // Head 是 新链表
        dummyHead.next = pHead;                    // pHead 是 老的链表
        ListNode slow = dummyHead;
        ListNode fast = dummyHead.next;
        while (fast!=null){
            if(fast.next!=null && fast.val == fast.next.val){ // 如果当前节点的值和下一个节点的值相等
                // 找到最后的一个相同节点
                while (fast.next!=null && fast.val == fast.next.val){
                    fast = fast.next;
                }
                slow.next = fast.next;
                fast = fast.next;
            }else{
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummyHead.next;
    }


}
