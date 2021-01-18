package _88_VIP6.链表必知必会.链表继续必知必会;
import algorithm.common.ListNode;

import java.util.HashMap;
import java.util.Stack;

/*
输入两个链表，找出它们的第一个公共结点。


常识
单链表，所以肯定相交有公共末尾 只有一个next指针，说明公共节点的值和next都是一样的，所以一定会有公共的尾部。
当有公共点之后，两个链表就合成一条了
原来公共结点的意思是两个链表相遇之后后面都是一样的，我还以为是交叉的两个链表。不会是交叉的

故如下场景不成立
如果一个链表结点值是1,2,3,6.7  另一个是4,6,5,8 怎么理解
假设不成立。如果6是公共结点，那么6之后的内容一定是一样的。因为是单链表。
 */


public class _160_34_两个链表的第一个公共结点 {

    //  _160_34_两个链表的第一个公共结点
    //方法一：运用HasnMap的特性
    public class Solution {
        // _160_34_两个链表的第一个公共结点  对比2个数组 第一个公共数字
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            ListNode current1 = pHead1;
            ListNode current2 = pHead2;


            HashMap<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();
            while (current1 != null) {
                hashMap.put(current1, null);
                current1 = current1.next;
            }
            while (current2 != null) {
                if (hashMap.containsKey(current2))
                    return current2;
                current2 = current2.next;
            }

            return null;

        }
    }




        /*
        尾巴对齐
    思路： 如果存在共同节点的话，那么从该节点，两个链表之后的元素都是相同的。
    也就是说两个链表从尾部往前到某个点，节点都是一样的。
    我们可以用两个栈分别来装这两条链表。一个一个比较出来的值。
    找到第一个相同的节点。
     */

    public ListNode FindFirstCommonNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (headA != null) {
            stack1.push(headA);
            headA = headA.next;
        }

        while (headB != null) {
            stack2.push(headB);
            headB = headB.next;
        }

        ListNode commonListNode = null;

        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek() ) {
            stack2.pop();
            commonListNode = stack1.pop();;
        }

        return commonListNode;
    }

    /*
     一个很清奇的做法
        headA 0 -> 9 -> 1 -> 2 -> 4
        headB 3 -> 2 -> 4

        headA headB链表长度不一样。如果他们长度一致了，则可以从头开始比较了。

        headA 0 -> 9 -> 1 -> 2 -> 4 -> 3 -> 2 -> 4
        headB 3 -> 2 -> 4 -> 0 -> 9 -> 1 -> 2 -> 4

        现在长度一样长了，示例 [ 160相交链表_2 ] ，则可以从头开始比较了

     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA==null || headB==null)
                return null;
            ListNode curA=headA,curB=headB;
            while (curA!=curB){ // 如果两个链表都跑到了最后也没有相同的。此时 curA==curB，也是直接return。相当于公共节点是null节点
                curA=(curA==null)?headB:curA.next;
                curB=(curB==null)?headA:curB.next;
            }
            return  curA;
    }






//方法2： 分别计算得到 2个指针的长度，得到差值len，让长的链表先走len个长度。之后再继续比较。    前提：找到第一个公共结点之后，剩下的也相同。则必然两个链表长度也要相等

    public ListNode FindFirstCommonNodeII(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;// 链表1
        ListNode current2 = pHead2;// 链表2
        if (pHead1 == null || pHead2 == null)
            return null;
        int length1 = getLength(current1);
        int length2 = getLength(current2);
        // 两连表的长度差

        // 如果链表1的长度大于链表2的长度
        if (length1 >= length2) {
            int len = length1 - length2;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current1 = current1.next;
                len--;
            }

        }
        // 如果链表2的长度大于链表1的长度
        else if (length1 < length2) {
            int len = length2 - length1;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current2 = current2.next;
                len--;
            }

        }
        //开始齐头并进，直到找到第一个公共结点
        while(current1!=current2){
            current1=current1.next;
            current2=current2.next;
        }
        return current1;

    }

    // 求指定链表的长度
    public static int getLength(ListNode pHead) {
        int length = 0;

        ListNode current = pHead;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }



}
