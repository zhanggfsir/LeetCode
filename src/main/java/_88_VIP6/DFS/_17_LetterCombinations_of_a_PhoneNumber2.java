package _88_VIP6.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
// _17_电话号码的字母组合2
    /*
        其实就是把 成员变量变成了参数
     */
/*

0   2               a                        b             c
             /      |      \
1   5       j       k         l
          / | \    / | \     / | \
2   6    m  n  o  m  n  o   m  n  o

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
//_17_电话号码的字母组合2
public class _17_LetterCombinations_of_a_PhoneNumber2 {
    private char[][] lettersArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

        public List<String> letterCombinations(String digits) {
        if (digits == null)
            return null;
        // 结果集res字符串数组 输入input字符数组 每层元素level数组
        List<String> res = new ArrayList<>();
        char[] input = digits.toCharArray();
        if (input.length == 0)
            return res;
        char[] level = new char[input.length];
        // 层数 输入input字符数组 每层元素level数组 结果集res字符串数组
        dfs(input,0, res, level);
        return res;
    }

    /**
     * @param idx 正在搜索第idx层
     */
    private void dfs( char[] input,int idx, List<String> list, char[] level) {
        // 已经进入到最后一层了，不能再往下搜索
        if (idx == input.length) {
            // 得到了一个正确的解
            list.add(new String(level));
            return;
        }

        // 先枚举这一层可以做的所有选择
        // idx 层：可取值 0 1 2
        // idx 层可取输入按键 input[idx]  示例:输入2 5 6
        // idx 层输入按键对应的键盘字符下标 input[idx]-'2'
        char[] letters = lettersArray[input[idx] - '2'];
        for (char letter : letters) {
            level[idx] = letter;
            dfs(input,idx + 1, list, level);
        }
    }

/*

0   2               a                        b             c
             /      |      \
1   5       j       k         l
          / | \    / | \     / | \
2   6    m  n  o  m  n  o   m  n  o

    private char[][] lettersArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

 */


}
