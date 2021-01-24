package _88_VIP6.DFS;

import java.util.ArrayList;
import java.util.List;

/**

 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

 示例:

 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 链接：https://leetcode-cn.com/problems/permutations




 */

/**

0    5		6 		7
     /\     /\
1   6  7   5  7
    |  |   |  |
2   7  6   7  5

3

*/
// 概率 46
public class _46_全排列 { // 中等
    private  static  List<List<Integer>> list;
    private  static int[] input;
    /** 用来保存每一层选择的数字 567中的一个 */
    private  static int[] level;
    /** 用来标记nums中的数字是否被使用过了 */
    private  static boolean[] used;

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        list = new ArrayList<>();
        if (nums.length == 0)
            return list;
        input=nums;
        level = new int[nums.length];
        used = new boolean[nums.length];
        dfs(0);
        return list;
    }

    private static  void dfs(int idx) {
        // 不能再往下搜索
        if (idx == input.length) {
            List<Integer> resultList = new ArrayList<>();
            for (int value : level) { // level   是数组，存的是一次选择的子树，比如567
                resultList.add(value);  // 1.把数组中的值加入list，然后把list加入大的list中
            }
            list.add(resultList);
            return;
        }
        // 枚举这一层所有可以做出的选择
        for (int i = 0; i < input.length; i++) {
            if (used[i])
                continue;
            level[idx] = input[i];
            used[i] = true;

            dfs(idx + 1);   //
            // 还原现场  能走到这里说明 代码又倒回来了。刚刚用到值，标记为不用了
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        int intput [] = {5,6,7};
        System.out.println(permute(intput));
    }
}
