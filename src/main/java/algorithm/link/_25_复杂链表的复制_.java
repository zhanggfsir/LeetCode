package algorithm.link;


/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，
一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。

（注意，输出结果中请不要返回参数中的节点引用，--）
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
        /*  方法论
        1.新new得到A1  注意是要重新new出一个
        2.得到B
        3.将A->A1
        4.将A->B
        5.A原链表平移 。注意此时A1之后是A1，平移直接将A1的指向改变，将A1指向B即可

         */
        //1、复制结点由 A->B->C->D 得到 A->A1->B->B1->C->C1->D->D1 。复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while(currentNode != null){   // A->B
            RandomListNode cloneNode = new RandomListNode(currentNode.label); // 得到A1   得到当前结点的复制结点 例如：得到A1
            RandomListNode nextNode = currentNode.next; //拿到B。 将A之后的，即B作为临时结点 得到当前结点的下一个结点
            currentNode.next = cloneNode; // A->A1  当前结点指向复制结点
            cloneNode.next = nextNode;    // A1->B  复制结点指向下一个结点
            currentNode = nextNode;       // 得到B的下一个结点 C
        }

        currentNode = pHead;
        //2、处理随机结点。重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        // 等号左边分析 currentNode.next是A 那么currentNode.next.random  就是 随机结点A1
        // 等号右边分析 currentNode.radom.next就是新的随机节点 即 如果说 currentNode.radom是G，那么currentNode.radom.next就是G1
        while(currentNode != null) {
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;  // 原来A->G 现在A1->G1
            currentNode = currentNode.next.next;    // A->A1->B 结点平移，平移2个 A跑到B，需要2*next
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;                    // A
        RandomListNode pCloneHead = pHead.next; // A1 得到复制结点的头结点，指向不能再发生改变 ！！
        while(currentNode != null) {    //  A->A1->B->B1->C->C1
            RandomListNode cloneNode = currentNode.next; // 将A1作为临时结点 取出复制结点作为临时结点
            currentNode.next = cloneNode.next;           // 得到 A->B 当前结点指向复制节点的下一个结点
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next; //A1->B1 复制结点 A1指向 复制节点的下下一个结点。改变A1的指向：原来指向B，改为指向B1
            currentNode = currentNode.next;              // 跑到B 继续 。之前是A1， currentNode.next = cloneNode.next; 改变了指向，指向B
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
