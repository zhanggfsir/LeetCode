    package _88_VIP6.链表归类.链表归类dummyHead;

import algorithm.common.ListNode;

    /*
        86. 分隔链表

        给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

        你应当保留两个分区中每个节点的初始相对位置。

         

        示例:

        输入: head = 1->4->3->2->5->2, x = 3
        输出: 1->2->2->4->3->5

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/partition-list
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

         */

    /*
        链表题 画图。图能做出来，就能解出来
        示例 链表   head = 1->4->3->2->5->2,

         要得到2个链表
             dummy1  0 ->
             dummy2  0 ->

     */
    public class _86_分隔链表_PartitionList {

        /*
        用两个链表,一个链表放小于x的节点,一个链表放大于等于x的节点
        最后,拼接这两个链表.
         */
        //  _86_PartitionList 分隔链表
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(-1);  // x 左边
            ListNode dummy2 = new ListNode(-1);  // x 右边
            ListNode cur1 = dummy1;
            ListNode cur2 = dummy2;
            while (head != null) {
                if (head.val < x) {
                    cur1.next = head;
                    cur1 = cur1.next;
                    head = head.next;
                } else {
                    cur2.next = head;
                    cur2 = cur2.next;
                    head = head.next;
                }
            }
            cur1.next = dummy2.next; // 连接 两个链表
            cur2.next = null;
            return dummy1.next;
        }



    }
