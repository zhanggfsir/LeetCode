package algorithm.common;

public class ListNode {
    public int val;
    public ListNode  next = null;

    public   ListNode(int val) {
        this.val = val;
    }



//    @Override
//    public String toString() {
//        return "ListNode{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
//    }

//    public static void toString(ListNode head) {
//        if (head == null) {
//            System.out.println("EMPTY LIST!");
//            return;
//        }
//        ListNode currNode = head;
//        while (currNode != null) {
//            System.out.print(currNode.val);
//            System.out.print("->");
//            currNode = currNode.next;
//        }
////        System.out.print(currNode.val);
////        System.out.println();
//    }


    public static void toString(ListNode head) {
        if (head == null) {
            System.out.println("EMPTY LIST!");
            return;
        }
        ListNode currNode = head;
        while (currNode.next != null) {
            System.out.print(currNode.val);
            System.out.print("->");
            currNode = currNode.next;
        }
        System.out.print(currNode.val);
        System.out.println();
    }





    // 求指定链表的长度
    public static int getLength(ListNode pHead) {
        int length = 0;

        ListNode current = pHead;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }




}
