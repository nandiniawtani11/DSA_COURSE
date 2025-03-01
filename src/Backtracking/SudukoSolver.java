package Backtracking;

public class SudukoSolver {
    public static void main(String[] args) {

        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if(solve(board)){
            dispay(board);
        }
        else {
            System.out.println("Cannot solve the suduko");
        }

    }

    public static boolean solve(int[][] board){
        int n = board.length;
        int row=-1;
        int col=-1;

        boolean emptyFound=true;
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                if(board[i][j]==0){
                    row=i;
                    col=j;
                    emptyFound=false;
                    break;
                }
            }
            if(emptyFound==false){
                break;
            }
        }

        if(emptyFound==true){
            return true;
        }

        for(int i=1;i<=9;i++){
            if(isSafe(board,row,col,i)){
                board[row][col]=i;
                if(solve(board)){
                    return true;
                }
                else {
                    board[row][col]=0;
                }
            }

        }
        return false;
    }

    private static void dispay(int[][] board) {

        for(int i=0;i<board.length;i++){
            for(int j=0;j< board.length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    public static boolean isSafe(int[][] board, int row, int col, int num){

        //checking if the number exist in row
        for(int i=0;i< board.length;i++){
            if(board[row][i]==num){
                return false;
            }
        }

        //checking if num exist in column
        for(int[]rows: board){
            if(rows[col] ==num){
                return false;
            }
        }

        //checking if the num is present in box
        int startRow= row - row%3;
        int startCol=col - col%3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i+startRow][j+startCol]==num){
                    return false;
                }
            }
        }
        return true;
    }
}
