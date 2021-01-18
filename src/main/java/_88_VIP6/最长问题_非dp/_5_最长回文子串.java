package _88_VIP6.最长问题_非dp;

/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

示例 2：
输入: "cbbd"
输出: "bb"

 */
public class _5_最长回文子串 {

    public static void main(String[] args) {
//        String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s = "cbbd";
        System.out.println(longestPalindrome2(s));
        ;
    }



    //暴力解法  如下方法超出时间限制了  个人感觉还是不错的
    public static String longestPalindrome1(String s) {
        String ans = "";
        int max=0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String sub = s.substring(i, j);
                if (sub.length() > max && isPalindromic(sub)) {
                    ans = s.substring(i, j);
                    max=Math.max(max,ans.length());
                }
            }
        return ans;
    }
     // 单个字符串是回文字符串的判定
    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 暴力解法
    public String longestPalindrome0(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (test.length() > max && isPalindromic(test)) {
                    max = test.length();
                    ans = s.substring(i, j);
                }

            }
        return ans;
    }

    // 方法2 解法 4: 扩展中心
//    回文串一定是对称的，所以我们可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可。
//    由于存在奇数的字符串和偶数的字符串，所以我们需要从一个字符开始扩展，或者从两个字符之间开始扩展，所以总共有 n+n-1 个中心。
/*
思路
 1.定义三个变量，start end maxLen
    1.1 怎么获得当前回文串长度 ？
        i-(i+1) 中心扩散 [先声明i，再扩散]
    1.2 什么时间更新3个变量 ？
        当前回文串长度 > 最大长度maxLen
    1.3 更新为多少 ？
        maxLen=curMaxLen;
        start =i-(curMaxLen-1)/2;
        end   =i+(curMaxLen)/2
 */
    //TODO _5_最长回文子串
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int curMaxLen = Math.max(len1, len2);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                start = i - (curMaxLen - 1) / 2;  // i是当前下标
                end = i + curMaxLen / 2;
            }
            // abibc abiibc  已知中心i坐标，回文字符串的长度maxLen，求：截取回文字符串
            // 1.求第一个b出现 最后一个b出现的坐标
            // 2.求第一个b出现的坐标为begin，begin+maxLen-1 即得最后 一个b出现的下标.
            //      abibc begin=0,maxLen=3 ,最后一个b出现的下标0+3-1

        }
        return s.substring(start, end + 1);
    }
    private static int expandAroundCenter(String s, int left, int right) {
        // 跳出 while时，恰好满足 s.charAt(left) !=s.charAt(right)
        // 即下标left=0 [s.charAt(left)='a']; right=4,[s.charAt(right)='c']
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // abibc 最长回文字符串为 bib ，其中 left=0 right=4，需要返回的回文字符串为 right-left-1=4-0-1
        return right - left - 1; // 从left 到 right中间一共有几个数
    }
    //方法 2-2

    public static String longestPalindrome2_2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int curMaxLen = Math.max(len1, len2);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                start = i - (curMaxLen - 1) / 2;  // i是当前下标
            }
            // abibc abiibc  已知中心i坐标，回文字符串的长度maxLen，求：截取回文字符串
            // 1.求第一个b出现 最后一个b出现的坐标
            // 2.求第一个b出现的坐标为begin，begin+maxLen-1 即得最后 一个b出现的下标.
            //      abibc begin=0,maxLen=3 ,最后一个b出现的下标0+3-1

        }
        return s.substring(start, start + maxLen);
    }




}
