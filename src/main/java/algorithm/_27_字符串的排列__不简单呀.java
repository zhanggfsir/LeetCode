package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

 */
public class _27_字符串的排列__不简单呀 {

    public static void main(String[] args) {
//        Solution p = new Solution();
        System.out.println(Permutation("abc").toString());
    }

    /*
你在IDE上用断点调试下，看看每步执行的过程，这样你会好理解一点。第二个swap保证程序发生交换后，
* 恢复到交换之前的状态。举个例子：对于上图的左子树，当程序将ACB加入到list中，
* 此时数组的状态就是ACB，因为递归的原因，程序会退栈回到根节点。
* 如果没有第二个swap的话，此时的根节点是ACB，而不是ABC，显然这不是我们想要的结果。
     */
    public static ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList)res;
    }

    public  static void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) { // i==2
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
            System.out.println( val+"  "+list);
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                System.out.println(i+"-->"+j);
                PermutationHelper(cs, i+1, list);
                swap(cs, i, j);
                System.out.println(i+" "+j);
            }
        }
    }

    public static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
