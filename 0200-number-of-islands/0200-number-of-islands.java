class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visit = new boolean[rows][cols];
        for(int r = 0; r <= rows -1;r++){
            for(int c = 0; c <= cols - 1;c++){
                if((!visit[r][c] && grid[r][c] == '1') ){
                    bfs(grid, r, c, visit);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void bfs(char[][] grid, int rows, int cols, boolean[][] visit){
        visit[rows][cols] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{rows, cols});
        int[][] direction = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        while(!queue.isEmpty()){
            int[] removedPair = queue.poll();
            int r = removedPair[0];
            int c = removedPair[1];
            for(int[] dir:direction){
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                if(newRow < grid.length 
                   && newRow >= 0
                   && newCol < grid[0].length 
                   && newCol >= 0
                   &&!visit[newRow][newCol] 
                   && grid[newRow][newCol] == '1'
                ){
                    queue.add(new int[]{newRow, newCol});
                    visit[newRow][newCol] = true;
                }
                
            }
        }
        return;
        
    }
}