package Graphs;
import Graphs.BuildGraph.Edge ;

import java.util.ArrayList;
import java.util.Stack;

public class Cyclic_Graphs {

    public static boolean isCyclic(ArrayList<Edge>[] graph, boolean[] visited, int parent, int curr){

        if(!visited[curr]){
            visited[curr]=true;
        }

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(visited[e.des] && parent!=e.des ){
                return true;
            }
            if(!visited[e.des]){
                if(isCyclic(graph,visited,curr,e.des)){
                    return true;
                }
            }
        }

        return false;

    }

    public static boolean directedCyclic(ArrayList<Edge>[] graph, boolean[] visited, int curr, boolean[] resurcion){
        visited[curr]=true;
        resurcion[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(resurcion[e.des]){
                return true;
            }
            if(!visited[e.des]){
                return directedCyclic(graph,visited,e.des,resurcion);
            }
        }
        resurcion[curr]=false;
        return false;
    }

    public static  void topSortUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, Stack<Integer> stack){
        visited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!visited[e.des]){
                topSortUtil(graph,visited,e.des,stack);
            }
        }
        stack.push(curr);
    }

    public static void topSort(ArrayList<Edge>[] graph, int V){
        boolean visited[]= new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                topSortUtil(graph,visited,i,stack);
            }

        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop() +" ");
        }
    }

    public static void main(String[] args) {

        ArrayList<Edge> graph[] =new ArrayList[7];

        BFS_DFS bfs_dfs = new BFS_DFS();

        bfs_dfs.buildGraph(graph);

       // System.out.println(isCyclic(graph,new boolean[7],-1,0));

        //System.out.println(directedCyclic(graph,new boolean[7],0,new boolean[7]));

        topSort(graph,6);

    }
}
