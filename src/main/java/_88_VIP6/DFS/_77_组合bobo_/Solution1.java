package _88_VIP6.DFS._77_组合bobo_;/// Source : https://leetcode.com/problems/combinations/description/
/// Author : liuyubobobo
/// Time   : 2017-11-18

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/// Naive Recursive
/// Time Complexity: O(n^k)
/// Space Complexity: O(k)
/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

链接：https://leetcode-cn.com/problems/combinations

 */
public class Solution1 {

    //  k 就是树的深度
    private ArrayList<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<List<Integer>>();
        if(n <= 0 || k <= 0 || k > n)
            return res;

        LinkedList<Integer> c = new LinkedList<Integer>();
        generateCombinations(n, k, 1, c);   // 从n个里面取出k个值

        return res;
    }

    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c){

        if(c.size() == k){
            res.add((List<Integer>)c.clone());
            return;
        }

        for(int i = start ; i <= n ; i ++){ //从n个数里面取k个，是数字 1~n，故下标从1开始,[1,n]
            c.addLast(i);
            generateCombinations(n, k, i + 1, c);
            c.removeLast();
        }

        return;
    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        List<List<Integer>> res = (new Solution1()).combine(4, 2);
        for(List<Integer> list: res)
            printList(list);
    }
}
