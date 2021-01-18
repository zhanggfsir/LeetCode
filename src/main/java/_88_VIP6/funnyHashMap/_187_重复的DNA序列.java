package _88_VIP6.funnyHashMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。

示例：
输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC", "CCCCCAAAAA"]


 */
public class _187_重复的DNA序列 {


    public static void main(String[] args) {
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        System.out.println(findRepeatedDnaSequences(str));
    }

    // 解法1 暴力超时
//    暴力的方法，双层循环，选取一组然后和后边的所有组进行比较，如果发现重复的组就把它加入到结果中。为了防止加入重复的结果，我们用 set 进行存储。
    public List<String> findRepeatedDnaSequences1(String s) {
        int len = s.length();
        Set<String> res = new HashSet<>();
        for (int i = 0; i <= len - 10; i++) {
            for (int j = i + 1; j <= len - 10; j++) {
                if (s.substring(i, i + 10).equals(s.substring(j, j + 10))) {
                    res.add(s.substring(i, i + 10));
                    break;
                }
            }
        }
        return new ArrayList<>(res);
    }

    // 解法2 hashset
    // 由于每一组都遍历了两次，所以造成了时间的浪费。
    // 我们可以利用一个 HashSet ，每遍历一组就将其放入，在加入之前判断 HashSet 中是否存在，
    // 如果存在就说明和之前的发生重复，就把它加到结果中。从而我们可以减少一层循环。
    public List<String> findRepeatedDnaSequences2(String s) {
        int len = s.length();
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= len - 10; i++) {   // 此处可以 <=  ; 即使等于 在s.substring中也取不到
            String key = s.substring(i, i + 10);
            //之前是否存在
            if (set.contains(key)) {
                res.add(key);
            } else {
                set.add(key);
            }

        }
        return new ArrayList<>(res);
    }



    //  https://leetcode-cn.com/problems/repeated-dna-sequences/
    //  https://leetcode-cn.com/problems/repeated-dna-sequences/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-4-7/
    //  不好理解
    public static  List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if (len == 0 || len < 10) {
            return new ArrayList<>();
        }
        Set<String> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        char map[] = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int key = 0;
        char[] array = s.toCharArray();
        //第一组单独初始化出来
        for (int i = 0; i < 10; i++) {
            key = key << 2 | map[array[i] - 'A'];
            System.out.println("k->"+key);
        }
        System.out.println("k-->"+key);  //      int k=00000000000101010101;

        set.add(key);
        for (int i = 10; i < len; i++) {
            key <<= 2;
            key |= map[array[i] - 'A'];
            key &= 0xfffff;
            if (set.contains(key)) {
                res.add(s.substring(i - 9, i + 1));
            } else {
                set.add(key);
            }

        }
        return new ArrayList<>(res);
    }


}
