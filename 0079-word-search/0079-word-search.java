class Solution {
    public boolean exist(char[][] board, String word) {
        int ROW = board.length;
        int COL = board[0].length;
        for(int i = 0; i < ROW;i++){
            for(int j = 0; j < COL; j++){
                if(DFS(i, j, 0, board, word)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean DFS(int ROW, int COL, int len, char[][] board, String word) {
        int i = board.length;
        int j = board[0].length;
        if(len >= word.length()) return true;
        if(
            ROW < 0 ||
            COL < 0 ||
            ROW >= i ||
            COL >= j ||
            board[ROW][COL] != word.charAt(len)
        )return false;
        boolean exist = false;
        if(board[ROW][COL] == word.charAt(len)){
            board[ROW][COL] += 50;
            exist = (
                DFS(ROW+1, COL, len+1, board, word)||
                DFS(ROW, COL+1, len+1, board, word)||
                DFS(ROW-1, COL, len+1, board, word)||
                DFS(ROW, COL-1, len+1, board, word)
            );
            board[ROW][COL] -= 50;
        }
        return exist;
    }
    
}