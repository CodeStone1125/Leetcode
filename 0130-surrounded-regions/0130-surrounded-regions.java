class Solution {
    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for(int i = 0;i<col;i++){
            if(board[0][i]=='O') dfs(board, 0, i);
            if(board[row - 1][i]=='O') dfs(board, row - 1, i);
        }
        for(int i = 0;i < row;i++){
            if(board[i][0]=='O') dfs(board, i, 0);
            if(board[i][col - 1]=='O') dfs(board, i, col - 1);
        }
        for(int i = 0; i < col;i++){
            for(int j = 0;j < row;j++){
                if(board[j][i] == 'T'){
                    board[j][i] = 'O';
                }
                else board[j][i] = 'X';
            }
        }
        return;
    }
    public void dfs(char[][] board, int i, int j){
        if(i < 0 || 
           j < 0 ||
           i > board.length - 1 ||
           j > board[0].length - 1||
           board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'T';
        for (int[] d : dir) {
            dfs(board, i + d[0], j + d[1]);
        }
        
    }
}
