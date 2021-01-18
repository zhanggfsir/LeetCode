package _88_VIP6.funnyHashMap;

import java.util.HashMap;

// 205. 同构字符串
/*
给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

示例 1:

输入: s = "egg", t = "add"
输出: true
示例 2:

输入: s = "foo", t = "bar"
输出: false
示例 3:

输入: s = "paper", t = "title"
输出: true
说明:
你可以假设 s 和 t 具有相同的长度。

 */
public class _205_IsomorphicStrings {       //  todo  同构字符串 = s 和 t 字符串的字符种类 对应

//    https://leetcode-cn.com/problems/isomorphic-strings/solution/

    /*
    1
    可以利用一个 map 来处理映射。对于 s 到 t 的映射，我们同时遍历 s 和 t ，假设当前遇到的字母分别是 c1 和 c2 。

如果 map[c1] 不存在，那么就将 c1 映射到 c2 ，即 map[c1] = c2。

如果 map[c1] 存在，那么就判断 map[c1] 是否等于 c2，也就是验证之前的映射和当前的字母是否相同。

2

对于这道题，我们只需要验证 s - > t 和 t -> s 两个方向即可。如果验证一个方向，是不可以的。

举个例子，s = ab, t = cc，如果单看 s -> t ，那么 a -> c, b -> c 是没有问题的。

必须再验证 t -> s，此时，c -> a, c -> b，一个字母对应了多个字母，所以不是同构的。

代码的话，只需要调用两次上边的代码即可。

     */
    //  205 同构字符串 easy   map(s1[i],s2[i]) s1 在一个位置的值=s2在一个位置的值 当s1中重复时s2仍要相等
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);

    }

    //    同构字符串 = s 和 t 字符串的字符种类 对应
    //    输入: s = "egg", t = "add"    输出: true
    private boolean isIsomorphicHelper(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {         // 2.map有c1,则如果map.get(c1) != c2, 则返回false
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {                          // 1.map无c1,放入 c1,c2
                map.put(c1, c2);               // todo 解题关键 map 中放入 s[i]  t[i]
            }
        }
        return true;
    }



}
