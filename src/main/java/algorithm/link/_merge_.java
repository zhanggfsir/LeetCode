package algorithm.link;


 class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
/*
需求
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

 */
public class _merge_ {

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
        toString(node);
    }

    public static ListNode Merge0(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode current = newHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                // TODO
                current.next = list1;
                list1 = list1.next; // list1 赋值完毕，指针向后平移
            } else {
                // TODO
                current.next = list2;
                list2 = list2.next;
            }
            // TODO
            current = current.next;
        }

        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;
        return newHead.next;
    }


    public static void toString(ListNode head) {
        if (head == null) {
            System.out.println("EMPTY LIST!");
            return;
        }
        ListNode currNode = head;
        while (currNode.next != null) {
            System.out.print(currNode.val);
            System.out.print("->");
            currNode = currNode.next;
        }
        System.out.print(currNode.val);
        System.out.println();
    }
}



