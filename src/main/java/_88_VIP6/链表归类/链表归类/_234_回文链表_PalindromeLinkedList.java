package _88_VIP6.链表归类.链表归类;

import high_frequency.link.Link.ListNode;

/*
234. 回文链表

请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

 */
//  234. 回文链表 easy
public class _234_回文链表_PalindromeLinkedList {

    /*
        1. 找中间节点
        2. 反转链表


        1 -> 2 -> 3 -> 2 -> 1
        mid = 3
        1 -> 2 -> 3              2 -> 1 -> null

        1 -> 2 -> 2 -> 1
        mid = 2                 // 第1个2
        1 -> 2                  2 -> 1 -> null


     */
    //  234. 回文链表 easy
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)  // 节点为空或者只有1个节点，是回文链表
            return true;
        if (head.next.next == null)             // 节点有2个 判断 第1 第2个是否相等
            return head.val == head.next.val;

        // 找到中间节点
        ListNode mid = middleNode(head);
        // 翻转右半部分（中间节点的右边部分）
        ListNode rHead = reverseList(mid.next);
        ListNode lHead = head;
        ListNode rOldHead = rHead;

        // 从lHead、rHead出发，判断是否为回文链表
        boolean result = true;
        while (rHead != null) {
            if (lHead.val != rHead.val) {   // 此处可以直接return false
                return false;
            }
            rHead = rHead.next;
            lHead = lHead.next;
        }
        return true;
    }


    /**
     * 找到中间节点（右半部分链表头结点的前一个节点）
     * 比如 1>2>3>2>1中的3是中间节点
     * 比如 1>2>2>1中左边第一个2是中间节点  要让中间节点的下一个节点开始反转
     * @param head
     * @return
     */
    private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 翻转链表
     * @param head 原链表的头结点
     * 比如原链表：1>2>3>4>null，翻转之后是：4>3>2>1>null
     * @return 翻转之后链表的头结点（返回4）
     */
    private ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode nextTemp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nextTemp;
        }
        return pre;

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(1);
        System.out.println(head);

        _234_回文链表_PalindromeLinkedList obj = new _234_回文链表_PalindromeLinkedList();
        obj.isPalindrome(head);

        System.out.println(head);
    }




    public boolean isPalindrome_(ListNode head) {
        if (head == null || head.next == null)  // 节点为空或者只有1个节点，是回文链表
            return true;
        if (head.next.next == null)
            return head.val == head.next.val;

        // 找到中间节点
        ListNode mid = middleNode(head);
        // 翻转右半部分（中间节点的右边部分）
        ListNode rHead = reverseList(mid.next);
        ListNode lHead = head;
        ListNode rOldHead = rHead;

        // 从lHead、rHead出发，判断是否为回文链表
        boolean result = true;
        while (rHead != null) {
            if (lHead.val != rHead.val) {   // 此处可以直接return false
                result = false;
                break;
            }
            rHead = rHead.next;
            lHead = lHead.next;
        }

        // 恢复右半部分（对右半部分再次翻转）
        reverseList(rOldHead);
        return result;
    }


}
