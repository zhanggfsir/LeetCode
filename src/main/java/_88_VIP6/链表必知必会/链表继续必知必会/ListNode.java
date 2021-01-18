package _88_VIP6.链表必知必会.链表继续必知必会;

public class ListNode {

        public int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }

        // 很好的打印的方法
    @Override
    public String toString() {
            return val+" -> "+next;
//        return super.toString();
    }
}
