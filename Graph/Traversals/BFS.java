//here we use a queue to implement BFS (like a level order traversal)
// in BFS we visit all the nodes at the same level before moving to the next level while storing all the nodes at the next level in a queue
//also store visited bool array to avoid visiting the same node again
import java.util.*;
class BFS 
{
    ArrayList<Edge> graph[];
    @SuppressWarnings("unchecked")
    BFS(int V)
    {
        graph = new ArrayList[V];
    }
    static class Edge 
    {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) 
        {
            this.src = s;            this.dest = d;            this.wt = w;
        }
    }
    void createGraph() 
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
    void bfs(int V) 
    {
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // Source = 0
        while (!q.isEmpty()) 
        {
            int curr = q.remove();
            if (!visited[curr]) 
            {
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) 
                {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
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
        BFS ob = new BFS(V);
        ob.createGraph();
        ob.bfs(V);
        //if graph is disconnected
        // for (int i = 0; i < V; i++)
        // { if (!visited[i])   bfs(i, visited); }
    }
}