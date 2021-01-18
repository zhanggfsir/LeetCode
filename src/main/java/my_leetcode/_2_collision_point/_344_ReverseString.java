package my_leetcode._2_collision_point;

/*
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

 

示例 1：

输入：["h","e","l","l","o"]
输出：["o","l","l","e","h"]
示例 2：

输入：["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]

 */
public class _344_ReverseString {  // todo 对撞指针


    /*

    字符串本质上是一个数组，所以反转字符串和反转数组是一样的：将第一个元素与末尾进行交换，
    再向前移动到下一个元素，并不断地交换，直到它到达中间位置。
我们可以使用两个指针分别指向字符串开头和结尾，持续交换它们所指向的元素，直到这两个指针相遇。

     */
    // 对撞指针
    public void reverseString(char[] s) {
        // 左右双指针
        int left = 0;
        int right = s.length - 1;
        // 交换元素的临时变量 temp
        char temp;

        while (left < right){
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

}
