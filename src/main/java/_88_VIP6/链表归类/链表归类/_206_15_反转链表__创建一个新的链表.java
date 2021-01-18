package _88_VIP6.链表归类.链表归类;

/*
输入一个链表，反转链表后，输出新链表的表头。
 */
//public class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}


//import algorithm.common.ListNode;

import algorithm.common.ListNode;

import java.util.LinkedList;

/*
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 */
//class ListNode {
//    public int val;
//    ListNode next = null;
//
//    public ListNode(int val) {
//        this.val = val;
//    }
//}
public class _206_15_反转链表__创建一个新的链表 {
    public static void main(String[] args) {
        LinkedList ls=new LinkedList<>();

        ListNode listNode0=new ListNode(0);
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode0.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        ListNode.toString(listNode0);
        int arr[]={0,1,2,3,4,5};
        ListNode head=createLinkedList(arr,arr.length);
        ListNode.toString(head);
    }


    //            System.out.print(cur.val+" "+cur.next.val+" ");
//            System.out.println(cur.val);
    //            cur.next=new ListNode(arr[i]);
    // _206_15_反转链表 三步走！
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {  // 退出时cur会指向null；这样return pre就不奇怪了
            ListNode nextTemp = cur.next; // 1.初始化pre cur nextTemp三个节点。当前节点不为空，才去获取当前节点的下一个节点
            cur.next = pre;   // 2.指向反转：cur指向下一个元素的指针指向pre指针。//此时 pre指针保存了cur指针反转后应该指向的头节点
            pre = cur;        // 3.对pre cur nextTemp指针进行指向平移
            cur = nextTemp;
        }
        return pre;
    }




    public static ListNode createLinkedList_(int arr[],int n){
        if (n==0){
            return null;
        }
        ListNode head=new ListNode(arr[0]);
        ListNode cur=head;
        for (int i = 1; i <n ; i++) {
            cur.next=new ListNode(arr[i]);
            cur=cur.next;
        }
        return  head;
    }

    public static ListNode createLinkedList(int arr[],int n){
        if (n==0){
            return null;
        }
        ListNode head=new ListNode(arr[0]); // 头指针作为第一个节点，不是通过上一个节点的next指针创建出来的
        ListNode cur=head;                  // cur指向head头指针
//        System.out.println(cur.val);
        for (int i = 1; i <n ; i++) {
            cur.next=new ListNode(arr[i]); // cur的next指针指向一个新的节点  不断向头指针的下一个指针创建新的节点
            System.out.print(cur.val+" "+cur.next.val+" ");
//            ListNode.toString(cur);
            cur=cur.next;  // 重要：意思是将cur 指针指向刚刚创建的新的节点[上一行]
            System.out.println(cur.val+" "); // +cur.next.val
//            ListNode.toString(cur);
//            ListNode.toString(head);
        }

        return  head;
    }




//        System.out.println(ReverseList1(listNode0).val); ; // 5
//        System.out.println(ReverseList1(listNode0));
//        System.out.println(ReverseList1(listNode0).next.val);



    /*      相当于用尾插法新建链表
    用三个指针分别指向当前、前一个、后一个，每次循环使当前节点的next指针指向前一个（原指向后一个），
    然后依次向后平移三个指针（注意移动的先后次序）。
     */
    public static ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode reversedHead = null;
        ListNode current = head;
        ListNode tmp = null;
        ListNode pre = null;

        while (current != null) {
            tmp = current.next; // 备份，以免链表断裂
            current.next = pre; // 反转
            if (tmp == null)
                reversedHead = current;
            pre = current;      //　平移
            current = tmp;

        }
        return reversedHead;
    }


    public static ListNode ReverseList0(ListNode head) {
//        ListNode.toString(head);
        if(head==null)
            return null;
        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
//        ListNode pre = null;
//        ListNode next = null;
        ListNode pre = new ListNode(666);
        ListNode next = new ListNode(777);;
        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        while(head!=null){
            // 一 处理head.next 将
            next = head.next;     //1.取出head.next指针给next (tmp) --- 用next保存head的下一个节点的信息 next指针可以理解为是一个tmp指针
            head.next = pre;      //2.将head指向pre ---让head从指向next变成指向pre了    pre->head->next1->next2变成pre<-head next1->next2
            //3. 将pre head指针依次向后移动一个节点
            pre = head;
            head = next;
        }
        ListNode.toString(pre);
        return pre;
    }
    /*
    1 666 0 1
    2 0 1 2
    3 1 2 3
    4 2 3 4
    5 3 4 5
     */
    public static ListNode ReverseList1(ListNode head) {
//        ListNode.toString(head);
        if(head==null)
            return null;
        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
//        ListNode pre = null;
//        ListNode next = null;
        ListNode pre = new ListNode(666);
        ListNode next = new ListNode(777);;
        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
        //所以需要用到pre和next两个节点
        //1->2->3->4->5
        //1<-2<-3 4->5
        while(head!=null){
            ListNode.toString(pre);
            ListNode.toString(head);
            //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
            //如此就可以做到反转链表的效果
            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            next = head.next;        System.out.print("head.next: "+head.next.val+" ");
            //保存完next，就可以让head从指向next变成指向pre了，代码如下
            head.next = pre;            System.out.print("pre: "+pre.val+" ");
            //head指向pre后，就继续依次反转下一个节点
            //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
            pre = head;                 System.out.print("head: "+head.val+" ");  //System.out.print(head.val+"   反转后的列表是:");
            head = next;                 System.out.print("next: "+next.val+"   反转后的列表是:");  // System.out.print(next.val+" ");
//            System.out.println(next.val+" "+head.next.val+" "+pre.val+" "+head.val);
            ListNode.toString(pre);
            System.out.print("反转前的列表是=");
            ListNode.toString(head);
        }
        ListNode.toString(pre);
        //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
        //直接输出pre就是我们想要得到的反转后的链表
        return pre;
    }
}
