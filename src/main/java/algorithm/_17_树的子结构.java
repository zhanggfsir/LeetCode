package algorithm;

import algorithm.common.TreeNode;

public class _17_树的子结构 {
    /*
    输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     */
    public static void main(String[] args) {

    }

    /*
    要点1 什么时间开始判断子树1包含子树2  doesTree1HaveTree2  --> 答：子树1的值==子树2的值  root1.val == root2.val
    2.什么时间开始遍历左子树，遍历右子树
    3.什么时间返回true false

    步骤一、有子树 HasSubtree
    定义result 默认值false
    root1、root2不为null继续，否则，返回result
    1.如果root1.val==root2.val 如果根节点值相等，判断tree1是否包含tree2
    2.如果result值为false，判断root1左子树是否包含root2 --> result = HasSubtree(root1.left,root2);
    3.如果result值为false，判断root1右子树是否包含root2 --> result = HasSubtree(root1.left,root2);

    步骤二、子树1包含子树2 doesTree1HaveTree2
    1.如果node2为空，返回true
    2.如果node1位空，返回false
    3.如果node1.val!=node2.val 返回false
    4.继续递归 doesTree1HaveTree2  doesTree1HaveTree2(node1.left,node2.left) && doesTree1HaveTree2(node1.right,node2.right)
     */
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if(root1.val == root2.val){
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1,root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left,root2);
            }

            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right,root2);
            }
        }
        //返回结果
        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {
            return false;
        }

        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left,node2.left) && doesTree1HaveTree2(node1.right,node2.right);
    }
}
