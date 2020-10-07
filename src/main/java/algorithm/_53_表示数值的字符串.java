package algorithm;


/*
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class _53_表示数值的字符串 {
    public static void main(String[] args) {
        String s="+100";
        String s2="5e2";
        System.out.println(Integer.parseInt(s)); // 报错了
        double re = Double.parseDouble(new String(s2));
        System.out.println(Integer.parseInt(s2));// 报错了




    }
    //正则表达式解法
    public class Solution {
        public boolean isNumeric(char[] str) {
            String string = String.valueOf(str);
            return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
        }
    }
/*
以下对正则进行解释:
[\\+\\-]?            -> 正或负符号出现与否
\\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
(\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
                        否则一起不出现
([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
                        紧接着必须跟着整数；或者整个部分都不出现
*/


     //  但是感觉有毛病
    public boolean isNumeric2(char[] str) {
        try {
            double re = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

//参见剑指offer -------------------- 感觉应该不会考到吧 ，有时间了 再看吧 --------------------------------
 class Solution {
    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str.length < 1)
            return false;

        boolean flag = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;

    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-') )
            index++;
        return scanUnsignedInteger(str);

    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        return start < index; //是否存在整数
    }
}

