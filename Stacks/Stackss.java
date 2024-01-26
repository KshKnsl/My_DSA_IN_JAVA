package Stacks;
import java.util.*;

public class Stackss
{
    Node top;
    Stackss()
    {
        top=null;
    }
    void push(int item)
    {
        Node nptr=new Node(item);
        if(top==null)
        {
            top=nptr;
        }
        else
        {
            nptr.next=top;
            top=nptr;
        }
        System.out.println(item + " is pushed into the list ");
    }
    void pop()
    {
        Node ptr;
        if(top==null)
        {
            System.out.println("Stack is underflow");
        }
        else
        {
            ptr=top;
            top=top.next;
            System.out.println(ptr.data+"gets popped");
        }
    }
    void display()//to display the nexted list
    {
        Node ptr;
        if(top==null)
            System.out.println("List is empty");
        else
        {
            ptr=top;
            while(ptr!=null)//till the end of the list
            {
                System.out.print(ptr.data+"-->");//printing the datarmation
                ptr=ptr.next;//moving the pointer forward
            }
        }
        System.out.println();
    }
    public static void main(String s[])
    {
        Scanner sc=new Scanner(System.in);
        Stackss st=new Stackss();
        int item,choice;
        char ch;
        do
        {
            System.out.println("Menu\n1.PUSH\n2.POP\n3.Show");
            System.out.println("\nEnter your choice ");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter the item ");
                    item=sc.nextInt();
                    st.push(item);
                    break;
                case 2:
                    st.pop();
                    break;
                case 3:
                    st.display();
                    break;
                default:
                    System.out.println("Wrong Choice");
            }
            System.out.print("Do you want more ");
            ch=sc.next().charAt(0);
        }while(ch=='y');        
        sc.close();
    }
}   