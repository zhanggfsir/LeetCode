package _88_VIP6.二叉树必知必会._104_二叉树的最大深度;

/// Source : https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
/// Author : liuyubobobo
/// Time   : 2017-11-17
///
/// Recursive
/// Time Complexity: O(n), where n is the nodes' number in the tree
/// Space Complexity: O(h), where h is the height of the tree
class Solution1 {

    // Definition for a binary tree node.
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    public int maxDepth2(TreeNode root) {
//        if(root == null)
//            return 0;
//        return 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));
//    }

    /* 示例:
输入:
      1
     /   \
    2     3
   /  \
  4    5
输出: ["1->2->5", "1->3"]
解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3    */

//                        1
//                      /   \
//                      2     3
//                     /  \
//                    4    5
//                   / \
//                  6   7
    // _104_二叉树的最大深度
    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }



    public static int maxDepth2(TreeNode root) {
        if(root == null) {
            System.out.println("-----------> return  ");
            return 0;
        } else {
            System.out.println("root.val-->"+root.val + " ");
            if (root.left!=null){
                System.out.println("head.left-->"+root.left.val);  System.out.println();
            }else{
                System.out.println("head.left--> is null"); System.out.println();
            }

            System.out.println("---进入 root.left---"+"--root.val-->");//+"--root.left.val-->"+root.left.val);
            int left = maxDepth2(root.left);
            System.out.println("---层数 left -->"+left);  System.out.println();

            if (root.right!=null){
                System.out.println("head.right-->"+root.right.val); System.out.println();
            }else{
                System.out.println("head.right--> is null"); System.out.println();
            }

            System.out.println("---进入 root.right---"+"--root.val-->");//+"--root.left.val-->"+root.right.val);
            int right = maxDepth2(root.right);
            System.out.println("---层数---->"+(Math.max(left, right) + 1)+"--left.len-->"+left+"--right--"+right);        System.out.println();
            return Math.max(left, right) + 1;
        }
    }

//                        1
//                      /   \
//                      2     3
//                     /  \
//                    4    5
//                   / \
//                  6   7
    public static int maxDepth3(TreeNode root) {
        if(root == null) {
            System.out.println("-----------> return  ");
            return 0;
        } else {
            System.out.println("root.val-->"+root.val + " ");

            System.out.println("---进入 root.left---"+"--root.val-->");//+"--root.left.val-->"+root.left.val);
            int left = maxDepth3(root.left);
            System.out.println("---层数 left -->"+left);  System.out.println();

            System.out.println("---进入 root.right---"+"--root.val-->");//+"--root.left.val-->"+root.right.val);
            int right = maxDepth3(root.right);
            System.out.println("---层数---->"+(Math.max(left, right) + 1)+"--left.len-->"+left+"--right--"+right);        System.out.println();
            return Math.max(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);


        node1.left=node2;
        node1.right=node3;

        node2.left=node4;
        node2.right=node5;

        node4.left=node6;
        node4.right=node7;
//        System.out.println(maxDepth(node1));
        System.out.println(maxDepth3(node1));
    }



    /*
      1
     /   \
    2     3
   /  \
  4    5

1 head.left-->2
2 head.left-->4

4 head.left--> is null
-----------> return
head.right--> is null
-----------> return

---层数---->1
head.right-->5
5 head.left--> is null
-----------> return
head.right--> is null
-----------> return
---层数---->1

---层数---->2

head.right-->3
3 head.left--> is null
-----------> return
head.right--> is null
-----------> return
---层数---->1

---层数---->3
3





树的分析 2
		 1
		/   \
	   2     3
	  /  \
	 4    5
    / \
   6   7

1 head.left-->2
2 head.left-->4
4 head.left-->6

6 head.left--> is null
-----------> return
head.right--> is null
-----------> return
---层数---->1

head.right-->7
7 head.left--> is null
-----------> return
head.right--> is null
-----------> return
---层数---->1

---层数---->2

head.right-->5
5 head.left--> is null
-----------> return
head.right--> is null
-----------> return
---层数---->1

---层数---->3

head.right-->3
3 head.left--> is null
-----------> return
head.right--> is null
-----------> return
---层数---->1

---层数---->4
4


     */
}
