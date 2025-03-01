package Backtracking;

public class NKnigths {
    public static void main(String[] args) {
        int n=4;

        boolean[][] board =new boolean[n][n];
        Knigths(board,0,0,4);

    }

    public static void Knigths(boolean[][] board, int row, int col, int k){
        if(k==0){
            display(board);
            System.out.println();
            return;
        }

        if(row== board.length-1 && col== board.length){
            return;
        }

        if(col== board.length){
            Knigths(board,row+1,0,k);
            return;
        }

        if(isSafe(board,row,col,k)){
            board[row][col]=true;
            Knigths(board,row,col+1,k-1);
            board[row][col]=false;
        }

        Knigths(board,row,col+1,k);

    }

    private static boolean isSafe(boolean[][] board, int row, int col, int k) {
        if(isValid(board,row-2,col+1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if(isValid(board,row-1,col+2)){
            if(board[row-1][col+2]){
                return false;
            }
        }

        if(isValid(board,row+1,col+2)) {
            if (board[row + 1][col + 2]) {
                return false;
            }
        }

        if(isValid(board,row+2,col+1)) {
            if (board[row + 2][col + 1]) {
                return false;
            }
        }

        if(isValid(board,row+2,col-1)) {
            if (board[row + 2][col - 1]) {
                return false;
            }
        }

        if(isValid(board,row+1,col-2)) {
            if (board[row + 1][col - 2]) {
                return false;
            }
        }

        if(isValid(board,row-1,col-2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        if(isValid(board,row-2,col-1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col){
        if(row>=0 && row< board.length && col>=0 && col< board.length){
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {

        for(boolean[] row:board){
            for(boolean j :row){
                if(j){
                    System.out.print("K");
                }
                else{
                    System.out.print("X");
                }
            }
            System.out.println();
        }

    }
}
