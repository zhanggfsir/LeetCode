package algorithm.link;
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
假设成立。如果6是公共结点，那么6之后的内容一定是一样的。因为是单链表。
 */

public class _34_两个链表的第一个公共结点 {

//方法一：运用HashMap的特性

    public class Solution {
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




//方法2： 分别计算得到 2个指针的长度，得到差值len，让长的链表先走len个长度。之后再继续比较。
// 前提：找到第一个公共结点之后，剩下的也相同。则必然两个链表长度也要相等
    /*
    方法论
        1、声明2个当前指针分别指2个向头指针
        2、求得长度差len，长度长的当前指针先跑len个长度
        3、如果两个当前指针不相同，就一直后移一位，最后返回cur1
     */

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

    /*
    思路： 如果存在共同节点的话，那么从该节点，两个链表之后的元素都是相同的。
    也就是说两个链表从尾部往前到某个点，节点都是一样的。
    我们可以用两个栈分别来装这两条链表。一个一个比较出来的值。
    找到第一个相同的节点。
     */

        public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
            if (pHead1 == null || pHead2 == null) {
                return null;
            }
            Stack<ListNode> stack1 = new Stack<>();
            Stack<ListNode> stack2 = new Stack<>();

            while (pHead1 != null) {
                stack1.push(pHead1);
                pHead1 = pHead1.next;
            }

            while (pHead2 != null) {
                stack2.push(pHead2);
                pHead2 = pHead2.next;
            }

            ListNode commonListNode = null;

            while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek() ) {
                stack2.pop();
                commonListNode = stack1.pop();;
            }

            return commonListNode;
        }

}
