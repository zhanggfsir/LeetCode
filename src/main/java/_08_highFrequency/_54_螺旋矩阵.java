package _08_highFrequency;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
/*
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null)         return null;
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0)     return res;

        int top = 0;
        int bottom = matrix.length - 1; // 一共有几行
        int left = 0;
        int right = matrix[0].length - 1;   // 一共有几列
        while (top <= bottom && left <= right) {
            //top行: left top -> right top    左上角 -> 右上角
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);    // 行固定 top这一行 left->right 这几列
            }
            top++;

            //right列:  right top -> right bottom  右上 -> 右下
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]); // 列固定 right这一列 top->botton 这几列
            }
            right--;

            // 奇数行、偶数列的时候有问题
            if (top > bottom || left > right) break;

            //bottom行:  right bottom -> left bottom  右下 -> 左下
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);  // 行固定 bottom这一列 right -> left 这几行
            }
            bottom--;

            //left列 left bottom -> left top    左下 -> 左上
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);   // 列固定  left这一列 bottom -> top 这几行
            }
            left++;
        }
        return res;
    }
}


class _54_螺旋矩阵2 {
   public List<Integer> spiralOrder(int[][] matrix) {
       if (matrix == null)         return null;
       List<Integer> res = new ArrayList<>();
       if (matrix.length == 0)     return res;

       int top = 0;
       int bottom = matrix.length - 1; // 一共有几行
       int left = 0;
       int right = matrix[0].length - 1;   // 一共有几列
       while (top <= bottom && left <= right) {
           //top行: left -> right
           for (int i = left; i <= right; i++) {
               res.add(matrix[top][i]);    // 行固定 top这一行 left->right 这几列
           }
           top++;

           //right列:  top -> bottom
           for (int i = top; i <= bottom; i++) {
               res.add(matrix[i][right]); // 列固定 right这一列 top->botton 这几列
           }
           right--;

           // 奇数行、偶数列的时候有问题
           if (top > bottom || left > right) break;

           //bottom行:  right -> left
           for (int i = right; i >= left; i--) {
               res.add(matrix[bottom][i]);  // 行固定 bottom这一列 right -> left 这几行
           }
           bottom--;

           //left列:   bottom -> top
           for (int i = bottom; i >= top; i--) {
               res.add(matrix[i][left]);   // 列固定  left这一列 bottom -> top 这几行
           }
           left++;
       }
       return res;
   }
}