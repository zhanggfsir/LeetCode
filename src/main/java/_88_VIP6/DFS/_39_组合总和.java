package _88_VIP6.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。

说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 

示例 1：
输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]

示例 2：
输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 

提示：

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500

 */

/*
          candidates= [2,3,6,7] target=7

选2差5             2             3                    6               7
              /  /  \  \
选2差3        2   3   6  7
             /\   |
选2差0      2 3   2

 */
public class _39_组合总和 {
    // 数字可以被无限使用 -- 没有层数限制
    // 组合问题都可以用dfs

    public List<List<Integer>> combinationSum(int[] candidates,int target){
        if (candidates==null || candidates.length==0){
            return null;
        }
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> level=new ArrayList<>();
        //配合begin 用于去重，保证数字是从小到大的顺序选择的
        Arrays.sort(candidates);
        dfs(candidates,0,res,level,target);
        return res;
    }

    /**
     *
     * @param begin 从哪个位置的数开始选取（用于去重，保证数字是由小到大的顺序选择的）
     * @param remain 还剩多少凑够 target
     * @param candidates
     */
    // dfs 进入一层，传入一个remain，告知这一层还需要凑多少值-- remain
    private void dfs(int[]candidates,int begin,  List<List<Integer>> res,List<Integer> level , int remain){
        // if (remain < 0) return ; // 此处remian 是可以<0的
        if(remain==0){
            res.add(new ArrayList<>(level));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            // 如果candidates[i] 超过remain，那么后面的数值必然超过remain
            if(remain < candidates[i])
                return;
            level.add(candidates[i]);
            dfs(candidates,i,res,level,remain-candidates[i]);
            level.remove(level.size()-1);
        }

    }



}

