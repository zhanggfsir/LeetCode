package _88_VIP6.DFS._200_岛屿数量_bobo;/// Source : https://leetcode.com/problems/number-of-islands/description/
/// Author : liuyubobobo
/// Time   : 2017-11-18

/// Floodfill - DFS
/// Recursion implementation
///
/// Time Complexity: O(n*m)
/// Space Complexity: O(n*m)
/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。



示例 1：

输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
示例 2：

输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3
 

提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 的值为 '0' 或 '1'

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//  _200_岛屿数量 概率 26

/*
1. 二维数组的大小 m n

2. 方向数组d[][]

3. 是否访问过 visit[][]

4. 是否越界 inArea( x , y )
 */
class Solution {
    /*
    ------y
    |
    |
    x
    {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    (x,y+1),(x+1,y),(x,y-1),(x-1,y),
      右      下       上     左
     */
    private int m, n;
    private int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 4个方向 右下上左的。4个方向，都能访问到就行
    private boolean visited[][];
    private boolean inArea(int x, int y) {
        return x >= 0 && x <= m-1  && y >= 0 && y <= n-1 ;
    }

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];

        int res = 0;        // 岛屿数量

        for (int i = 0; i <= m-1; i++)
            for (int j = 0; j <= n-1; j++)
                if (grid[i][j] == '1' && !visited[i][j]) { //对grid的每一个点来说，如果==1 是陆地，并且没有被访问过
                    dfs(grid, i, j);        // i j 作为起始点开始进行深度优先遍历
                    res++;                 // 找到了一个陆地 res++
                }
        return res;
    }

    // 从grid[x][y]的位置开始，进行floodfill
    // 没有写终止条件。保证(x,y)合法，且grid[x][y]是没有被访问过的陆地。终止条件放在了if条件中了
    private void dfs(char[][] grid, int x, int y) {

        //assert(inArea(x,y));
        visited[x][y] = true;       // 该位置被访问       问题：没有置为false 最初要找和i j连接的所有点全都标记上，而不是找到某一个具体的序列或者具体的值。所以只标记为true，无false。
        for (int i = 0; i < 4; i++) {    //从该位置出发，向4个方向遍历
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if (grid[newx][newy] == '1' && !visited[newx][newy] && inArea(newx, newy))   // 新位置是一个陆地，新位置没有被访问过，新位置没有越界----
                dfs(grid, newx, newy);  // 找到一个新的没有被标记过的陆地 ，和当前xy的位置相连接。就递归调用dfs函数，对newx newy进行遍历
        }
        return;
    }



    public static void main(String[] args) {

        char grid1[][] = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println((new Solution()).numIslands(grid1));


        char grid2[][] = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println((new Solution()).numIslands(grid2));

    }


























































    class Solution_ {
        /*
        ------y
        |
        |
        x
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        (x,y+1),(x+1,y),(x,y-1),(x-1,y),
          右      下       上     左
         */
        private int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        private int m, n;
        private boolean visited[][];

        public int numIslands(char[][] grid) {

            if (grid == null || grid.length == 0 || grid[0].length == 0)
                return 0;

            m = grid.length;
            n = grid[0].length;

            visited = new boolean[m][n];

            int res = 0;        // 岛屿数量

            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (grid[i][j] == '1' && !visited[i][j]) { //对grid的每一个点来说，如果==1 是陆地，并且没有被访问过
                        dfs(grid, i, j);        // i j 作为起始点开始进行深度优先遍历
                        res++;                 // 找到了一个陆地 res++
                    }
            return res;
        }

        // 从grid[x][y]的位置开始，进行floodfill
        // 没有写终止条件。保证(x,y)合法，且grid[x][y]是没有被访问过的陆地。终止条件放在了if条件中了
        private void dfs(char[][] grid, int x, int y) {

            //assert(inArea(x,y));
            visited[x][y] = true;       // 该位置被访问       问题：没有置为false 最初要找和i j连接的所有点全都标记上，而不是找到某一个具体的序列或者具体的值。所以只标记为true，无false。
            for (int i = 0; i < 4; i++) {    //从该位置出发，向4个方向遍历
                int newx = x + d[i][0];
                int newy = y + d[i][1];
                if (grid[newx][newy] == '1' && !visited[newx][newy] && inArea(newx, newy))   // 新位置是一个陆地，新位置没有被访问过，新位置没有越界----
                    dfs(grid, newx, newy);  // 找到一个新的没有被标记过的陆地 ，和当前xy的位置相连接。就递归调用dfs函数，对newx newy进行遍历
            }
            return;
        }

        private boolean inArea(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
        }

        public  void main(String[] args) {

            char grid1[][] = {
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '0', '1', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'}
            };
            System.out.println((new Solution()).numIslands(grid1));


            char grid2[][] = {
                    {'1', '1', '0', '0', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '1', '0', '0'},
                    {'0', '0', '0', '1', '1'}
            };
            System.out.println((new Solution()).numIslands(grid2));

        }
    }



}
