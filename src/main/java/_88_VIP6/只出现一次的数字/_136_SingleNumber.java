package _88_VIP6.只出现一次的数字;

import java.util.HashMap;
import java.util.Map;

/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4

 */
public class _136_SingleNumber {


    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count =map.getOrDefault(i,0)+1;
            map.put(i, count);
        }
        for (Integer i : nums) {
            if (map.get(i)==1){
                return i;
            }
        }
        return -1; // can't find it.
    }


    /*
    标签：位运算
    本题根据题意，线性时间复杂度 O(n)O(n)，很容易想到使用 Hash 映射来进行计算，遍历一次后结束得到结果，但是在空间复杂度上会达到 O(n)O(n)，需要使用较多的额外空间
    既满足时间复杂度又满足空间复杂度，就要提到位运算中的异或运算 XOR，主要因为异或运算有以下几个特点：
    一个数和 0 做 XOR 运算等于本身：a⊕0 = a
    一个数和其本身做 XOR 运算等于 0：a⊕a = 0
    XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
    故而在以上的基础条件上，将所有数字按照顺序做抑或运算，最后剩下的结果即为唯一的数字
    时间复杂度：O(n)O(n)，空间复杂度：O(1)O(1)
    代码

     */
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}


