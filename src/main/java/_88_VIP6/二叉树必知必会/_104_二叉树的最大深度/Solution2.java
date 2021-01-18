package _88_VIP6.二叉树必知必会._104_二叉树的最大深度;/// Source : https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
/// Author : liuyubobobo
/// Time   : 2017-11-17

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Stack;

/// Non-recursive
/// Time Complexity: O(n), where n is the nodes' number in the tree
/// Space Complexity: O(h), where h is the height of the tree
class Solution2 {








    // BFS
    //BFS的实现原理就是一层层遍历，统计一下总共有多少层，我们来画个图分析一下。
    class Solution {
        public int maxDepth(binTree.binaryTree.TreeNode root) {
            if(root==null) {
                return 0;
            }
            LinkedList<binTree.binaryTree.TreeNode> queue = new LinkedList<binTree.binaryTree.TreeNode>();
            queue.add(root);
            int count=0;
            while(queue.size()>0) {
                int size = queue.size();  //获取当前队列的长度，这个长度相当于 当前这一层的节点个数             //每一层的个数
                for(int i=0;i<size;++i) {
                    binTree.binaryTree.TreeNode t = queue.remove();
                    if(t.left!=null) {
                        queue.add(t.left);
                    }
                    if(t.right!=null) {
                        queue.add(t.right);
                    }
                }
                count++;
            }
            return count;
        }
    }

    /*
    标签：DFS
找出终止条件：当前节点为空
找出返回值：节点为空时说明高度为 0，所以返回 0；节点不为空时则分别求左右子树的高度的最大值，同时加1表示当前节点的高度，返回该数值
某层的执行过程：在返回值部分基本已经描述清楚
时间复杂度：O(n)O(n)

     */

    // DFS
    // _104_二叉树的最大深度
    class Solution_ {
        public int maxDepth(binTree.binaryTree.TreeNode root) {
            if(root == null) {
                return 0;
            } else {
                int left = maxDepth(root.left);
                int right = maxDepth(root.right);
                return Math.max(left, right) + 1;
            }
        }
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;

        Stack<Pair<TreeNode, Integer>> s = new Stack<Pair<TreeNode, Integer>>();
        s.add(new Pair(root, 1));
        int res = 0;
        while(!s.empty()){
            TreeNode curNode = s.peek().getKey();
            int depth = s.peek().getValue();
            s.pop();

            if(curNode.left == null && curNode.right == null)
                res = Math.max(res, depth);
            else{
                if(curNode.left != null)
                    s.push(new Pair(curNode.left, depth + 1));
                if(curNode.right != null)
                    s.push(new Pair(curNode.right, depth + 1));
            }
        }

        return res;
    }
}
