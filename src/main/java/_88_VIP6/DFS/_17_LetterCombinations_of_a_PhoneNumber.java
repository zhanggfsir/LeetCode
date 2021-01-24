package _88_VIP6.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */


// _17_电话号码的字母组合  概率 48
public class _17_LetterCombinations_of_a_PhoneNumber {
    private char[][] lettersArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    // 存放 输入的字符 例如 arg = { 2,5,6 }
    private char[] input;
    /** 存放 每一层选择的字母 例如 ajm ajn ajo akm akn ako  ... */
    private char[] level;
    // 存放 最终的结果
    private List<String> res;

    public List<String> letterCombinations(String digits) {
        if (digits == null)
            return null;
        res = new ArrayList<>();
        input = digits.toCharArray();   //  2 5 6
        if (input.length == 0)
            return res;
        level = new char[input.length];
        dfs(0);
        return res;
    }
    /**
     * @param idx 正在搜索第idx层
     */
    private void dfs(int idx) {
        // 越界。已经进入到最后一层了，不能再往下搜索
        if (idx == input.length) {
            // 得到了一个正确的解
            res.add(new String(level));
            return;        // 回到调用处，调用处for循环继续取出下一个字符
        }

        // 先枚举这一层可以做的所有选择的字母
        // 如果是2 选择第0个{'a', 'b', 'c'}；如果是5 选择第3个{'j', 'k', 'l'}；如果是6 选择第1个{'m', 'n', 'o'}
        char[] letters = lettersArray[input[idx] - '2'];
        for (char letter : letters) {       // letter 一个字母
            level[idx] = letter;     // 覆盖,在那一层就该放什么位置 256示例 a->0 j->1 m->2
            dfs(idx + 1);   // 继续去下一层
        }
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations_("23"));;
    }

    /////////////////////////////////////////////////////////////////////////////
    //      注意以下为 dfs -- 排列组合 的套路 ！！ 记死

    /**
     * @param idx 正在搜索第idx层
     */
    private void dfs_(int idx) {
        if (idx == input.length){
            // 已经进入到最后一层了，不能再往下搜索
            // 得到一个正确的解
            // list.add()
            return;
        }

        // 先枚举这一层可以做的所有选择：拿到数字字符，根据数字字符确定可以选哪些字母
        // 1. 选择一个值    2. 进入下一层
        for (char c : "所有能选择的字母".toCharArray()){
            dfs(idx + 1 );
        }
    }








    /////////////////////////////////////////////////////////////////////////////
    public static List<String> letterCombinations_(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty())
            return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            System.out.println("x: "+x+"  ans:"+ans+"  ans.peek()："+ans.peek());
            while(ans.peek().length()==i){
                System.out.println(" ans.peek(): "+ans.peek()+"  ans.peek().length(): "+ans.peek().length()+"  i: "+i);
                String t = ans.remove();
                for(char s : mapping[x].toCharArray()) {
                    System.out.println("mapping[x="+x+"]: " + mapping[x] + "  mapping[x="+x+"].toCharArray(): " + String.valueOf(mapping[x].toCharArray()) + "  t: "+t +"  s:"+s+ "  t+s:" + (t + s));
                    ans.add(t + s);
               }
                System.out.println("    ans:"+ans);
            }
            System.out.println("-------while is over--------------------");
        }
        System.out.println("===============for is over=======================");
        return ans;
    }



//  https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/javafei-chang-jing-qiao-de-dui-lie-jie-fa-by-xxxzz/
    // _17_电话号码的字母组合
    public List<String> letterCombinations3(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){       // for 取出输入digit中的数字 23 则：x= 2 ; 3
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){          // while 取出上一次ans结果
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())  // 遍历当前按键的字符
                    ans.add(t+s);
            }
        }
        return ans;
    }



}


/*

0	2		     a				b		c
			 /   |   \
1	5	    j	 k     l
		   /|\  /|\   /|\
2	6	  m n o m n o m n o


 */