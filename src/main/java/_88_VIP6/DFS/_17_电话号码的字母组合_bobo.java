package _88_VIP6.DFS;
//package secondStep;
import java.util.ArrayList;
import java.util.List;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。


示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */

/*
// 电话本
2 abc
3 def
4 ghi
 */

/*
          2
        / | \
   a      b      c
   3      3      3
  /|\    /|\    /|\
 d e f  d e f  d e f
(ad)     ...       (cf)
隐藏了一棵树 递归



   a      b      c
  /|\    /|\    /|\
 d e f  d e f  d e f
(ad)     ...       (cf)


 */
public class _17_电话号码的字母组合_bobo { // 中等

//    https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/tong-su-yi-dong-dong-hua-yan-shi-17-dian-hua-hao-m/
    public static void main(String[] args) {
        List<String> arrayList=letterCombinations("23");
        System.out.printf(arrayList.toString());  // [ad, ae, af, bd, be, bf, cd, ce, cf]

    }


        private static String letterMap[] = {
                " ",    //0
                "",     //1
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz"  //9
        };

        private static ArrayList<String> res;

        public static List<String> letterCombinations(String digits) {

            res = new ArrayList<String>();
            if(digits.equals(""))
                return res;

            findCombination(digits, 0, "");
            return res;
        }

        private static void findCombination(String digits, int index, String s){
            System.out.println(index+" : "+s);
            if(index == digits.length()){
                res.add(s);
                System.out.println("get "+s+" ,return");
                return;
            }
            Character c = digits.charAt(index);     // 0->2 1->3
//            System.out.println("-- c --"+c );
            String letters = letterMap[c - '0'];    // abc  def
            for(int i = 0 ; i < letters.length() ; i ++){
                System.out.println("digits["+index+"]="+c+" use "+letters.charAt(i));
                findCombination(digits, index+1, s + letters.charAt(i));
            }
            System.out.println("digits["+index+"]="+c+" complete,return ");
            return;
        }


    // findCombination(digits, 0, "");
    private static void findCombination2(String digits, int index, String s){
        if(index == digits.length()){
            res.add(s);
            return;
        }
        Character ch = digits.charAt(index);     // 0->2 1->3
        String letters = letterMap[ch - '0'];    // abc  def
        for(int i = 0 ; i < letters.length() ; i ++){
            findCombination2(digits, index+1, s + letters.charAt(i));
        }
        return;
    }
}

/*
0 :
digits[0]=2 use a
1 : a
digits[1]=3 use d
2 : ad
get ad ,return
digits[1]=3 use e
2 : ae
get ae ,return
digits[1]=3 use f
2 : af
get af ,return
digits[1]=3 complete,return
digits[0]=2 use b
1 : b
digits[1]=3 use d
2 : bd
get bd ,return
digits[1]=3 use e
2 : be
get be ,return
digits[1]=3 use f
2 : bf
get bf ,return
digits[1]=3 complete,return
digits[0]=2 use c
1 : c
digits[1]=3 use d
2 : cd
get cd ,return
digits[1]=3 use e
2 : ce
get ce ,return
digits[1]=3 use f
2 : cf
get cf ,return
digits[1]=3 complete,return
digits[0]=2 complete,return
[ad, ae, af, bd, be, bf, cd, ce, cf]
 */

