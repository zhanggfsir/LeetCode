package algorithm;


import algorithm.common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/*
输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
// class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}


public class _3_从尾到头打印链表 {
    public static void main(String[] args) {


        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        Stack stack=new Stack<>();
        while(node1!=null){
            stack.push(node1.val); // push 的 val
            node1=node1.next;
        }
        System.out.println(stack);

        ArrayList arrayList=new ArrayList();
        while(!stack.isEmpty()){  // stack.peek()!=null 不对 stack，isEmpty
//            System.out.println(stack.pop());
            arrayList.add(stack.pop());
        }
        System.out.println(arrayList);


    }


    // 同main方法中的
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }




    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        //先存入list
        ArrayList<Integer> list1 = new ArrayList<>();
        while (listNode != null) {
            list1.add(listNode.val);
            listNode = listNode.next;
        }
        //再逆序存入另一个list
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = list1.size() - 1; i >= 0; i--) {
            list2.add(list1.get(i));
        }
        return list2;
    }


    //　对于入行　只用一个list 遍历就能实现
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        //先存入list
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        //同一list中元素逆序
        int totalSize = list.size();
        int midIndex = (list.size()-1)/ 2 ; //实在想不起来 举个例子就行了
        // todo 很简单的来记住 下标最大长度本来就是list.size-1 要求一半索引长度 那就除以2嘛 。即 (list.size()-1)/ 2
        for (int i = 0; i <= midIndex; i++) {
            int tmp = list.get(i);
            list.set(i, list.get(totalSize - 1 - i)); // 怎么对称： a+b=totalSize-1 (下标为0)
            list.set(totalSize - 1 - i, tmp);
        }
        return list;
    }


}
