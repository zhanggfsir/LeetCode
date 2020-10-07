package algorithm;

import algorithm.common.ListNode;

/*
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

注意 ： 是删除‘存在重复的节点’的所有节点，而不是‘去重’
 */
public class _56_删除链表中重复的结点 {
    public static void main(String[] args) {
        ListNode listNode0=new ListNode(1);
        ListNode listNode1=new ListNode(2);
        ListNode listNode2=new ListNode(3);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode0.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        ListNode.toString(deleteDuplication(listNode0));
    }

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



    //Java版递归
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null) return null;
        if (pHead.next == null) return pHead;
        ListNode cur;

        //对重复结点的处理
        if (pHead.val == pHead.next.val) {
            cur = pHead.next.next;
            //遍历到没有重复结点的位置
            while (cur != null && cur.val == pHead.val) {
                cur = cur.next;
            }
            return deleteDuplication2(cur);
        }

        //该结点不重复，递归下一个结点
        cur = pHead.next;
        pHead.next = deleteDuplication2(cur);
        return pHead;
    }

}
