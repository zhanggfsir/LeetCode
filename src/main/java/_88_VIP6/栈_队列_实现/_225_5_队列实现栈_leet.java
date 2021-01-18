package _88_VIP6.栈_队列_实现;

import java.util.LinkedList;
import java.util.Queue;

/*
使用栈实现队列的下列操作：

push(x) -- 将一个元素放入队列的尾部。
pop() -- 从队列首部移除元素。
peek() -- 返回队列首部的元素。
empty() -- 返回队列是否为空。
 

示例:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // 返回 1
queue.pop();   // 返回 1
queue.empty(); // 返回 false
 

说明:

你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。

 */
//_225_5_队列实现栈_leet
public class _225_5_队列实现栈_leet {


//    因为队列基于链表构成，LinkedList可以两头操作，所以用一个队列就可以模拟栈，实际上如果想要用栈模拟队列，则必须用两个栈才可以。

    class MyStack {

        Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
            for(int i = 1; i < queue.size(); i++)
                queue.add(queue.remove());
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.size() == 0;
        }

    }

    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        q.add(5);
        System.out.println(q.poll());        //  1
        System.out.println(q.peek());        //  2
        System.out.println(q.remove());      //  2
        System.out.println(q.element());     //  3
        System.out.println(q);               //
    }


}

//https://leetcode-cn.com/problems/implement-queue-using-stacks/