package _88_VIP6.DFS.路径总和._112_路径总和;
/// Source : https://leetcode.com/problems/path-sum/description/
/// Author : liuyubobobo
/// Time   : 2017-11-17

/// Recursive
/// Time Complexity: O(n), where n is the nodes' number of the tree
/// Space Complexity: O(h), where h is the height of the tree
/*
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例: 
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

 */
class Solution {

    public static boolean hasPathSum(TreeNode root, int sum) {

        if(root == null)    // 如果root是空，直接返回空
            return false;
                                                    // TODO 只有叶子节点在此处才会返回。所有非叶子节点只不过是获取叶子节点的返回值。
        if(root.left == null && root.right == null)  //只有是叶子节点的时候，才会去做判断sum==0。只有1个节点不判断
        {
            System.out.println("root.val-->" + root.val);
            return root.val == sum;     // 如果是叶子节点，此时不再递归调用。判断当前叶子节点的值 是否等于sum。是找到了一条
        }
        System.out.println("left-->"+root.left.val);
        if( hasPathSum(root.left, sum - root.val)){         // TODO 返回到函数被调用处，继续下次 left；也是从函数被调用处，继续执行
            System.out.println("root.left.val-->"+root.left.val);
            return true;
        }else {
            System.out.println("false left -->"+root.left.val);
        }
        System.out.println("right-->"+root.right.val);
        if( hasPathSum(root.right, sum - root.val)) {
            System.out.println("root.right.val-->"+root.right.val);
            return true;
        }else {
            System.out.println("false right -->"+root.right.val);
        }

        return false;
    }
    //  _112_路径总和
    public boolean hasPathSum3(TreeNode root, int sum) {

        if(root == null) // 如果root是空，直接返回空
            return false;
        //只有是叶子节点的时候，才会去做判断sum==0。只有1个节点不判断
        if(root.left == null && root.right == null)
            return sum == root.val;

        if( hasPathSum3(root.left, sum - root.val))
            return true;
        if( hasPathSum3(root.right, sum - root.val))
            return true;
        return false;
    }

    /*
 题中的问题是 是否存在一条从根到叶子的路径，路径上所有节点的和为sum。
 问 ：是否存在一条从根到叶子的路径，路径上所有节点的和为5？
 答 ：如下 5 是一条路径，但不是一条从根到叶子的路径。
 终止条件 if(root == null) 问题：如果只有一个孩子【不是叶子节点】，也可能会进入判断
    5
     \
      8
     / \
    13  4

    */
    public boolean hasPathSum2(TreeNode root, int sum) {

        if(root == null)
            return false;

        if(root.left == null && root.right == null)
            return sum == root.val;

        return hasPathSum2(root.left, sum - root.val)
                || hasPathSum2(root.right, sum - root.val);
    }


    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        TreeNode noden=new TreeNode(4);
        TreeNode node8=new TreeNode(8);
        TreeNode node9=new TreeNode(9);


        node1.left=node2;
        node1.right=node3;

        node2.left=node4;
        node2.right=node5;

        node4.left=node6;
        node4.right=node7;

        node3.right=noden;

        node6.left=node8;   // 8  14
        node6.right=node9;  // 8  14
//        System.out.println(maxDepth(node1));
        System.out.println(hasPathSum(node1,14));
    }
    /*
		  1
		/   \
	   2     3
	  /  \    \
	 4    5     4
    / \
   6   7

     */

}


/*  和为8  无node8 node9
                    1
                  /   \
                  2     3
                  /  \    \
                  4    5     4
                  / \
                  6   7


                  left-->2
                  left-->4
                  left-->6
                  root.val-->6
                  false left -->6
                  right-->7
                  root.val-->7
                  false right -->7
                  false left -->4
                  right-->5
                  root.val-->5
                  root.right.val-->5
                  root.left.val-->2
                  true

                  Process finished with exit code 0

======================================================
和为14 = 1 2 4 7

		  1
		/   \
	   2     3
	  /  \    \
	 4    5     4
    / \
   6   7
  /\
 8  9




left-->2
left-->4
left-->6
left-->8
root.val-->8
false left -->8
right-->9
root.val-->9
false right -->9
false left -->6
right-->7
root.val-->7
root.right.val-->7
root.left.val-->4
root.left.val-->2
true

Process finished with exit code 0

 */