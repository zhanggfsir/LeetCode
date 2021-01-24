package _88_VIP6.DFS._77_组合bobo_;/// Source : https://leetcode.com/problems/combinations/description/
/// Author : liuyubobobo
/// Time   : 2017-11-18

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/// Naive Recursive Optimized
/// Time Complexity: O(n^k)
/// Space Complexity: O(k)
public class Solution2 {

    private ArrayList<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<List<Integer>>();
        if(n <= 0 || k <= 0 || k > n)
            return res;

        LinkedList<Integer> c = new LinkedList<Integer>();
        generateCombinations(n, k, 1, c);

        return res;
    }

    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c){

        if(c.size() == k){
            res.add((List<Integer>)c.clone());
            return;
        }

        // i will at most be n - (k - c.size()) + 1
        // 共取k个，已取c.size 还有 k - c.zise()个空位。所以，[1..n]中至少要有k-c.size()个元素  n可以取到，如果至少可以取1个，则i就应该为 n
        // i 最多为 n - (k - c.size()) + 1
        for(int i = start ; i <= n - (k - c.size()) + 1 ; i ++){
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

        List<List<Integer>> res = (new Solution2()).combine(4, 2);
        for(List<Integer> list: res)
            printList(list);
    }
}
