package _88_VIP6.链表归类.链表归类dummyHead;



import high_frequency.link.Link.ListNode;

/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

就是实现如下
2 4 3
5 6 4
------
7 0 8


// 3 4 2
// 4 6 5
// -----
// 8 0 7

 */
public class _2_两数相加 {
    public static void main(String[] args) {
        int [] arr1={1, 2, 3};
        int [] arr2={1, 2, 9};  // 2->4->2->1

//        ListNode l1 = MyListNode.createLinkedList_(arr1, 3);
//        ListNode l2 = MyListNode.createLinkedList_(arr2, 3);
//        MyListNode.toString(addTwoNumbers(l1,l2));

    }
    //  _2_两数相加
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1); // 1.声明哑指针、cur指针 和carry进位标记
        ListNode cur = dummyHead;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;        // 2.有一个节点不为空，获得节点值。1.求和 求进位 求和个位
            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);   // 3.创建新节点，并让cur.next指向新节点。 3个指针后移

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {                    // 4.如果carry == 1 [还有进位]，拼接链表
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
