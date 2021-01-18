package _88_VIP6.对撞指针;

/*
125. 验证回文串

给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false

 */
public class _125_ValidPalindrome_Vip {  // todo 对撞指针

 //  todo 有一个判读字符 是数字或者字符的方法 Character.isLetterOrDigit(charArray[i])
//    对撞指针，如果是标准字符串  abba
    public boolean isPalindrome(String s) {
//        String str=""; str.charAt(i)
        int i = 0, j = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (i < j) {
            // 将i和j指向第一个是字母和数字的位置
            while (  i < j && !Character.isLetterOrDigit(charArray[i])) {
                i++;
            }
            while (i < j &&  !Character.isLetterOrDigit(charArray[j]) ) {
                j--;
            }
            // 如果不相等，就返回false  // todo 如果只是一个连续英文字母的字符串
            if ((int) Character.toLowerCase(charArray[i]) != (int) Character.toLowerCase(charArray[j])) {
                return false;
            }
            // 将i和j向中间移动
            i++; j--;
        }
        return true;
    }


    // TODO 正常思路也要看一下
    /*
        1.得到 只考虑字母和数字字符 的sb
        2.反转比较大小
     */
    public boolean isPalindrome2(String s) {
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            if(Character.isLetterOrDigit(c))
                sb.append(c);
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    // 高层次 [主干] 逻辑
    // 方法三
    /*
        1. filter out number & char
        2. reversee and compare
     */
    public boolean isPalindrome3(String s) {
        String fiteredS = filterNonNumberAndChar(s);
        return reverseString(fiteredS).equalsIgnoreCase(fiteredS);
    }

    private String reverseString(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    private String filterNonNumberAndChar(String s) {
        return s.replaceAll("[^A-Za-z0-9]","");
    }


}
