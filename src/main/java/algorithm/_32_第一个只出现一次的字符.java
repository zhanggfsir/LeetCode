package algorithm;

import java.util.Arrays;
import java.util.LinkedHashMap;

/*
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中
找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class _32_第一个只出现一次的字符 {
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar2("bacdBAACDb"));
    }
/*
数组大小为什么是58呢     52+6    6是Z~a
主要是由于A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122

为了省去判断大小写字母，把中间六个不是字母的字符也加进去了，所以数组长度不是52是58
 */
// TODO  hashmap 解决问题
    public static int FirstNotRepeatingChar(String str) {
        int[] words = new int[58];
        for (int i = 0; i < str.length(); i++) {
            words[((int) str.charAt(i)) - 65] += 1;
        }
        //bacdBAACDb
        System.out.println(str);
        //[2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(words));
        for (int i = 0; i < str.length(); i++) {    // 最关键的地方 是仍然继续遍历原数组
            if (words[((int) str.charAt(i)) - 65] == 1) {  // 1     a       1
                System.out.println( words[((int) str.charAt(i)) - 65] + " -- " + str.charAt(i) + "  " + i);
                return i;
            }
        }
        return -1;
    }




    public static int FirstNotRepeatingChar2(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        // wc
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++time);// ++time 不是time++
            }
            else {
                map.put(str.charAt(i), 1);
            }
        }
        int pos = -1;
        int i=0;
        for(;i<str.length();i++){       // 最关键的地方 是仍然继续遍历原数组
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return pos;
    }


/*
方法3
在Java中，char不是16位吗？65536？
bitMap位图法
 */

    public int FirstNotRepeatingChar3(String str) {
        char[] chars = str.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chars.length; i++) {
            map[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i]] == 1) return i;
        }
        return -1;
    }


    /*
    方法4 考察str.contains(String str)
//java直接有判断字符是否存在的函数
//我们只要判断在这个字符之前的字符和之后字符是否存在就可以判断字符是否唯一
     */
        public int FirstNotRepeatingChar4(String str) {
            char[] a = str.toCharArray();
            for (int i=0;i<a.length;i++){
                // i 为当前位，判断当前位之前 和 当前位之后 是否包含i位的值
                if (!str.substring(0,i).contains(a[i]+"") && !str.substring(i+1).contains(a[i]+""))
                    return i;
            }
            return -1;
        }

}

