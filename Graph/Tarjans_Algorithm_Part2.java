import java.util.*;

// suing articulation point concept in graph
public class Tarjans_Algorithm_Part2
{
    static class Edge
    {
        int src;
        int dest;

        public Edge(int s, int d)
        {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[])
    {
        for (int i = 0; i < graph.length; i++)
        {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, Stack<Integer> s, boolean vis[])
    {

        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest])
            {
                topSort(graph, e.dest, s, vis);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, boolean vis[], int dt[], int low[], int time,
            boolean isArticulation[])
    {

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int child = 0;
        for (int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if (e.dest == par)
                continue;
            if (vis[e.dest])
            {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            } else
            {
                dfs(graph, e.dest, curr, vis, dt, low, time, isArticulation);
                low[curr] = Math.min(low[curr], low[e.dest]);

                if (dt[curr] <= low[e.dest] && par != -1)
                {
                    isArticulation[curr] = true;
                }
                child++;
            }
        }
        if (par == -1 && child > 1)
        {
            isArticulation[curr] = true;
        }
    }

    public static void getArticulation(ArrayList<Edge> graph[], int V)
    {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean isArticulation[] = new boolean[V];
        for (int i = 0; i < V; i++)
        {
            if (!vis[i])
            {
                dfs(graph, i, -1, vis, dt, low, time, isArticulation);
            }
        }
        for (int i = 0; i < V; i++)
        {
            if (isArticulation[i])
            {
                System.out.println(i);
            }
        }
    }
}