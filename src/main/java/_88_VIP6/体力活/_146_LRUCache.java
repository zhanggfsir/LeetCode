package _88_VIP6.体力活;

/*
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，
它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

 

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？

 

示例:

LRUCache cache = new LRUCache( 2  缓存容量 );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4


 */



//https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/


import java.util.HashMap;

/*
重写双向链表 + HashMap


[ 解题思路 ]

1.先把逻辑理清楚：
// key 映射到 Node(key, val)
HashMap<Integer, Node> map;
// Node(k1, v1) <-> Node(k2, v2)...
DoubleList cache;

int get(int key) {
    if (key 不存在) {
        return -1;
    } else {
        将数据 (key, val) 提到开头；
        return val;
    }
}

void put(int key, int val) {
    Node x = new Node(key, val);
    if (key 已存在) {
        把旧的数据删除；
        将新节点 x 插入到开头；
    } else {
        if (cache 已满) {
            删除链表的最后一个数据腾位置；
            删除 map 中映射到该数据的键；
        }
        将新节点 x 插入到开头；
        map 中新建 key 对新节点 x 的映射；
    }
}

//////////////////////////////////////////////////////
2.能够看懂上述逻辑，翻译成代码就很容易理解了：
class LRUCache {
    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    // 最大容量
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int val = map.get(key).val;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        // 先把新节点 x 做出来
        Node x = new Node(key, val);

        if (map.containsKey(key)) {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新 map 中对应的数据
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}


 */
//public class _146_LruCache {
/*
    题目套路
    1. Node类。  int k,v ; Node next,prev;
    2. DoubleList类-双向链表类。   int size  ; Node head,tail;
    3. LRUCache 构造函数。  int cap;  DoubleList cache;    HashMap<Integer, Node> map;
    4. get put 方法。
 */
class _146_LRUCache {
    ////////////////////  Node 类 ////////////////////////////
    class Node {
        public int key, val;
        public Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
    ////////////////////  DoubleList 类 ////////////////////////////
    class DoubleList {          // 对Node的操作，无 k v 操作

        private Node head, tail;
        private int size;   // 双向链表 的实际size大小

        public void addFirst(Node node) {
            if (head == null) {
                head = tail = node;
            } else {
                Node n = head;
                n.prev = node;
                node.next = n;
                head = node;
            }
            size++;
        }

        public void remove(Node node) {     // node tail head
            if (head == node && tail == node) {
                head = null;
                tail = null;
            } else if (tail == node) {  // 最后 前下=null ; node.pre.next
                node.prev.next = null;
                tail = node.prev;
            } else if (head == node) {  // 开头 下前=null ; node.next.pre
                node.next.prev = null;
                head = node.next;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }

        public Node removeLast() {
            Node node = tail;
            remove(tail);               // 调用了remove()
            return node;
        }

        public int size() {
            return size;
        }

    }
    ////////////////////  LRUCache 构造函数 ////////////////////////////
    private int cap;                     // 双向链表 容量 capacity
    private DoubleList cache;
    private HashMap<Integer, Node> map;  // map 的 k , v

    public _146_LRUCache(int capacity) {
        this.cap = capacity;
        cache = new DoubleList();
        map = new HashMap<>();
    }
    ////////////////////  get put 方法 ////////////////////////////
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        int val = map.get(key).val;
        put(key, val);                  // 此处调用了 put()
        return val;
    }



    /*
        1.删 删1个或者2个    缓存1个 缓存、map2个
        2.缓存头插
        3.map更新或者添加
     */
    public void put(int key, int value) {
        Node x = new Node(key, value);  // 为啥要构造Node  1.map中放的是(k,Node)  2.DoubleList中也是对Node进行增、改

        if (map.containsKey(key)){      // map中已经有 1.删缓存 2.头插 3.map更新
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key,x);
        } else {
            if (cap == cache.size()) {      // 1. 1.1 删缓存最后一个 1.2 删对应map的key
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);              // 只要是map中不包含key 2.头插 map put新增
            map.put(key,x);
        }
    }


//    对put()的理解
/*
put 方法主要有3个操作
1.remove 删除缓存cache或者删除缓存cache、map中的数据
2.缓存头插 cache.addFirst(x);
3.更新map map.put(key,x);
  那么索性如下写法
    */

//    public void put(int key, int value) {
//        Node x = new Node(key, value);
//
//        if (map.containsKey(key)){      // 删除cache或者 cache、map中的数据
//            cache.remove(map.get(key));
//        } else {
//            if (cap == cache.size()) {
//                Node last = cache.removeLast();
//                map.remove(last.key);
//            }
//
//        }
//        cache.addFirst(x);  // 缓存头插
//        map.put(key,x);     // 更新map
//    }

}














