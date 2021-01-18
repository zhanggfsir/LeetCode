package _88_VIP6.funnyHashMap;

import java.util.HashSet;
import java.util.Set;

/*
国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。

为了方便，所有26个英文字母对应摩尔斯密码表如下：

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作单词翻译。

返回我们可以获得所有词不同单词翻译的数量。

例如:
输入: words = ["gin", "zen", "gig", "msg"]
输出: 2
解释:
各单词翻译如下:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

共有 2 种不同翻译, "--...-." 和 "--...--.".
 

注意:

单词列表words 的长度不会超过 100。
每个单词 words[i]的长度范围为 [1, 12]。
每个单词 words[i]只包含小写字母。

D:\BaiduNetdiskDownload\java\慕课网[更多课程加微信zhishivip00001]-liuyubobobo-玩转算法系列--玩转数据结构 更适合0算法基础入门到进阶（java版）-299元\第7章 集合和映射
7-4 _Leetcode中的集合问题和更多集合相关问题更多课程加微信zhishivip00001

 */
public class






_804_唯一摩尔斯密码词 {
    public static void main(String[] args) {
        System.out.println('a'-'a');    // 0
    }
    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            // 共26个摩尔斯密码  代表26个字母
            String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                    "....","..",".---","-.-",".-..","--","-.",
                    "---",".--.","--.-",".-.","...","-","..-",
                    "...-",".--","-..-","-.--","--.."};

            Set<String> seen = new HashSet();
            for (String word: words) {
                StringBuilder code = new StringBuilder();
                for (char ch : word.toCharArray())
                    code.append(MORSE[ch - 'a']);
                seen.add(code.toString());
            }

            return seen.size();
        }
    }

}

//
//复杂度分析
//
//        时间复杂度：O(S)，其中 SS 是数组 words 中所有单词的长度之和。
//
//        空间复杂度：O(S)。