class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) ans =
                    Math.max(dfs(grid, i, j, new int[] { 0 }), ans);
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int i, int j, int[] count) {
        if (
            i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0
        ) return count[0];
        count[0]++;
        grid[i][j] = 0;
        dfs(grid, i - 1, j, count);
        dfs(grid, i + 1, j, count);
        dfs(grid, i, j - 1, count);
        dfs(grid, i, j + 1, count);
        return count[0];
    }
}