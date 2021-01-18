package _88_VIP6.二叉树必知必会;

import binTree.binaryTree.TreeNode;

public class _94_二叉树的中序遍历 {
    //  _94_二叉树的中序遍历
    public static void inOrderRecur(TreeNode head) {
        if (head == null)
            return;

        inOrderRecur(head.left);
        System.out.print(head.val + " ");
        inOrderRecur(head.right);
    }



    

}
