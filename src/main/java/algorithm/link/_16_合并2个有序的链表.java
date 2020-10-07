package algorithm.link;


import algorithm.common.ListNode;

/*
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

 */
public class _16_合并2个有序的链表 {
    public static void main(String[] args) {
        ListNode listNode0=new ListNode(0);
        ListNode listNode1=new ListNode(2);
        ListNode listNode2=new ListNode(4);
        ListNode listNode3=new ListNode(6);
        ListNode listNode4=new ListNode(8);
        ListNode listNode5=new ListNode(10);
        listNode0.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;

        ListNode listNode_1=new ListNode(1);
        ListNode listNode_2=new ListNode(3);
        ListNode listNode_3=new ListNode(5);
        ListNode listNode_4=new ListNode(7);
        ListNode listNode_5=new ListNode(9);
        listNode_1.next=listNode_2;
        listNode_2.next=listNode_3;
        listNode_3.next=listNode_4;
        listNode_4.next=listNode_5;
        ListNode node=Merge00(listNode0,listNode_1);
        ListNode.toString(node);
    }



    public static ListNode Merge3(ListNode list1,ListNode list2) {
        //新建一个头节点，用来存合并的链表。
        ListNode head=new ListNode(-1);
        head.next=null;
        ListNode root=head;
        while(list1!=null&&list2!=null){
            System.out.println("------------------------循环结开始---------------------------");
            if(list1.val<list2.val){
                head.next=list1;
                System.out.print("     list1:"); ListNode.toString(list1);
                System.out.print("     head:"); ListNode.toString(head);
                head=list1;
                System.out.print("     head:"); ListNode.toString(head);
//                head=head.next;
                list1=list1.next;
                System.out.print("     list1:");  ListNode.toString(list1);

            }else{
                head.next=list2;

                System.out.print("     list2:");  ListNode.toString(list2);
                System.out.print("     head:"); ListNode.toString(head);
                head=list2;
                System.out.print("     head:"); ListNode.toString(head);
//                head=head.next;
                list2=list2.next;
                System.out.print("     list2:"); ListNode.toString(list2);
            }
            System.out.println("===========================循环结束======================");
        }
        //把未结束的链表连接到合并后的链表尾部
        if(list1!=null){
            head.next=list1;
        }
        if(list2!=null){
            head.next=list2;
        }
        return root.next;
    }
    // 标准答案：注释为 Merge00 思路 very good ，再好不过了！
    // 画图容易理解 先画3个list  ls1 ls2 newHead/current
    public static ListNode Merge0(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(-1);  //
        ListNode current = newHead;     // 指针在newHead上移动

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                // TODO
                current.next = list1;
                list1 = list1.next; // list1 赋值完毕，指针向后平移
            } else {
                // TODO
                current.next = list2;
                list2 = list2.next;
            }
            // TODO
            current = current.next; // 当前指针向后平移
        }
        // 必然有一个已经跑完
        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;
        return newHead.next;
    }

    //非递归简洁版，傻子都能看懂哦   list1 list2分别是2个链表 ； newHead是准备要拼接成一个链表的头节点 ； current只是一个节点
        public static ListNode Merge00(ListNode list1,ListNode list2) {
            ListNode newHead = new ListNode(-1); // 新的链表，拼接-表示 新的结果集      // 链表头部指针
            ListNode current = newHead; // 是  一个指针，在 newHead 链上移动。不断接下一个元素  // newHead上的一个滑动指针
            int i=0;
            ListNode.toString(list1); // 0->2->4->6->8->10
            ListNode.toString(list2); // 1->3->5->7->9
            System.out.print("      newHead 为："); ListNode.toString(newHead);
            while (list1 != null && list2 != null) { i++;
                System.out.println("------------------------循环结开始"+i+"---------------------------");
                System.out.print("      current 为："); ListNode.toString(current);
                System.out.print("      list1 为："); ListNode.toString(list1);
                System.out.print("      list2 为："); ListNode.toString(list2);

                if (list1.val < list2.val) {
                    // TODO --------------------------------
                    current.next = list1;
                    list1 = list1.next; // list1 赋值完毕，指针向后平移
                    System.out.print("      current 为："); ListNode.toString(current);
                    System.out.print("      list1 为："); ListNode.toString(list1);
                } else {
                    // TODO --------------------------------
                    current.next = list2;
                    list2 = list2.next;
                    System.out.print("      current 为："); ListNode.toString(current);
                    System.out.print("      list2 为："); ListNode.toString(list2);
                }
                // TODO --------------------------------
                current = current.next;     // 放好了一个元素，指针向后移动。向后移，去接新的元素 。 始终代表的是结果链的末尾！这样可以不断指向next 指向新的元素。  则current之前【包含】的元素已经安顿好了
                System.out.print("      current 为："); ListNode.toString(current);
                System.out.print("      newHead 为："); ListNode.toString(newHead);
                System.out.println("===========================循环结束======================");
            }
            if (list1 != null) current.next = list1; // 模仿在while循环里的
            if (list2 != null) current.next = list2;
            return newHead.next;
        }
        /*
        0->2->4->6->8->10
1->3->5->7->9
------------------------循环结开始1---------------------------
      newHead 为：-1
      current 为：-1
      list1 为：0->2->4->6->8->10
      current 为：-1->0->2->4->6->8->10
      list1.next 为：2->4->6->8->10
      current 为：0->2->4->6->8->10
===========================循环结束======================
------------------------循环结开始2---------------------------
      newHead 为：-1->0->2->4->6->8->10
      current 为：0->2->4->6->8->10
      list2 为：1->3->5->7->9
      current 为：0->1->3->5->7->9
      list2.next 为：3->5->7->9
      current 为：1->3->5->7->9
===========================循环结束======================
------------------------循环结开始3---------------------------
      newHead 为：-1->0->1->3->5->7->9
      current 为：1->3->5->7->9
      list1 为：2->4->6->8->10
      current 为：1->2->4->6->8->10
      list1.next 为：4->6->8->10
      current 为：2->4->6->8->10
===========================循环结束======================
------------------------循环结开始4---------------------------
      newHead 为：-1->0->1->2->4->6->8->10
      current 为：2->4->6->8->10
      list2 为：3->5->7->9
      current 为：2->3->5->7->9
      list2.next 为：5->7->9
      current 为：3->5->7->9
===========================循环结束======================
------------------------循环结开始5---------------------------
      newHead 为：-1->0->1->2->3->5->7->9
      current 为：3->5->7->9
      list1 为：4->6->8->10
      current 为：3->4->6->8->10
      list1.next 为：6->8->10
      current 为：4->6->8->10
===========================循环结束======================
------------------------循环结开始6---------------------------
      newHead 为：-1->0->1->2->3->4->6->8->10
      current 为：4->6->8->10
      list2 为：5->7->9
      current 为：4->5->7->9
      list2.next 为：7->9
      current 为：5->7->9
===========================循环结束======================
------------------------循环结开始7---------------------------
      newHead 为：-1->0->1->2->3->4->5->7->9
      current 为：5->7->9
      list1 为：6->8->10
      current 为：5->6->8->10
      list1.next 为：8->10
      current 为：6->8->10
===========================循环结束======================
------------------------循环结开始8---------------------------
      newHead 为：-1->0->1->2->3->4->5->6->8->10
      current 为：6->8->10
      list2 为：7->9
      current 为：6->7->9
      list2.next 为：9
      current 为：7->9
===========================循环结束======================
------------------------循环结开始9---------------------------
      newHead 为：-1->0->1->2->3->4->5->6->7->9
      current 为：7->9
      list1 为：8->10
      current 为：7->8->10
      list1.next 为：10
      current 为：8->10
===========================循环结束======================
------------------------循环结开始10---------------------------
      newHead 为：-1->0->1->2->3->4->5->6->7->8->10
      current 为：8->10
      list2 为：9
      current 为：8->9
      list2.next 为：EMPTY LIST!
      current 为：9
===========================循环结束======================
0->1->2->3->4->5->6->7->8->9->10

Process finished with exit code 0

         */
    //递归解法 参考高票答案
        public static ListNode Merge1(ListNode list1,ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;
            if (list1.val < list2.val) {
                list1.next = Merge1(list1.next, list2);
                return list1;
            } else {
                list2.next = Merge1(list1, list2.next);
                return list2;
            }
        }

    public static ListNode Merge2(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode mergeHead = null;
        ListNode current = null;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                if(mergeHead == null){
                    mergeHead = current = list1;
                }else{
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            }else{
                if(mergeHead == null){
                    mergeHead = current = list2;
                }else{
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null){
            current.next = list2;
        }else{
            current.next = list1;
        }
        return mergeHead;
    }
}
