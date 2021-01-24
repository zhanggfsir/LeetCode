package _88_VIP6.DFS.路径总和;

import _88_VIP.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _113_路径总和II {
    //注意 sum 和节点val可能是负数，路径要求到达叶子节点
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> resList=new ArrayList<>();
        List level=new ArrayList();
        if (root ==null )
            return resList;
        dfs(root,sum,level,resList);
        return resList;
    }
    private void dfs(TreeNode node,int remain,List<Integer> level,List<List<Integer>> resList){
        if(node==null)
            return;
        remain-=node.val;
        level.add(node.val);
        // remain==0 不代表接结束了，还要求到达叶子节点（因为可能后面通过正、负数重新让remain==0）
        if(node.left==null && node.right==null){    //边界条件
            if(remain==0)
                resList.add(new ArrayList<>(level));
        }else {
            dfs(node.left,remain,level,resList);    //遍历左边
            dfs(node.right,remain,level,resList);   //遍历右边
        }
        level.remove(level.size()-1);
    }
}

//    113 nums.add(node.val)  # 添加
//            nums.remove(num.size-1) 回去
//            dfs  //遍历左边
//            dfs  //遍历右边

