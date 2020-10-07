package algorithm.link;

import algorithm.common.ListNode;

/*
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

注意 ： 是删除‘存在重复的节点’的所有节点，而不是‘去重’

引申出2个问题 1.链表排序 2.链表 (已排序)去重（保留重复元素第一次出现的节点）
 */
public class _56_删除链表中重复的结点 {
    public static void main(String[] args) {
        ListNode listNode0=new ListNode(1);
        ListNode listNode1=new ListNode(2);
        ListNode listNode2=new ListNode(3);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode0.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        ListNode.toString(deleteDuplication(listNode0));
    }

    /*

 有个疑问：
 Head.next和pHead有什么区别，为甚么ListNode last = Head.next;不能是ListNode last = pHead;
 最后的返回也没看懂，为什么不能是pHead，赋值号右边不是右值吗，

 pHead的目的，就是为了构造出 Head,之后就没他啥事儿了

    方法论
        1.新建head，head的next指向phead老的链表头部
        2.声明head前后指针 pre last
        3.
     */
    public  static ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null || pHead.next==null){   return pHead;   }   // 只有0个或1个结点，则返回 不会有重复值
        ListNode Head = new ListNode(0);  // Head 是 新链表
        Head.next = pHead;                    // pHead 是 老的链表
        ListNode pre  = Head;
        ListNode last = Head.next;
//        System.out.println("000000000");
//        ListNode.toString(pre);
//        ListNode.toString(last);
        while (last!=null){
            // 对重复结点的处理
            if(last.next!=null && last.val == last.next.val){ // 如果当前节点的值和下一个节点的值相等
                // 遍历到没有重复结点的位置 。
                while (last.next!=null && last.val == last.next.val){   //穷举相同的元素。 如果后一个指针和后后一个指针同，只移动一个
                    last = last.next;
                }       // todo 如果想要保留一个 那么pre.next = last;
                pre.next = last.next;  //出现相同的，pre.next必须要指向跳过重复的结点。 找到最后一个不相等的，改变pre指针指向。next指针继续向后
                last = last.next;
            }
            //该结点不重复，递归下一个结点 ，pre last指针后移   /// 释意 last.next==null 如果是最后一个元素，继续移动，就可以得到last==null
            else{
                pre = pre.next;
                last = last.next;
            }
        }
        return Head.next;
    }



    //Java版递归
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null) return null;
        if (pHead.next == null) return pHead;
        ListNode cur;

        //对重复结点的处理
        if (pHead.val == pHead.next.val) {
            cur = pHead.next.next;
            //遍历到没有重复结点的位置
            while (cur != null && cur.val == pHead.val) {
                cur = cur.next;
            }
            return deleteDuplication2(cur);
        }

        //该结点不重复，递归下一个结点
        cur = pHead.next;
        pHead.next = deleteDuplication2(cur);
        return pHead;
    }

}
