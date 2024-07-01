import java.util.*;
// here we start at a source vertex and then visit all the vertices connected to the source vertex.
// then we visit the vertices connected to the vertices connected to the source vertex and so on.
// we use a stack to keep track of the vertices to be visited or simply use recursion.
public class DFS 
{
    static class Edge 
    {
        int src,dest,wt;
        public Edge(int s, int d, int w) 
        {
            this.src = s;            this.dest = d;            this.wt = w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) 
    {
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(6, 5, 1));
    }
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]) 
    {
        if (visited[curr])    return;
        System.out.print(curr + " ");
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) 
        {
            dfs(graph, graph[curr].get(i).dest, visited);
        }
    }
    public static void main(String args[]) 
    {
        /*
         *   1 ---- 3
         *  /       | \
         * 0        |  5 -- 6
         *  \       | /
         *   2 ---- 4
         */
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean visited[] = new boolean[V];
        dfs(graph, 0, visited);
        //if graph is disconnected
        // for (int i = 0; i < V; i++) 
        // {
        //     if (!visited[i]) 
        //     {
        //         dfs(graph, i, visited);
        //     }
        // }
    }
}