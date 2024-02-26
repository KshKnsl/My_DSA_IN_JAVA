import java.util.*;
public class BinaryTreeImplement
{
    class Node
    {
        Node left,right;
        int value;
        Node()         {            this.value=0;            left=null;      right=null;    }
        Node(int value){            this.value=value;        left=null;      right=null;    }
        Node(int value,Node l, Node r){   this.value=value;  left=l;         right=r;       }
    }
    Node root;
    public void display(Node root,String indent)
    {
        if(root==null)  return;
        System.out.println(indent+root.value);
        display(root.left,indent+"\t");
        display(root.right,indent+"\t");
    }
    public void insert(Scanner scanner)
    {
        System.out.print("Enter the root Node value: ");
        root= new Node(scanner.nextInt());
        insert(scanner,root);
    }
    private void insert(Scanner scanner, Node root) 
    {
        System.out.println("Do you want to the left of : "+ root.value);
        if(scanner.nextBoolean())
        {
            System.out.println("Enter left value of : "+ root.value);
            int le = scanner.nextInt();        
            root.left=new Node(le);
            insert(scanner, root.left);
        }
        System.out.println("Do you want to the right of : "+ root.value);
        if(scanner.nextBoolean())
        {
            System.out.println("Enter right value of : "+ root.value);
            int ri = scanner.nextInt();        
            root.right=new Node(ri);
            insert(scanner, root.right);
        }
    }

    private void prettyDisplay(Node node, int level) 
    {
    if (node == null)     return;
    prettyDisplay(node.right, level + 1);
    if(level != 0) 
    {
        for(int i=0;i<level-1;i++) 
        {
            System.out.print("|\t\t");
        }
        System.out.println("|------->" + node.value);
    } 
    else      System.out.println(node.value);
    prettyDisplay(node.left, level + 1);
  }
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        BinaryTreeImplement ob= new BinaryTreeImplement();
        ob.insert(sc);
        ob.display(ob.root,"\t");
        ob.prettyDisplay(ob.root, 0);
    }
    
    private void preOrder(Node node) 
    {
        //root left right
        if (node == null)    return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder(Node node) 
    {
        //left root right
        if (node == null)    return;
        preOrder(node.left);
        System.out.print(node.value + " ");
        preOrder(node.right);
    }

    private void postOrder(Node node) 
    {
        //left right root
        if (node == null)    return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.value + " ");
    }  
}