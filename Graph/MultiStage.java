// a multistage graph is a directed graph in which the nodes are divided into stages and the edges are directed from one stage to the next.
//Example:
/*
         2  ---> 5
       /   \   /  \
      /     \_/    \
     /      / \     \
    1--> 3 ---> 6---> 8
     \       /       /
      \     /       /
       \   /       /
         4  ---> 7
 */
// our task is to find the shortest path from 1 to 8 when each edge has a weight associated with it.
class MultiStage
{
    public static void main(String args[])
    {
        int stages=4,min,n=8;
        int cost[] = new int[n+1];
        int d[] = new int[n+1];
        int path[] = new int[n+1];
        // cost stores the cost of the shortest path from the node to the target node , d stores the node to which we should move to get the shortest path, path stores the shortest path
        int c[][] = { {0,0,0,0,0,0,0,0,0},
        {0,0,2,1,3,0,0,0,0},  {0,0,0,0,0,2,3,0,0},
        {0,0,0,0,0,6,7,0,0},  {0,0,0,0,0,6,8,9,0},
        {0,0,0,0,0,0,0,0,6},  {0,0,0,0,0,0,0,0,4},
        {0,0,0,0,0,0,0,0,5},  {0,0,0,0,0,0,0,0,0}    };
        cost[n]=0;// zero as it is the target node itself

        // start from the last stage and move to the first stage
        for(int i=n-1;i>=1;i--)
        {
            min=9999;
            for(int k=i+1;k<=n;k++)
            {
                if(c[i][k]!=0 && c[i][k]+cost[k]<min)
                {
                    min=c[i][k]+cost[k];
                    d[i]=k; // d stores the node to which we should move to get the shortest path
                }
            }
            cost[i]=min;
        }
        path[1]=1;
        path[stages]=n;

        for(int i=2;i<stages;i++)
        {
            path[i]=d[path[i-1]];
        }
        for(int i=1;i<=stages;i++)
        {
            System.out.print(path[i]+" ");
        }
    }
}