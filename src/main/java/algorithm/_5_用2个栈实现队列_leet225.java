package algorithm;

import java.util.Stack;


/*
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

方法论 队列是 先进先出的   如果要实现队列，二次入栈--数据入栈A，A弹出入栈B，B弹出
 */
public class _5_用2个栈实现队列_leet225 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }       // push stack1中正序放数

    public int pop() {                                      // pop  stack2中逆序放数，并弹出
        if(stack1.empty()&&stack2.empty()){                             // 第n+1次之后访问pop
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.empty()){                // if 栈2空                    // 第1次访问pop
            while(!stack1.empty()){        // while 栈1不空
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();                                             // 第1-n次访问pop
    }

}

/*
leetcode
https://leetcode-cn.com/problems/implement-stack-using-queues/
 */