package _88_VIP6.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

  

 示例：

 输入：n = 3
 输出：[
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 链接：https://leetcode-cn.com/problems/generate-parentheses

 */
//  概率 42
public class _22_括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n < 0) return list;
        if (n==0){
            list.add("");
            return list;
        }
        dfs(0, n, n, new char[n << 1], list);   // 最开始留给给本层的左右括号分别是n，n 。 level 字符数组的长度是 n*2
        return list;
    }

    /**
     *
     * @param idx 搜索的层号
     * @param leftRemain 左括号的剩余数量
     * @param rightRemain 右括号的剩余数量。每进入一层，需要找到留给本层的左右括号数量
     * @param level 用来存放每一层的选择
     */
    private void dfs(int idx, int leftRemain, int rightRemain,
                     char[] level, List<String> list) {
        if (idx == level.length) {      // 输入3 左右括号*2 即idx=6时，拿到一个结果
            list.add(new String(level));
            return;
        }

        // 枚举这一层所有可能的选择
        // 选择一种可能之后，进入下一层搜索

        // 什么情况可以选择左括号？左括号的数量 > 0
        // 选择左括号，然后进入下一层搜索
        if (leftRemain > 0) {   // 左括号数量 > 0     每一层的选择，最多只有2个，最少是1个 不能像之前一样写for循环
            level[idx] = '(';   // 选择一个左括号，并存到idx层。之后idx+1 进入下一层
            dfs(idx + 1, leftRemain - 1, rightRemain, level, list);// 进入下一层时，左括号数量减1，右括号数量不变
        }

        // 当左括号、右括号的数量一样时，只能选择左括号
        // 什么情况可以选择右括号？(右括号的数量 > 0) && (右括号的数量 != 左括号的数量)
        // 选择右括号，然后进入下一层搜索
        if (rightRemain > 0 && leftRemain != rightRemain) {
            level[idx] = ')';
            dfs(idx + 1, leftRemain, rightRemain - 1, level, list);
        }
    }

    // 注： 两个if 是同一层做的不同选择，是平行关系
    public static void main(String[] args) {
        _22_括号生成 o = new _22_括号生成();
        System.out.println(o.generateParenthesis(3));
    }
}
