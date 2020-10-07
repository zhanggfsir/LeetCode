package algorithm;

import algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
LinkedList操作头节点元素性能更好,ArrayList底层是数组  LinkedList是双向循环链表

ArrayList的话，queue.remove(0)这个耗时会很高，应该用LinkedList
不过用ArrayList每次删除都会System.arraycopy，消耗很严重。还不如用链队列，LinkedList去实现会好得多

就是把这个list中第一个对象删除并且返回这个对象的值
 */
public class _22_从上往下打印二叉树_链表层序遍历 {


    /**
     思路是用arraylist模拟一个队列来存储相应的TreeNode
     */
        public ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<TreeNode> queue = new ArrayList<>();
            if (root == null) {
                return list;
            }
            queue.add(root);
            while (queue.size() != 0) {
                TreeNode temp = queue.remove(0);
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                list.add(temp.val);
            }
            return list;
        }



    // 这不就是二叉树的层次遍历么，借助一个队列就可以了。

    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
        }
        return list;
    }





    public ArrayList<Integer> PrintFromTopToBottom3(TreeNode root) {
        ArrayList<TreeNode>  listNode=new ArrayList<TreeNode> ();
        ArrayList<Integer>  listVal=new ArrayList<Integer> ();
        if(root==null)
            return listVal;
        listNode.add(root);
        listVal.add(root.val);
        for(int i=0;i<listNode.size();i++){
            TreeNode node=  listNode.get(i);
            if(node.left!=null){
                listNode.add(node.left);
                listVal.add(node.left.val);
            }
            if(node.right!=null){
                listNode.add(node.right);
                listVal.add(node.right.val);
            }

        }

        return listVal;
    }

}
