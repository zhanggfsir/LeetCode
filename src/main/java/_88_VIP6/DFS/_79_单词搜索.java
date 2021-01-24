package _88_VIP6.DFS;


/// Source : https://leetcode.com/problems/word-search/description/
/// Author : liuyubobobo
/// Time   : 2017-10-14

// Backtrack
// Time Complexity: O(m*n*m*n)
// Space Complexity: O(m*n)
/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
 

提示：

board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
// 概率 79
public class _79_单词搜索 {
    /*  ------ y
        |
        |
        x
        顺时针数组   二维平面经常使用
     */
    // 偏移量数组 上右下左  向上：x方向减1，y方向不动(x-1,y)；向右：(x，y+1)；向下：(x+1,y)；向左 (x,y-1)
    private int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        if (board == null || word == null)
            throw new IllegalArgumentException("board or word can not be null!");

        m = board.length;
        assert (m > 0);
        n = board[0].length;

        visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (searchWord(board, word, 0, i, j)) // 每一次找word的一个位置的元素，即word的第index的位置
                    return true;                                // 从二维数组board的  startx starty开始找
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    // start from board[startx][starty], find word[index...word.size())
    private boolean searchWord(char[][] board, String word, int index, int startx, int starty) {

        //assert( inArea(startx,starty) );
        if (index == word.length() - 1)// 要找的index就是word的最后一个字符的时候
            return board[startx][starty] == word.charAt(index); // 此时要看board的最后一个字符是否是 word的最后一字符

        if (board[startx][starty] == word.charAt(index)) {      // 否则开始搜索 当前board的位置和word的index下标元素是相等的
            // 从startx starty出发，向四个方向寻找
            visited[startx][starty] = true;
            for (int i = 0; i < 4; i++) { // 4个方向
                int newx = startx + d[i][0];    // 要找的新的方向，每次向4个方向走一步的坐标
                int newy = starty + d[i][1];
                if (inArea(newx, newy) && !visited[newx][newy] &&
                        searchWord(board, word, index + 1, newx, newy))
                    return true;
            }
            visited[startx][starty] = false; // 开始的时候占据了元素的位置，向其他4个方向寻找；其他4个方向寻找都没有结果，放弃该位置
        }
        return false;       // 如果不等，直接return false
    }


    public static void main(String args[]) {

        char[][] b1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        String words[] = {"ABCCED", "SEE", "ABCB"};
        for (int i = 0; i < words.length; i++)
            if ((new _79_单词搜索()).exist(b1, words[i]))
                System.out.println("found " + words[i]);
            else
                System.out.println("can not found " + words[i]);

        // ---

        char[][] b2 = {{'A'}};
        if ((new _79_单词搜索()).exist(b2, "AB"))
            System.out.println("found AB");
        else
            System.out.println("can not found AB");
    }
}
