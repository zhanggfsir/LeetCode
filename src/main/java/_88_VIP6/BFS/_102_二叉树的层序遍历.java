package _88_VIP6.BFS;

import binTree.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

 

示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]

 */
//广度优先遍历
public class _102_二叉树的层序遍历 {

    /*
     1 root 节点加入队列
     2 队列不为空 移除头 打印
     3 左节点不为空，左节点加入队列；右节点不为空，右节点加入队列
     */
    // 二分查找树的层序遍历  第一步 打印出所有数字[
    //
    //
    // ] 3 9 20 15 7
    public void levelOrder_(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode cur=q.remove();
            System.out.println(cur.val);

            if (cur.left!=null)
                q.add(cur.left);
            if(cur.right!=null)
                q.add(cur.right);
        }
    }

    //  去掉注释版
    class Solution2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root==null) {
                return new ArrayList<List<Integer>>();
            }
            List<List<Integer>> res = new ArrayList<List<Integer>>();    // 放入所有层(List)的值 每层的值是Integer
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>(); // 放入每层的节点 TreeNode
            queue.add(root);
            while(queue.size()>0) {
                int size = queue.size();
                ArrayList<Integer> level = new ArrayList<Integer>(size);
                for(int i=0;i<size;++i) {
                    TreeNode t = queue.remove();
                    level.add(t.val);
                    if(t.left!=null) {
                        queue.add(t.left);
                    }
                    if(t.right!=null) {
                        queue.add(t.right);
                    }
                }
                res.add(level);
            }
            return res;
        }
    }

    // BFS
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root==null) {
                return new ArrayList<List<Integer>>();
            }
            List<List<Integer>> res = new ArrayList<List<Integer>>();        // 放入所有层(List)的值 每层的值是Integer
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();    // 放入每层的TreeNode


            // 节点
            //将根节点放入队列中，然后不断遍历队列
            queue.add(root);
            while(queue.size()>0) {  // !q.isEmpty()                // 每次判断进入一层，一次进入一层
                //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
                int size = queue.size();
                ArrayList<Integer> level = new ArrayList<Integer>(size);
                //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
                //如果节点的左/右子树不为空，也放入队列中
                for(int i=0;i<size;++i) {                           // 一层的数据总量
                    TreeNode t = queue.remove();
                    level.add(t.val);
                    if(t.left!=null) {
                        queue.add(t.left);
                    }
                    if(t.right!=null) {
                        queue.add(t.right);
                    }
                }
                //将临时list加入最终返回结果中
                res.add(level);
            }
            return res;

        }
    }
    // BFS 有一个套模板的过程，熟悉了可以了解一下
//    https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/tao-mo-ban-bfs-he-dfs-du-ke-yi-jie-jue-by-fuxuemin/
    //https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/


    // DFS
    class Solution22 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res  = new ArrayList<>();
            if(root != null){
                dfs(res, root, 0);
            }
            return res;
        }

        private void dfs(List<List<Integer>> res, TreeNode node, int level){
            if(res.size() - 1 < level){
                res.add(new ArrayList<Integer>());
            }
            res.get(level).add(node.val);
            if(node.left!=null){
                dfs(res, node.left, level + 1);
            }
            if(node.right!=null){
                dfs(res, node.right, level + 1);
            }
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();

        return null;
    }
}
