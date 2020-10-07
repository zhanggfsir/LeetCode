package algorithm.link;

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


import algorithm.common.ListNode;

import java.util.HashMap;

public class _15_反转链表 {
    public static void main(String[] args) {
        HashMap map=null;
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

//        System.out.println(ReverseList1(listNode0).val); ; // 5
        System.out.println(ReverseList1(listNode0));
//        System.out.println(ReverseList1(listNode0).next.val);
    }




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

/*
思路
建立临时节点 pre next 初始值为null；while(head!=null) 继续
1. 将head->next  变成 head->pre
1.1 保存head.next指针 next=head.next
1.2 将head指向pre head.next=pre
2.将pre head 指针依次向后移动一个节点
2.1 pre=head
2.2 head=next
3. 返回pre指针
 */
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
