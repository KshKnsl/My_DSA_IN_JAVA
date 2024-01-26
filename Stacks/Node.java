package Stacks;
import java.util.*;
class Node
{
    int data;
    Node next;
    static Node head;
    Node(int d)
    {
        data=d;
        next = null;
    }
    void traverse()
    {
        Node c=head;
        while(c!=null)
        {
            System.out.print(c.data+"--->");
            c=c.next;
        }
        System.out.println();
    }
    void insert(int p,int data)
    {
        Node add = new Node(data);
        Node c= head;
        if(p==0)
        {
            add.next=head;
            head=add;
            return;
        }
        for(int i =0;i<p-1;i++)
        {
            c=c.next;
            System.out.println(c.data);
        }
        add.next=c.next;
        c.next=add;
    }
    void delete(int p)
    {
        Node c=head;
        if(p==0)
        {
            head=head.next;
            return;
        }
        for(int i=0;i<p-1;i++)
        {
            c=c.next;
        }
        c.next=c.next.next;
    }
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 5 numbers of linted list");
        Node n1=new Node(sc.nextInt());
        Node n2=new Node(sc.nextInt());
        Node n3=new Node(sc.nextInt());
        Node n4=new Node(sc.nextInt());
        Node n5=new Node(sc.nextInt());
        head=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.traverse();
        int data,p;
        System.out.print("Enter the number to be inserted: ");
        data=sc.nextInt();
        System.out.print("Enter the position to be inserted: ");
        p=sc.nextInt();
        n1.insert(p,data);
        n1.traverse();
        System.out.print("Enter the position to be deleted: ");
        p=sc.nextInt();
        n1.delete(p);
        n1.traverse();
        sc.close();
    }
}