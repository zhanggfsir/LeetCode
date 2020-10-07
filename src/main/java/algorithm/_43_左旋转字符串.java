package algorithm;

/*
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class _43_左旋转字符串 {
    public static void main(String[] args) {
        String str="abcXYZdef"; // XYZdefabc            abcXYZdefabcXYZdef
        // 方法1 一个 substr就搞定了
        System.out.println(LeftRotateString4(str,3));
    }
    // 方法 2
    /**
     * 思路：
     * 1.先翻转前半部分
     * 2.再翻转后半部分
     * 3.再对字符串整个进行翻转
     *
     * 考点：不使用库对字符串进行灵活的翻转
     *
     * 原理: YX = (XTY T)T
     */
    public String LeftRotateString2(String str,int n) {
        if (str == null || str.length() == 0 || n < 0 || n > str.length()) {
            return str;
        }
        char[] ch = str.toCharArray();
        reverseString(ch, 0, n - 1);
        reverseString(ch, n, str.length() - 1);
        reverseString(ch, 0, str.length() - 1);
        return new String(ch);
    }

    /**  很重要
     * 对字符数组 ch 的 start 到 end 范围内的字符进行翻转
     */
    public void reverseString(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }

    // 如上 方法1 用sb，效率高
    public String LeftRotateString3(String str, int n) {
        if (str == null || str.length() == 0) return "";
        StringBuilder sb1 = new StringBuilder(str.substring(0, n));
        StringBuilder sb2 = new StringBuilder(str.substring(n, str.length()));
        sb2.append(sb1);
        return sb2.toString();
    }

// swap 突然不会写了
    public  static  String LeftRotateString4(String str, int n)
    {
        char []s=str.toCharArray();
        int len = str.length();
        if(len == 0) return str;
        n %= len;
        for(int i = 0, j = n - 1; i < j; ++i, --j) swap(s[i], s[j]);
        for(int i = n, j = len - 1; i < j; ++i, --j) swap(s[i], s[j]);
        for(int i = 0, j = len - 1; i < j; ++i, --j) swap(s[i], s[j]);
        return new String(s);
    }
    public  static  void swap(char i, char j){
        char tmp=i;
        i=j;
        j=tmp;
    }

}
