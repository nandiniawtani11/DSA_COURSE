package Graphs;

import java.util.ArrayList;

public class BuildGraph {
    public static class Edge{
        int src;
        int des;

        public Edge(int s, int d){
            this.des=d;
            this.src=s;
        }

    }

    public static class WeightedEdge{
        int src;
        int des;

        int wt;

        public WeightedEdge(int s, int d, int w){
            this.des=d;
            this.src=s;
            this.wt=w;
        }

    }

    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> graph[] = new ArrayList[4];
        ArrayList<WeightedEdge> weightedGraph[] = new ArrayList[4];

        buildGraph(graph);
        buildWeigthedGraph(weightedGraph);

        //printing all the neighbours of vertex 2
        for(int i=0;i<graph[2].size();i++){
            Edge e = graph[2].get(i);
            System.out.println(e.des);
        }

        for(int i=0;i<weightedGraph[2].size();i++){
            WeightedEdge e = weightedGraph[2].get(i);
            System.out.println(e.des+" "+e.wt);
        }
    }

    private static void buildGraph(ArrayList<Edge>[] graph) {

        for(int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));


    }

    //Building weighted Graph
    private static void buildWeigthedGraph(ArrayList<WeightedEdge>[] graph) {

        for(int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new WeightedEdge(0,2,2));

        graph[1].add(new WeightedEdge(1,2,-1));
        graph[1].add(new WeightedEdge(1,3,3));

        graph[2].add(new WeightedEdge(2,0,2));
        graph[2].add(new WeightedEdge(2,3,3));
        graph[2].add(new WeightedEdge(2,1,-1));

        graph[3].add(new WeightedEdge(3,1,3));
        graph[3].add(new WeightedEdge(3,2,3));

    }
}
