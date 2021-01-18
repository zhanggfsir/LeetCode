package _88_VIP6.最长问题_非dp;

/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:
输入: ["flower","flow","flight"]
输出: "fl"

示例 2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。

 */
//  14. 最长公共前缀
public class _14_最长公共前缀_LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] strs={"flower","floq"};
        String[] strs={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    // 14 最长公共前缀 ["flower","flow","flight"]->"fl"

    public static String longestCommonPrefix_(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {  // 从第二个 str 开始得到每一个 str
            int j=0;        // 公共串的下标
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                { break;}
            }
            ans = ans.substring(0, j);
            System.out.println("ans->"+ans+" j="+j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }


    //  提供方法2

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            for (int i = 0; i < strs[0].length(); i++) {
                char ch = strs[0].charAt(i);
                for (String str : strs) {
                    if (i >= str.length() || ch != str.charAt(i)) {
                        strs[0] = strs[0].substring(0, i);
                    }
                }
            }
            return strs[0];
        }
    }



    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {  // 从第二个 str 开始得到每一个 str
            int j=0;        // 公共串的下标
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                { break;}
            }
            ans = ans.substring(0, j);
            System.out.println("ans->"+ans+" j="+j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }


//    public static String longestCommonPrefix(String[] strs) {
//        if(strs.length == 0)
//            return "";
//        String ans = strs[0];
//        for(int i =1;i<strs.length;i++) {  // 从第二个 str 开始得到每一个 str
//            int j=0;
//            System.out.println("ans->"+ans+" strs["+i+"]->"+strs[i]);
//            for(;j<ans.length() && j < strs[i].length();j++) {
//                System.out.println("ans.charAt("+j+")->"+ans.charAt(j)+" strs["+i+"].charAt("+j+")->"+strs[i].charAt(j)+" ans="+ans);
//                if(ans.charAt(j) != strs[i].charAt(j)){
//                    System.out.println("break->"+"ans.charAt("+j+")="+ans.charAt(j)+" strs["+i+"].charAt("+j+")="+strs[i].charAt(j));
//                    break;}
//            }
//            ans = ans.substring(0, j);
//            System.out.println("ans->"+ans+" j="+j);
//            if(ans.equals(""))
//                return ans;
//        }
//        return ans;
//    }


//    标签：链表
//    当字符串数组长度为 0 时则公共前缀为空，直接返回
//    令最长公共前缀 ans 的值为第一个字符串，进行初始化
//    遍历后面的字符串，依次将其与 ans 进行比较，两两找出公共前缀，最终结果即为最长公共前缀
//    如果查找过程中出现了 ans 为空的情况，则公共前缀不存在直接返回
//    时间复杂度：O(s)O(s)，s 为所有字符串的长度之和
//
//    链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/hua-jie-suan-fa-14-zui-chang-gong-gong-qian-zhui-b/

}
