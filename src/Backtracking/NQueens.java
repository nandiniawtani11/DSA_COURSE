package Backtracking;

public class NQueens {
    public static void main(String[] args) {

        boolean[][] board={
                {false,false,false,false},
                {false,false,false,false},
                {false,false,false,false},
                {false,false,false,false}
        };
        System.out.println(ways(board,0));

    }

    public static int ways(boolean[][] board, int r){
        if(r==board.length){
            display(board);
            System.out.println();
            return 1;
        }

        int count=0;

        for(int c=0;c<board.length;c++){
            //place the queen if it is safe
            if(isSafe(board,r,c)){
                board[r][c]=true;
                count=count+ ways(board,r+1);
                board[r][c]=false;
            }

        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int r, int c) {

        //for checking up
        for(int i=r-1;i>=0;i--){
            if(board[i][c]) {
                return false;
            }
        }

        //for checking left diagonal
        int maxleft= Math.min(r,c);
        for(int i=1;i<=maxleft;i++){
            if(board[r-i][c-i]) {
                return false;
            }
        }

        //for checking right diagonal
        int maxRight= Math.min(r, board.length-c-1);
        for(int i=1;i<=maxRight;i++){
            if(board[r-i][c+i]) {
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board) {

        for(boolean[] row:board){
            for(boolean j :row){
                if(j){
                    System.out.print("Q");
                }
                else{
                    System.out.print("X");
                }
            }
            System.out.println();
        }

    }
}
