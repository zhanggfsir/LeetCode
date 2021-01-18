package my_leetcode._6_search_table_ADD_NEW;

import java.util.*;

/*
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。

 */
public class _49_GroupAnagrams {

    public static void main(String[] args) {
        // 写在前面：有一个问题，如果 是 {aa bb aa bb cc} 这样的字符串数组，要规范后放在一起，该怎么做
        String []strs={"aa","bb","aa","bb","cc"};
        Map<String, List> ans=new HashMap<String,List>();
        for (String s:strs){
            if(!ans.containsKey(s)) // 只有当s不存在时，才去创建 new ArrayList()
                ans.put(s,new ArrayList());
            ans.get(s).add(s);
        }

    }
    class Solution {
        /*
        写在前面：有一个问题，如果 是 {aa bb aa bb cc} 这样的字符串数组，要规范后放在一起，该怎么做
            1.每个字符串排序
            2.如果map中没有字符串，新建List并放入map
            3.将字符串放入map
         */
        // 字母异位次分组
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0)
                return new ArrayList();
            Map<String, List> ans = new HashMap<String, List>();
            for (String s : strs) {
                char[] ch = s.toCharArray();
                Arrays.sort(ch);    // k(logk)
                String key = String.valueOf(ch);
                if (!ans.containsKey(key))
                    ans.put(key, new ArrayList());
                ans.get(key).add(s);
            }
            return new ArrayList(ans.values());
        }
    }
    /*
时间复杂度：O(NK \log K)O(NKlogK)，其中 NN 是 strs 的长度，而 KK 是 strs 中字符串的最大长度。
    当我们遍历每个字符串时，外部循环具有的复杂度为 O(N)O(N)。然后，我们在 O(K \log K)O(KlogK) 的时间内对每个字符串排序。

空间复杂度：O(NK)O(NK)，排序存储在 ans 中的全部信息内容。
*/

}