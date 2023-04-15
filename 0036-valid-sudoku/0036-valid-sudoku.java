class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] check=new int[9]; //check 1 to 9
        for(int i=0;i<=8;i++){ //for every rows
            for(int j=0;j<=8;j++){
                check[j]=0;
            }
            for(int j=0;j<=8;j++){
                if(board[i][j]!='.'){ //not null
                    if(check[Character.getNumericValue(board[i][j])-1]==1){ //if repeat
                        return false;
                    }
                    check[Character.getNumericValue(board[i][j])-1]=1;
                }
            }  
        }
        
        for(int j=0;j<=8;j++){ //check every cols
            for(int i=0;i<=8;i++){
                check[i]=0;
            }
            for(int i=0;i<=8;i++){
                if(board[i][j]!='.'){ //not null
                    if(check[Character.getNumericValue(board[i][j])-1]==1){ //if repeat
                        return false;
                    }
                    check[Character.getNumericValue(board[i][j])-1]=1;
                }
            }   
        }
        for(int j=0;j<=6;j=j+3){ //check every grid
            for(int i=0;i<=6;i=i+3){
                for(int k=0;k<=8;k++){
                    check[k]=0;
                }
                for(int k=0;k<=2;k++){
                    for(int l=0;l<=2;l++){
                        if(board[i+k][j+l]!='.'){ //not null
                            if(check[Character.getNumericValue(board[i+k][j+l])-1]==1){ //if repeat
                                return false;
                            }
                            check[Character.getNumericValue(board[i+k][j+l])-1]=1;
                        }
                    
                    }
                }

            }   
        }
        return true;
    }
}