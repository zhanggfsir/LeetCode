package algorithm;


/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，
一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。

（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */


import algorithm.common.RandomListNode;

public class _25_复杂链表的复制_ {

    // 画一下 好理解。有图
    // 方法论 复制再拆分  A->B->C->D  A->A1->B->B1->C->C1->D->D1   A1->B1->C1->D1
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while(currentNode != null){   // A->B
            RandomListNode cloneNode = new RandomListNode(currentNode.label); // 得到A1
            RandomListNode nextNode = currentNode.next; // 将A之后的，即B作为临时结点
            currentNode.next = cloneNode; // A->A1
            cloneNode.next = nextNode;    // A1->B
            currentNode = nextNode;       // 得到B的下一个结点 C
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(currentNode != null) {
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;  // 原来A->G 现在A1->G1
            currentNode = currentNode.next.next;    // A->A1->B A跑到B，需要2*next
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;                    // A
        RandomListNode pCloneHead = pHead.next; // A1
        while(currentNode != null) {    //  A->A1->B->B1->C->C1
            RandomListNode cloneNode = currentNode.next; // 将A1作为临时结点
            currentNode.next = cloneNode.next;           // 得到 A->B
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next; //A1->B1
            currentNode = currentNode.next;              // 跑到B 继续
        }

        return pCloneHead;
    }


    // 递归写法
    public RandomListNode Clone1(RandomListNode pHead)
    {
        if (pHead == null)
            return null;

        RandomListNode newNode = new RandomListNode(pHead.label);

        newNode.random = pHead.random;
        newNode.next = Clone1(pHead.next);

        return newNode;
    }
}
