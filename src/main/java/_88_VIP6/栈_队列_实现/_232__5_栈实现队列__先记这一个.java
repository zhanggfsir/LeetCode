package _88_VIP6.栈_队列_实现;

import java.util.Stack;


/*
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

方法论 队列是 先进先出的   如果要实现队列，二次入栈--数据入栈A，A弹出入栈B，B弹出
 */
//_232__5_栈实现队列
// 负负得正，使用两个栈，一个专门入队，一个专门出队

/*

画一个图 会很容易理解 [ 将stack1 倒叙出 stack2 ]  栈1-push ； 栈2为空装载，之后pop

  stack1  stack2
	4		1
	3		2
	2		3
	1		4

 */
public class _232__5_栈实现队列__先记这一个 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }       // push stack1中正序放数

    public int pop() {                                      // pop  stack2中逆序放数，并弹出
        if(stack1.empty()&&stack2.empty()){                             // 第n+1次之后访问pop
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.empty()){                // 第一次访问pop，用stack1装载stack2 。   if 栈2空                    // 第1次访问pop
            while(!stack1.empty()){        // while 栈1不空
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();                                             // 第1-n次访问pop
    }






    class MyQueue {

        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stackPush.push(x);
        }

        /**
         * 辅助方法：一次性将 stackPush 里的所有元素倒入 stackPop
         * 注意：1、该操作只在 stackPop 里为空的时候才操作，否则会破坏出队入队的顺序
         * 2、在 peek 和 pop 操作之前调用该方法
         */
        private void shift() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            shift();
            if (!stackPop.isEmpty()) {
                return stackPop.pop();
            }
            throw new RuntimeException("队列里没有元素");
        }

        /**
         * Get the front element.
         */
        public int peek() {
            shift();
            if (!stackPop.isEmpty()) {
                return stackPop.peek();
            }
            throw new RuntimeException("队列里没有元素");
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stackPush.isEmpty() && stackPop.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */



}

/*
leetcode
https://leetcode-cn.com/problems/implement-stack-using-queues/
 */








