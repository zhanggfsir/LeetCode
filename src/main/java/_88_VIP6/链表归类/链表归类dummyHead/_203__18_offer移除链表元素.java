package _88_VIP6.链表归类.链表归类dummyHead;

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
public class _203__18_offer移除链表元素 {

    public ListNode removeElements_(ListNode head, int val) {
        // 1.声明 虚头指针 dummyhead，并让当前cur指针指向虚头指针 dummyhead
        ListNode dummyHead = new ListNode(-1);
        // 2.虚拟头结点next指针 指向 头指针
        dummyHead.next = head;
        ListNode curr = dummyHead;


        while (curr.next != null) {
            if (curr.next.val == val) {  //TODO 本身cur.val=val 也没有意义。第一个节点dummy是0
                // 删除cur.next
                ListNode delNode=curr.next; // 删除结点一共分两步：a 存储当前要删除的结点
                curr.next=delNode.next;     //                    b 删除确认要删除的结点
            }
            else
                curr = curr.next;
        }
        return dummyHead.next;
    }

    /*
    解释一下 为什么while(cur.next!=null)
    1.如果 while(cur!=null),则退出时，必然是 cur==null ;
                                  cur
        0 -> 1  -> 2 -> 3 -> 4 -> null
    2.如果 while(cur.next!=null),则退出时，必然是 cur=最后一个非null指针 ;
        即如下，退出时 必然有cur==4
                            cur
        0 -> 1  -> 2 -> 3 -> 4 -> null
        那么可以总结 如果有cur.next=cur.next.next 则退出条件必须有 while(cur.next!=null)。
                    否则，会因为找不到cur.next.next而报空指针

     */

    /*
       public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1); // 1. 创建dummyHead虚拟头结点、
        dummyHead.next = head; // 2. 虚拟头结点指向头指
        ListNode curr = dummyHead;// 3. curr指向新创建的虚拟头结点

        while (curr != null) {
            if (curr.val == val) {
                // 删除cur.next
                ListNode delNode=curr.next; // 删除结点一共分两步：1 存储当前要删除的结点
                curr.next=delNode.next;     // 删除确认要删除的结点
            }
            else
                curr = curr.next;  // 找不到，当前结点后移
        }
        return dummyHead.next;
    }
     */


}
