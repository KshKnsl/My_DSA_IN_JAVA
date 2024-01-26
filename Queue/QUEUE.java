package Queue;
import java.util.*;
public class QUEUE
{
    int rear , front,item,MAX,Q[];
    Scanner sc;
    QUEUE()
    {
        sc=new Scanner(System.in);
        rear=-1;
        front = -1;
        item=0;
        MAX=5;
        Q = new int[MAX];
    }
    void inqueue()//insertion
    {
        if(rear==MAX-1)
        {
            System.out.println("OVERFLOW");
        }
        else 
        {
            System.out.println("Enter the item");
            item=sc.nextInt();
            if(rear==front && front==-1)
            {
                rear=0;
                front=0;
                Q[rear]=item;
            }
            else
            {
                rear=rear+1;
                Q[rear]=item;                
            }
            System.out.println("Item inserted");
        }
    }
    void dequeue()//deletion
    {
        if(front==-1&&rear==-1)
        {
            System.out.println("Underflow");
        }
        else if(front == rear)
        {
            item=Q[front];
            front=-1;
            rear=-1;
            System.out.println("Item "+item+" has been deleted");
        }
        else
        {
            item=Q[front];
            front=front+1;
            System.out.println("Item "+item+" has been deleted");
        }
    }
    void display()
    {
        int i;
        if(front==-1)
        {
            System.out.println("QUEUE is empty ");
        }
        else
        {
            for(i=front;i<=rear;i++)
            {
                System.out.print(Q[i]+" , ");
            }
        }
    }
    public static void main()
    {
        char cho;
        QUEUE s = new QUEUE();
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("Menu\n1.Insert\n2.Delete\n3.Display");
            System.out.println("Enter your choice :");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1: s.inqueue(); break;
                case 2: s.dequeue(); break;
                case 3: s.display(); break;
                default: System.out.println("Wrong choice ");
            }
            System.out.println("Do you want more?");
            cho=s.sc.next().charAt(0);
        }while(cho=='y'||cho=='Y');
        sc.close();
    }
}