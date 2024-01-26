package Stacks;
import java.util.*;
public class STACKS
{
    int item,top,st[],max;
    Scanner sc;
    STACKS()
    {
        sc=new Scanner(System.in);
        top=-1;
        max=5;
        st=new int[5];
    }
    void push()
    {
        if(top>=max-1)
        {
            System.out.println("OVERFLOW");
        }
        else
        {
            System.out.println("Enter the item");
            item=sc.nextInt();
            top=top+1;
            st[top]=item;
            System.out.println("Item inserted");
        }
    }
    void pop()
    {
        if(top<0)
        {
            System.out.println("Underflow");
        }
        else
        {
            item=st[top];
            top=top-1;
            System.out.println("Item "+item+" has been deleted");
        }
    }
    void display()
    {
        int i;
        if(top<=-1)
        {
            System.out.println("STACKS is empty ");
        }
        else
        {
            for(i=0;i<=top;i++)
            {
                System.out.print(st[i]+" , ");
            }
        }
    }
    public static void main()
    {
        char cho;
        STACKS s = new STACKS();
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("Menu\n1.Push\nPop\n3.Display");
            System.out.println("Enter your choice :");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1: s.push(); break;
                case 2: s.pop(); break;
                case 3: s.display(); break;
                default: System.out.println("Wrong choice ");
            }
            System.out.println("Do you want more?");
            cho=s.sc.next().charAt(0);
        }while(cho=='y'||cho=='Y');
        sc.close();
    }
}