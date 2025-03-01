package Backtracking;

import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {

        boolean[][] maze={
                {true,true,true},
                {true,false,true},
                {true,true,true}

        };

        int [][] sol=new int[3][3];
        //path(maze,0,0,"");
        Allpath(maze,0,0,"",sol,0);
    }

    public static void path(boolean [][] maze,int r,int c, String p){
        if(r==maze.length-1 && c== maze[0].length-1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        maze[r][c]=false;

        //Move down
        if(r<maze.length-1){
            path(maze,r+1,c,p+"D");
        }

        if(r>0){
            //Move up
            path(maze,r-1,c,p+"U");
        }

        if(c>0){
            //Move Left
            path(maze,r,c-1,p+"L");
        }

        if(c<maze[0].length-1){
            //Move right
            path(maze,r,c+1,p+"R");
        }

        maze[r][c]=true;
    }

    public static void Allpath(boolean [][] maze,int r,int c, String p,int[][] sol,int num){
        if(r==maze.length-1 && c== maze[0].length-1){
            sol[r][c]=num;
            for(int[] arr:sol){
                System.out.println(Arrays.toString(arr));
            }

            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        maze[r][c]=false;
        sol[r][c]=num;

        //Move down
        if(r<maze.length-1){
            Allpath(maze,r+1,c,p+"D",sol,num+1);
        }

        if(r>0){
            //Move up
            Allpath(maze,r-1,c,p+"U",sol,num+1);
        }

        if(c>0){
            //Move Left
            Allpath(maze,r,c-1,p+"L",sol,num+1);
        }

        if(c<maze[0].length-1){
            //Move right
            Allpath(maze,r,c+1,p+"R",sol,num+1);
        }

        maze[r][c]=true;
        sol[r][c]=0;
    }
}