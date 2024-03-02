import java.util.*;
public class BSTImplement 
{
    class Node 
    {
        Node left, right;
        int value;
        int height;
        Node(int value) 
        {
            this.value = value;
        }
    }
    Node root;
    public void insert(int value) 
    {     insert(value, root);  }

    private Node insert(int value, Node node) 
    {
        if (node == null) 
        {
            node = new Node(value);
            return node;
        }

        if (value < node.value)
            node.left = insert(value, node.left);
        
        if (value > node.value)
            node.right = insert(value, node.right);

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void populatedSorted(int[] nums) 
    {
        populatedSorted(nums, 0, nums.length);
    }

    private void populatedSorted(int[] nums, int start, int end) 
    {
        if (start >= end)            return;
        int mid = (start + end) / 2;
        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
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

    public boolean isEmpty() 
    { return root == null; }

    public boolean balanced() 
    { return balanced(root);}

    private boolean balanced(Node node) 
    {
        if (node == null)            return true;
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public int height(Node root) 
    {
        if (root == null)         return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        BSTImplement ob = new BSTImplement();
        int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        for (int i = 0; i < nums.length; i++)
            ob.insert(nums[i]);
    }
}