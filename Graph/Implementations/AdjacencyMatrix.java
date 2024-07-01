class AdjacencyMatrix
{
    //here true means there is an edge between two vertices
    boolean graph[][];// will be a int 2d array for weighted graph storing weights
    AdjacencyMatrix(int verticles)
    {
        graph = new boolean[verticles][verticles];
    }
    void addEdge(int source, int destination)
    {
        graph[source][destination] = true;
        graph[destination][source] = true;
    }
    public static void main(String[] args) 
    {
        AdjacencyMatrix graph = new AdjacencyMatrix(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                System.out.print(graph.graph[i][j] + " ");
            System.out.println();
        }
    }
}