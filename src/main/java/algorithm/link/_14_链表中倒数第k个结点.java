package algorithm.link;

/*
输入一个链表，输出该链表中倒数第k个结点。
 */
//class ListNode14 {
//    int val;
//    ListNode next = null;
//
//    ListNode14(int val) {
//        this.val = val;
//    }
//}


import algorithm.common.ListNode;

import java.util.Stack;

public class _14_链表中倒数第k个结点 {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;

        System.out.println(FindKthToTail(listNode1,4).val);

    }

    //  常规解法，挺好。使用Stack，将结点压入栈中，再取出第k个就好
    // 思路 1.while不为null循环全部入栈 2.for循环i<k 弹出返回
    /*
    注意
push 的值 其实仍然是一个一个链表
1->2->3->4->5
1->2->3->4->5
2->3->4->5
3->4->5
4->5
5

pop的值  链表倒过来的】】
5
4->5
3->4->5
2->3->4->5
     */
    public static ListNode FindKthToTail(ListNode head, int k) { //5,{1,2,3,4,5}
//        ListNode.toString(head);
        if(head == null || k ==0 ){
            return null;
        }
        //可以先把链表反转，然后找出第k个
        Stack<ListNode> stack = new Stack<ListNode>();
        int count = 0;
        while(head != null){
            stack.push(head);               // ListNode.toString(head);
            head = head.next;
            count++;
        }

        if(count < k){  // 有一个k来计数 挺好
            return null;
        }
        System.out.println("---------pop------------");
        ListNode knode = null;
        for(int i = 0; i < k; i++){
            knode = stack.pop();            // ListNode.toString(knode);
        }
        return knode;
    }

    /*
    方法论： 快慢指针
    申明快慢指针 快指针for循环先跑i个 快指针不为空快慢指针一起跑
    思路: 1.声明快慢指针为head 2.for循环快指针先走k个 3.while循环快指针不为空穷举快慢指针，返回慢指针

   解释 ：快指针先跑出k个，慢指针再跑。 快指针比慢指针快了k个。
   当快指针跑到了末尾，仍然比慢指针快k了
   慢指针即为求解
    */
    public static ListNode FindKthToTail2(ListNode head, int k) { //5,{1,2,3,4,5}
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head;       // 声明快慢指针
        ListNode slow = head;
        for (int i = 1; i < k; i++) {   // 快指针先走k个 。i从1开始，相当于i=0时，已经赋值 ListNode fast = head;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null) {    // 快慢指针一起走，直到快指针走到头
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    /* 同上
    这个思想给1w个赞！！
    首先定义两个指向链表头的指针p  ,q;
    指针p和q都先指向开始的节点，p一直向后走，而q等到p走了k步再开始向后走，从这个时刻起p总是领先q k个位置，当p走到终点时，q走到了倒数第k个节点。
    p先走k步，q再走，这样p和q的距离就是k了，等p走到尽头，那么q自然就到了倒数第k个位置了。其实p和q就是相当于一把尺子，长度为k，尺子的尾部是p，头部为q。

    输入一个链表，输出该链表中倒数第k个结点。
     */
    public static ListNode FindKthToTail3(ListNode head, int k) { //5,{1,2,3,4,5}
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k) // 当快指针跑了i个，慢指针才开始跑
                q = q.next;
            p = p.next;
        }
        return i < k ? null : q;
    }


}
