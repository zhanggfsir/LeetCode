package _88_VIP6.链表_删除链表的节点;

/*
请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。

 

现有一个链表 -- head = [4,5,1,9]，它可以表示为:

 4  ->  5  ->  1  ->  9

示例 1：
输入：head = [4,5,1,9], node = 5
输出：[4,1,9]
解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

示例 2：
输入：head = [4,5,1,9], node = 1
输出：[4,5,9]
解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 

提示：

链表至少包含两个节点。
链表中所有节点的值都是唯一的。
给定的节点为非末尾节点并且一定是链表中的一个有效节点。
不要从你的函数中返回任何结果。

 */

/*
解析  难度在于： 给定链表中的一个节点，删除该节点
方法中给出的node，是一个ListNode node，要删除的就是这个node。同时要保证整个链表继续连通
之前是待删除节点的前一个节点pre，通过他来检测要删除哪一个节点，前一个节点pre的next指针直接指向要删除节点的下一个节点，把要删除的节点跨过去。就可以放心删除当前节点了。
但是现在传入的是node，我们无法拿到node的前一个节点pre。
class Solution {
    public void deleteNode(ListNode node) {

    }
}



之前
... -> 2 -> 3 -> 4 -> ...

要删除3节点，必须保存3之前的2节点cur。让cur.next指针指向4
         cur
... ->    2    ->    3     ->    4   ->    ...
             delnode=cur.next


现在
直接给出node指针，指向3，就要求删除3，无法拿到当前节点3的前一个节点2，就无法将2.next指向4

                    node
... ->    2    ->    3     ->    4   ->    ...

之前强调不能改变链表中value的值，现在只能这么做了

目标：删除当前给定节点3的下一个节点4。可是当前给定节点3的下一个节点的值4是要保留的。
第一步：将当前给定节点的下一个节点4复制给当前节点

                    node
... ->    2    ->    3     ->    4   ->    ..

                    node
... ->    2    ->    4     ->    4   ->    ..

这样已经把当前节点删除了，可是当前节点和当前节点的下一个节点 是同一个节点。我们只需要把删除一个就好(删除下一个)


                    node
... ->    2    ->    4     ->    4   ->    ..
                               delNode

 */

/// 时间复杂度: O(1)
/// 空间复杂度: O(1)


import high_frequency.link.Link.ListNode;

public class _237_删除链表中的节点 {

    // _237_删除链表中的节点   head = [4,5,1,9], node = 5   [4,1,9]
    public void deleteNode(ListNode node) {

        if(node == null || node.next == null)
            throw new IllegalArgumentException("node should be valid and can not be the tail node.");

        node.val = node.next.val;   // 1. 把给定节点的下一个节点值 复制给当前节点
        node.next = node.next.next; // 2. 删除当前节点的下一个节点
    }




    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        ListNode head = new ListNode(arr);
        System.out.println(head);

//        ListNode node2 = head.findNode(2);
//        (new _237_删除链表中的节点()).deleteNode(node2);
//        System.out.println(head);
    }

}
