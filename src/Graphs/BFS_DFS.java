package Graphs;

import Graphs.BuildGraph.Edge ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS {

    private static void buildGraph(ArrayList<Edge>[] graph) {

        for(int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }

    public static void main(String[] args) {
        ArrayList<Edge> graph[] =new ArrayList[7];

        buildGraph(graph);

        //bfs(graph);

        boolean visited[] =new boolean[7];
        dfs(graph,0,visited);
    }

    public static  void dfs(ArrayList<Edge>[] graph, int current, boolean[] visited){
        if(current> graph.length){
            return;
        }
        if(!visited[current]){
            System.out.println(current);
            visited[current]=true;

            for(int i=0;i<graph[current].size();i++){
                Edge e= graph[current].get(i);
                dfs(graph,e.des,visited);

            }
        }
        else {
            return;
        }

    }

    private static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> queue =new LinkedList<>();
        boolean visited[] =new boolean[7];

        queue.add(0);
        while (!queue.isEmpty()){
            int currentNode= queue.remove();
            if(!visited[currentNode]){
                System.out.print(currentNode+" ");
                visited[currentNode]=true;

                for(int i=0;i<graph[currentNode].size();i++){
                    Edge e= graph[currentNode].get(i);
                    queue.add(e.des);
                }
            }
        }
    }

}
