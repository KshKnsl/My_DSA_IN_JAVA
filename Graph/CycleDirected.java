import java.util.*;

public class CycleDirected
{
    static class Edge
    {
        int src, dest;

        public Edge(int s, int d)
        {
            this.src = s;
            this.dest = d;
        }
    }

    // graph1 - true
    static void createGraph(ArrayList<Edge> graph[])
    {
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    // graph2 - false
    // static void createGraph(ArrayList<Edge> graph[]) {
    // for(int i=0; i<graph.length; i++)
    // graph[i] = new ArrayList<>();
    // graph[0].add(new Edge(0, 1)); graph[0].add(new Edge(0, 2));
    // graph[1].add(new Edge(1, 3)); graph[2].add(new Edge(2, 3));
    // }
    // DFS traversal to detect cycle in directed graph
    // here stack is different form vis[] as stack is to keep track of current path
    // while vis[] is to keep track of visited nodes
    // remember a graph can have breaking points, so we need to keep track of
    // current path
    public static boolean isCyclicUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[])
    {
        vis[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) // cycle exists
                return true;
            else if (!vis[e.dest] && isCyclicUtil(graph, e.dest, vis, stack))
                return true;
        }
        stack[curr] = false;
        return false;
    }

    // O(V + E)
    public static boolean isCyclic(ArrayList<Edge>[] graph)
    {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++)
        {
            if (vis[i] == false)
            {
                boolean cycle = isCyclicUtil(graph, i, vis, new boolean[vis.length]);
                if (cycle)
                    return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[])
    {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCyclic(graph));
    }
}