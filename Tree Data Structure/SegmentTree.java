class SegmentTree
{
    class Node
    {
        int data;
        int startInterval,endInterval;
        Node left,right;
        Node(int startInterval, int endInterval)
        {
            this.startInterval=startInterval;
            this.endInterval=endInterval;
        }
    }
    Node root;
    public SegmentTree(int[] arr) 
    {
        //create a tree using this array
        this.root=constructTree(arr,0,arr.length-1);
    }
    private SegmentTree.Node constructTree(int[] arr, int start, int end) 
    {
        Node node = new Node(start,end);
        if(start==end)
            node.data=arr[start];
        else
        {
            node.left = constructTree(arr,start,(start+end)/2);
            node.right= constructTree(arr,(start+end)/2+1,end);
            node.data= node.left.data + node.right.data ;
        }
        return node;
    }
    public void display(Node node)
    {
        String str = "";
        if(node.left != null)
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => "; 
        else 
            str = str + "No left child";

        // for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= "; 
        
        if(node.right != null)
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data; 
        else
            str = str + "No right child";

        System.out.println(str + '\n');

        if(node.left != null)      display(node.left);
        if(node.right!= null)      display(node.right);
    }
    public int query(Node node, int qstartIndex, int qendIndex) 
    {
        // node is completely lying inside query
        if(node.startInterval >= qstartIndex && node.endInterval <= qendIndex)
            return node.data;
        else if (node.startInterval > qendIndex || node.endInterval < qstartIndex)//completely outside
            return 0;
        else    //partially inside
            return this.query(node.left, qstartIndex, qendIndex) + this.query(node.right, qstartIndex, qendIndex);
    }
    public int update(Node node, int index, int value) 
    {
        if (index >= node.startInterval&& index <= node.endInterval)
        {
            if(index == node.startInterval && index == node.endInterval) 
            {
                node.data = value;
                return node.data;
            } 
            else 
            {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }
    public static void main(String[] args)
    {
        int arr[]= {3,8,3,6,7,-1,-8,4,9};
        SegmentTree tree = new SegmentTree(arr);
        tree.display(tree.root);
    }   
}