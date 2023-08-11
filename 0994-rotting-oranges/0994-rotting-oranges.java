//all rotten in begin ---> 0
//not all rotten finally or no orange ---> -1

import java.util.LinkedList;
import java.util.Queue;


class Solution {
    int count = 0;
    int count2 = 0;
    int Max = 0;
    Queue<int[]> q = new LinkedList<>();
    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    public int orangesRotting(int[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;
        int temp[][] = new int[nRows][nCols];
            
        //count number of orange
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nCols; c++) {
                if(grid[r][c] != 0) count++;
                if(grid[r][c] == 2){
                    q.offer(new int[]{r, c, 0});
                    System.out.printf("[%d, %d, 0]\n", r, c);
                }
            }
        }
        
        //No oranges or all rotten
        if(count == 0 ||count == q.size()) return 0;
        
        while(!q.isEmpty()){
            int[] loc = q.poll();
            count--;
            temp[loc[0]][loc[1]] = 1;
            for (int[] d : dir) {
                int tempr = loc[0] + d[0];
                int tempc = loc[1] + d[1];
                if (tempr < 0 || tempc < 0 || tempr >= nRows || tempc >= nCols||
                    grid[tempr][tempc]!=1 || temp[tempr][tempc] == 1) continue;
                q.offer(new int[]{tempr, tempc, loc[2]+1});
                temp[tempr][tempc] = 1;
                Max = Math.max(Max, loc[2]+1);
                System.out.printf("[%d, %d, %d]\n", tempr, tempc, loc[2]+1);
            }
        }
        if(count != 0) return -1;
        return Max;
    }
}