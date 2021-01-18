package _88_VIP6.链表归类.链表归类_快慢指针;

import high_frequency.link.Link.ListNode;

/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

n从0计算还是从1计算
n不合法 负数或者大于链表长度如何处理
 */
public class _19_删除链表的倒数第N个节点 {




    /*

    */

    /*  总结 要删除倒数第2个元素。倒推。
        重点要找到倒数第n个节点的前一个节点。
           如果所示，当fast指向null，倒数第2个元素的前一个节点是3，那么fast和slow间隔2个元素。
           则fast先走3步。即 fast先走n+1步

                                     fast
                      slow
        0 -> 1 -> 2 -> 3 -> 4 -> 5 -> null

        1. 初始状态
       dummyHead
       fast
       slow
        0 -> 1 -> 2 -> 3 -> 4 -> 5 -> null

        2. fast先走n+1步
       dummyHead
                     fast
       slow
        0 -> 1 -> 2 -> 3 -> 4 -> 5 -> null

        3.fast!=null slow fast 一起走 [最终fast会走到null！！！]
          此时slow.next就是要删除的节点
        dummyHead
                                      fast
                      slow
        0 -> 1 -> 2 -> 3 -> 4 -> 5 -> null

     */
    // todo 块慢指针 一次走1步

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i < n+1; ++i) {  // 从0开始的，循环了n+1 次
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }


    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n+1; ++i) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        ListNode ans = dummy.next;
        return ans;
    }







    // 解法1 先遍历一遍计算链表长度，再遍历一遍删除倒数第n个节点。         // 遍历了2次链表
    // 如果说长度L，那么删除的元素为： 第 L-N 个

    // 遍历一次链表

    // 删除一个元素，虚拟头节点

    /*
    关键：找到要删除元素的前一个元素
    n=2
    要删除4这个节点，要找到4之前的那个节点 3节点的位置。如果说最后一个节点是fast，则slow fast 节点间的距离是固定的。
    找到slow，则删除slow指向的下一个节点就好了。 slow前的不用管。

                       slow                 fast
    0  ->  1 ->  2   -> 3  ->  4   -> 5  -> NULL

    将p向前移，p指向虚拟头节点。由于 slow fast 之间的长度是固定的。当slow指向虚拟头节点，只需将 fast 指针移动 n+1 即可
    slow               fast
    0  ->  1 ->  2   -> 3  ->  4   -> 5  -> NULL

    之后让 slow fast 同时向前移动，直到 fast 指针指向 NULL 这个元素，就成功的找到了要删除元素4的前一个元素3的位置          // 只遍历一遍链表
                       slow                 fast
    0  ->  1 ->  2   -> 3  ->  4   -> 5  -> NULL


     */

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // _19_删除链表的倒数第N个节点 双指针技术  slow 要指向倒数第n个的前一个，那么fast先走n+1步
    //  _19_删除链表的倒数第N个节点
    // todo 此方法笨拙
    public ListNode removeNthFromEnd_(ListNode head, int n) {

        // 拿 1->2->3->4 举例子

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode slow = dummyHead;
        ListNode fast = dummyHead;     // 目标节点的前一个节点
        // 第一个指针从列表的开头向前移动 n+1 步，而第二个指针将从列表的开头出发。现在，这两个指针被 n 个结点分开 ！！
        for( int i = 1 ; i <= n + 1 ; i ++ ){  // 目标节点走n步，则目标节点的前一个节点走n+1步。先走n+1步
//            assert q != null;
            if(fast==null){
                return null;
            }
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new _19_删除链表的倒数第N个节点()).removeNthFromEnd(head, 2);
        System.out.println(head);
    }


    // 解法1 先遍历一遍计算链表长度，再遍历一遍删除倒数第n个节点。         // 遍历了2次链表
    // 如果说长度L，那么删除的元素为： 第 L-N 个

    //  先遍历一遍计算链表长度；再遍历一遍删除倒数第n个节点
    // _19_删除链表的倒数第N个节点
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int length = 0;
        for(ListNode cur = dummyHead.next ; cur != null ; cur = cur.next) // 得到链表长度
            length ++;

        int k = length - n; // 求解即为第k个
        assert k >= 0;
        ListNode cur = dummyHead;
        for(int i = 0 ; i < k ; i ++)
            cur = cur.next;

        cur.next = cur.next.next;

        return dummyHead.next;
    }


}
