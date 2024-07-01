import java.util.ArrayList;
class AdjacencyList
{
    ArrayList<Edge> graph[];
    @SuppressWarnings("unchecked")
    AdjacencyList(int verticles)
    {
        graph = new ArrayList[verticles];
        for (int i = 0; i < graph.length; i++)
        {
            graph[i] = new ArrayList<>();
        }
    }
    void addEdge(int source, int destination, int weight)
    {
        graph[source].add(new Edge(source, destination, weight));
    }
    public static void main(String[] args)
    {
        int vertices = 5;
        AdjacencyList graph = new AdjacencyList(vertices);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 4, 6);
    }
}
class Edge
{
    int source;
    int destination;
    int weight;
    Edge(int source, int destination, int weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}