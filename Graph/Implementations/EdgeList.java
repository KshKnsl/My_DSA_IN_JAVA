import java.util.ArrayList;
public class EdgeList 
{
    ArrayList<Edge> graph;
    EdgeList()
    {
        graph = new ArrayList<>();
    }
    void addEdge(int source, int destination, int weight)
    {
        graph.add(new Edge(source, destination, weight));
    }
    public static void main(String[] args)
    {
        EdgeList graph = new EdgeList();
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 4, 6);
    }    
}
