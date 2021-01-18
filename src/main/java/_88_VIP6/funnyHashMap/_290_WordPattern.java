package _88_VIP6.funnyHashMap;


import java.util.HashMap;

//290. 单词规律
/*
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:

输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:

输入: pattern = "abba", str = "dog dog dog dog"
输出: false

说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。


 */
//_290_单词规律
public class _290_WordPattern {

    // todo 和 题目 205  如出一辙
    // 备注 string s  直接就有 s.charAt(i) 方法

//   输入: pattern = "abba", str = "dog cat cat dog"      //输出: true
    public boolean wordPattern(String pattern, String str) {
        String[] array1 = str.split(" ");
        if (array1.length != pattern.length()) {
            return false;
        }
        String[] array2 = pattern.split("");
        //两个方向的映射
        return wordPatternHelper(array1, array2) && wordPatternHelper(array2, array1);
    }

    //array1 到 array2 的映射
    private boolean wordPatternHelper(String[] array1, String[] array2) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < array1.length; i++) {
            String k1 = array1[i];
            String k2=array2[i];
            if (map.containsKey(k1)) {
                if (!map.get(k1).equals(k2)) {
                    return false;
                }
            } else {
                map.put(k1, k2);
            }
        }
        return true;
    }

//    todo  有时间看看 分析挺好
//    https://leetcode-cn.com/problems/word-pattern/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--53/

}
