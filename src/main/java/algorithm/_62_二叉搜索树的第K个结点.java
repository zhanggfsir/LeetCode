package algorithm;

import algorithm.common.TreeNode;

/*
给定一棵二叉搜索树，请找出其中的第k小的结点。
          例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。

根据以上性质，易得二叉搜索树的 中序遍历倒序 为 递减序列 。
因此，求 “二叉搜索树第 kk 大的节点” 可转化为求 “此树的中序遍历倒序的第 kk 个节点”。

             5
           /   \
          3     6
         / \
        2   4
       /
      1
      中序遍历： 左 根 右
                1 2 3 4 5 6
      中序遍历倒叙： 右 根 左
                6 5 4 3 2 1
      那么，求树中第K大节点，可转化为 -- 求中序遍历倒叙的第K个节点

    1. 中序遍历 左 根 右 ，代码如下
    // 打印中序遍历
void dfs(TreeNode root) {
    if(root == null) return;
    dfs(root.left); // 左
    System.out.println(root.val); // 根
    dfs(root.right); // 右
}
    2.中序遍历倒叙为 右 中 左，代码如下
    // 打印中序遍历倒序
void dfs(TreeNode root) {
    if(root == null) return;
    dfs(root.right); // 右
    System.out.println(root.val); // 根
    dfs(root.left); // 左
}


 */
public class _62_二叉搜索树的第K个结点 {

        /*
为求第 k 个节点，需要实现以下 三项工作 ：
    递归遍历时计数，统计当前节点的序号；
    递归到第 k 个节点时，应记录结果 res ；
    记录结果后，后续的遍历即失去意义，应提前终止（即返回）。
递归解析：
    1. 终止条件： 当节点 root 为空（越过叶节点），则直接返回；
    2. 递归右子树： 即 dfs(root.right) ；
    3. 三项工作：
        提前返回： 若 k = 0 ，代表已找到目标节点，无需继续遍历，因此直接返回；
        统计序号： 执行 k = k - 1 （即从 k 减至 0 ）；
        记录结果： 若 k = 0，代表当前节点为第 k 大的节点，因此记录 res = root.val；
    4. 递归左子树： 即 dfs(root.left) ；


     */

    class Solution2 {
        int res, k;
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }
        void dfs(TreeNode root) {
            if(root == null)
                return;
            dfs(root.right);
            if(--k == 0){
                res = root.val;
                return;
            }
            dfs(root.left);
        }

    }



    //    https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/
    class Solution {
        int res, k;
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }
        void dfs(TreeNode root) {
            if(root == null)
                return;
            dfs(root.right);
            if(k == 0)
                return;
            if(--k == 0)
                res = root.val;
            dfs(root.left);
        }
    }




}
