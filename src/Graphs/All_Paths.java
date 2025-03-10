package Graphs;

import Graphs.BuildGraph.Edge ;
import Graphs.BFS_DFS;

import java.util.ArrayList;

public class All_Paths {

    public static void allPaths(ArrayList<Edge>[] graph, int curr, boolean[] visited, int target, String path){
        if(curr==target){
            System.out.println(path);
            return;
        }

        for (int i=0; i<graph[curr].size();i++){
            if(!visited[curr]){
                visited[curr]=true;
                Edge e = graph[curr].get(i);
                allPaths(graph,e.des,visited,target,path+e.des);
                visited[curr]=false;
            }
        }

    }

    public static void main(String[] args) {

        ArrayList<Edge> graph[]= new ArrayList[7];

        BFS_DFS generateGraph = new BFS_DFS();
        generateGraph.buildGraph(graph);

        int src=1; int target=6;

        allPaths(graph,src,new boolean[7], target,String.valueOf(src));

    }
}
