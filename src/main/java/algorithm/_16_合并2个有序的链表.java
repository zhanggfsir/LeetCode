package algorithm;


import algorithm.common.ListNode;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/*
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

 */
public class _16_合并2个有序的链表 {
    public static void main(String[] args) {
        ListNode listNode0=new ListNode(0);
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode0.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;

        ListNode listNode_1=new ListNode(1);
        ListNode listNode_2=new ListNode(2);
        ListNode listNode_3=new ListNode(3);
        ListNode listNode_4=new ListNode(4);
        ListNode listNode_5=new ListNode(5);
        listNode_1.next=listNode_2;
        listNode_2.next=listNode_3;
        listNode_3.next=listNode_4;
        listNode_4.next=listNode_5;
        ListNode node=Merge0(listNode0,listNode_1);
        ListNode.toString(node);
    }


    //非递归简洁版，傻子都能看懂哦
        public static ListNode Merge0(ListNode list1,ListNode list2) {
            ListNode newHead = new ListNode(-1);
            ListNode current = newHead;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    current.next = list1;
                    list1 = list1.next;
                } else {
                    current.next = list2;
                    list2 = list2.next;
                }
                current = current.next;
            }
            if (list1 != null) current.next = list1;
            if (list2 != null) current.next = list2;
            return newHead.next;
        }
    //递归解法 参考高票答案
        public static ListNode Merge1(ListNode list1,ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;
            if (list1.val < list2.val) {
                list1.next = Merge1(list1.next, list2);
                return list1;
            } else {
                list2.next = Merge1(list1, list2.next);
                return list2;
            }
        }

    public static ListNode Merge2(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode mergeHead = null;
        ListNode current = null;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                if(mergeHead == null){
                    mergeHead = current = list1;
                }else{
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            }else{
                if(mergeHead == null){
                    mergeHead = current = list2;
                }else{
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null){
            current.next = list2;
        }else{
            current.next = list1;
        }
        return mergeHead;
    }
}
