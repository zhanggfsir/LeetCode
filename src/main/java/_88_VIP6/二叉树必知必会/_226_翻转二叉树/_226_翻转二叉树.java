package _88_VIP6.二叉树必知必会._226_翻转二叉树;

import binTree.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
备注:
这个问题是受到 Max Howell 的 原问题 启发的 ：

谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。

 */
public class _226_翻转二叉树 {

    //  我们也可以用迭代方法来解决这个问题，这种做法和深度优先搜索（Breadth-fist Search, BFS）很接近。
    // _226_翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            TreeNode temp = current.left;    // 翻转左右节点
            current.left = current.right;
            current.right = temp;

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }



    // 一个递归实现版 _226_翻转二叉树
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            //递归函数的终止条件，节点为空时返回
            if(root==null) {
                return null;
            }
            //下面三句是将当前节点的左右子树交换
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            //递归交换当前节点的 左子树
            invertTree(root.left);
            //递归交换当前节点的 右子树
            invertTree(root.right);
            //函数返回时就表示当前这个节点，以及它的左右子树
            //都已经交换完了
            return root;
        }
    }
}
