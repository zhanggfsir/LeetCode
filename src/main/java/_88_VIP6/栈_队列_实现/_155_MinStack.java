package _88_VIP6.栈_队列_实现;

import java.util.Stack;

/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
 

示例:

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 

提示：

pop、top 和 getMin 操作总是在 非空栈 上调用。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-stack
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//  最小栈
public class _155_MinStack {

    // 2个栈
    /* 用来存放正常数据 */
    private Stack<Integer> stack;
    /* 用来存放最小数据 */
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public _155_MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {       // 1.栈push  2.最小栈push：如果最小栈为空，直接push，否则push  min( x和最小栈顶的 )
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(x, minStack.peek()));
        }
    }

    public void pop() {     // 两个栈分别 pop
        stack.pop();
        minStack.pop();
    }

    public int top() {      // peek正常栈的栈顶
        return stack.peek();
    }

    public int getMin() {  // peek最小栈的栈顶
        return minStack.peek();
    }



    //

//    private Node head;
//
//    /** initialize your data structure here. */
//    public _155_MinStack() {
//        head = new Node(0, Integer.MAX_VALUE, null);
//    }
//
//    public void push(int x) {
//        head = new Node(x, Math.min(x, head.min), head);
//    }
//
//    public void pop() {
//        head = head.next;
//    }
//
//    public int top() {
//        return head.val;
//    }
//
//    public int getMin() {
//        return head.min;
//    }
//
//    private static class Node {
//        public int val;
//        public int min;
//        public Node next;
//        public Node(int val, int min, Node next) {
//            this.val = val;
//            this.min = min;
//            this.next = next;
//        }
//    }




}
