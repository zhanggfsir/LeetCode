package _88_VIP6.链表必知必会.链表继续必知必会;

import algorithm.common.ListNode;

/*

给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

注意：此题对比原题有改动

示例 1:

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.


说明：

题目保证链表中节点的值互不相同
若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */
public class _203__18_offer删除链表的节点 {

    public ListNode removeElements_(ListNode head, int val) {
        // 1.声明 虚头指针 dummyhead，并让当前cur指针指向虚头指针 dummyhead
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        // 2.虚拟头结点next指针 指向 头指针
        curr.next = head;

        while (curr.next != null) { // head 已经是cur.next了
            if (curr.next.val == val) {
                // 删除cur.next
                ListNode delNode=curr.next; // 删除结点一共分两步：a 存储当前要删除的结点
                curr.next=delNode.next;     //                    b 删除确认要删除的结点
            }
            else
                curr = curr.next;
        }
        return dummyHead.next;
    }
}
