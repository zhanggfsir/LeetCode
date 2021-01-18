package _88_VIP6.最长问题_非dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 */
// TODO 无重复字符的最长子串
public class _3_无重复字符的最长子串_LongestSubstringWithoutRepeatingCharacters {  // todo 滑动窗口
    //freq[256]  共256个字符 ascii码为k的字符在子串中出现的频率 。如果是0没有重复，如果是1 产生了1个重复的字符。O(1)时间复杂度判断每一个字符在当前子串中是否重复

    public static void main(String[] args) {
//       String s="abcdabcbb";
        String s="abba";
        System.out.println(lengthOfLongestSubstring(s));;
    }
    // 思路 1.获取快指针的位置，快指针-慢指针 得到距离，并不断将快指针及位置信息放入map。
    //      2.当存放快指针的map包含慢指针时，更新慢指针的偏移量
    // TODO 快慢指针 关注2个元素 慢指针 快指针
    // TODO 滑动窗口 关注3个元素 慢指针 快指针  结果集ans 窗口【是否需要用快指针更新慢指针offset，map】                             快指针怎么存 [map]
    // 1. 快、慢指针；窗口ans[ map(fastValue,fastIndex) ]
    // 2. 当存放快指针的map包含慢指针时，更新慢指针的偏移量
    // 3. 更新窗口ans map
    public static int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();  // 也可以理解为用什么装 快指针
        for (int fast = 0; fast < s.length(); fast++) {
            char fastValue = s.charAt(fast);
            if (map.containsKey(fastValue)) {       // 什么时候会更新start的位置? 当map中包含重复元素的时候  //start 更新为多少? start更新为重复元素位置的下一位
                System.out.println(map.get(fastValue)+1+"  "+ slow);
                slow = Math.max(map.get(fastValue)+1, slow); // map中取的是什么? (当前位置的元素，当前位置的元素"上一次存放的"下标)
            }
            ans = Math.max(ans, fast - slow + 1); // 字符串距离为 end-start+1
            map.put(fastValue, fast);  //map中存的是什么? (当前位置的元素，当前位置的元素下标)
        }
        return ans;
    }


    public static int lengthOfLongestSubstring_(String s) {
        int slow = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();  // 也可以理解为用什么装 快指针
        for (int fast = 0; fast < s.length(); fast++) {
            char fastValue = s.charAt(fast);
            if (map.containsKey(fastValue)) {       // 什么时候会更新start的位置? 当map中包含重复元素的时候  //start 更新为多少? start更新为重复元素位置的下一位
//                System.out.println("slow->"+slow+"  ans->"+ans);
////                if(map.get(fastValue)+1> slow)
//                    slow = map.get(fastValue)+1;
                slow = Math.max(map.get(fastValue)+1, slow); // map中取的是什么? (重复元素位置的下一位，slow指针) //保证slow指针一直向前移动，不后溯 [abba,第二个a，slow指针会后溯 ]
            }
            ans = Math.max(ans, fast - slow + 1); // 字符串距离为 end-start+1
            System.out.println(" fast->"+fast+" fastValue->"+fastValue+"  map.get(fastValue)+1 -> "+map.get(fastValue)+1+""+" ans ->"+ans+" slow ->"+slow+" ans ->"+ans);
            map.put(fastValue, fast);  //map中存的是什么? (当前位置的元素，当前位置的元素下标)
        }
        return ans;
    }

//方法二及地址
//    https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/

        public static int lengthOfLongestSubstring2(String s) {
            // 哈希集合，记录每个字符是否出现过
            Set<Character> set = new HashSet<Character>();
            int n = s.length();
            // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
            int rk = -1, ans = 0;
            for (int i = 0; i < n; ++i) {
                if (i != 0) {
                    // 左指针向右移动一格，移除一个字符
                    System.out.println((i-1)+"  "+s.charAt(i - 1)+"  "+set.toString());
                    set.remove(s.charAt(i - 1));
                }
                while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                    // 不断地移动右指针
                    set.add(s.charAt(rk + 1));
                    rk++;
                }
                // 第 i 到 rk 个字符是一个极长的无重复字符子串
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }

}



