import java.util.*;
class AVL_TREE
{
    AVL_TREE(){}
    class Node 
    {
        Node left, right;
        int value;
        int height;
        Node(int value) 
        {       this.value = value;       }
    }
    private Node root;

  static void print2DUtil(Node root, int space)
    {
        // Base case
        if (root == null)
            return;
 
        // Increase distance between levels
        space += 10;
 
        // Process right child first
        print2DUtil(root.right, space);
 
        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.print(root.value + "\n");
 
        // Process left child
        print2DUtil(root.left, space);
    }
 
    // Wrapper over print2DUtil()
    void print2D(Node root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

    public int height() 
    {
        return height(root);
    }
    public int height(Node root) 
    {
        if (root == null)         return -1;
        return root.height;
    }
    public void insert(int value) 
    {
        root=insert(value, root);  
    }
    public Node insert(int value, Node node) 
    {
        //for creating a new node and interting it in the tree.this step will make tree unbalanced
        if(node == null) 
        {
            node = new Node(value);
            return node;
        }
        if (value < node.value)
            node.left = insert(value, node.left);
        if (value > node.value)
            node.right = insert(value, node.right);
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        //return the node after rotation //to return the balanced tree
        return rotate(node);
    }
    private Node rotate(Node node)//returns the balanced tree
    {
        if(height(node.left)-height(node.right)>1)//left heavy case could be left-left case or left-right case
        {
            if(height(node.left.left)-height(node.left.right)>0)//left-left case
            {
                //so right rotate on Parent
                return rightRotate(node);
            }
            if(height(node.left.left)-height(node.left.right)<0)//left-right case
            {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (height(node.left) - height(node.right) < -1) 
        {
          // right heavy
          if(height(node.right.left) - height(node.right.right) < 0) 
          {
            // right right case
            return leftRotate(node);
          }
          if(height(node.right.left) - height(node.right.right) > 0) 
          {
                // left right case
            node.right = rightRotate(node.right);
            return leftRotate(node);
          }
        }
        return node;
    }
    private Node leftRotate(Node c)
    {
        Node p = c.right;
        Node t2 = p.left;
        p.left=c;
        c.right=t2;
        p.height = Math.max(height(p.left),height(p.right))+1;
        c.height = Math.max(height(c.left),height(c.right))+1;
        return p;
    }
    private Node rightRotate(Node p)
    {
        Node c = p.left;
        Node t2 = c.right;
        c.right=p;
        p.left=t2;
        p.height = Math.max(height(p.left),height(p.right))+1;
        c.height = Math.max(height(c.left),height(c.right))+1;
        return c;
    }

    public void display() 
    {
        display(this.root, "Root Node: ");
    }
    private void display(Node node, String details) 
    {
        if (node == null)            return;
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public static void main(String[] args) 
    {
        AVL_TREE tree = new AVL_TREE();
        for(int i = 1; i <= 10; i++)
        {
            tree.print2D(tree.root);
            tree.insert(i);
            System.out.println("DOne");
        }
        tree.print2D(tree.root);
        System.out.println(tree.height());
    }
}