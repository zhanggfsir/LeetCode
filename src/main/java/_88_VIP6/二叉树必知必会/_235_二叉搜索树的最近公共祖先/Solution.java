package _88_VIP6.二叉树必知必会._235_二叉搜索树的最近公共祖先;/// Source : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
/// Author : liuyubobobo
/// Time   : 2017-11-18

/// Recursive
/// Time Complexity: O(lgn), where n is the node's number of the tree
/// Space Complexity: O(h), where h is the height of the tree
class Solution {


    // 此方法容易理解 _235_二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor3(TreeNode root,TreeNode p,TreeNode q){
        if(p==null||q==null||root==null){
            return null;
        }
        //遍历左子树
        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor3(root.left,p,q);
        }
        //遍历右子树
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor3(root.right,p,q);
        }
        //如果左边大于等于，右边小于等于，直接返回root
        if(p.val<=root.val && q.val>=root.val){      // 不遍历了，直接返回
            return root;
        }
        return root;
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;

        TreeNode cur = root;
        while(cur != null){
            if(p.val < cur.val && q.val < cur.val)
                cur = cur.left;
            else if(p.val > cur.val && q.val > cur.val)
                cur = cur.right;
            else
                return cur;
        }
        return  null;
    }






    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p == null || q == null)
            throw new IllegalArgumentException("p or q can not be null.");

        if(root == null)
            return null;

        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

//        assert p.val == root.val || q.val == root.val
//                || (root.val - p.val) * (root.val - q.val) < 0;

        return root;
    }


}
