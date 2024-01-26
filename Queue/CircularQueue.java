package Queue;
import java.util.*;
public class CircularQueue
{
    int rear , front,item,MAX,Q[];
    Scanner sc;
    CircularQueue()
    {
        sc=new Scanner(System.in);
        rear=-1;
        front = -1;
        item=0;
        MAX=5;
        Q = new int[MAX];
    }
    void enqueue()//insertion
    {
        if((rear+1)%MAX==front)
        {
            System.out.println("OVERFLOW");
            return;
        }
        System.out.println("Enter the item");
        item=sc.nextInt();
        if(front==-1)
        {
            front=0;
        }
        rear=(rear+1)%MAX;
        Q[rear]=item;
        System.out.println("Item inserted");
    }
    void dequeue()//deletion
    {
        if(front==-1)
        {
            System.out.println("Underflow");
            return;
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
            front=(front+1)%MAX;
        }
    }
    void display()
    {
        int i;
        if(front==-1)
        {
            System.out.println("CirQUEUE is empty ");
        }
        else
        {
            for(i=front;i!=rear;i=(i+1)%MAX)
            {
                System.out.print(Q[i]+" , ");
            }
             System.out.println(Q[i]);
        }
    }
    public static void main()
    {
        char cho;
        CircularQueue s = new CircularQueue();
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("Menu\n1.Insert\n2.Delete\n3.Display");
            System.out.println("Enter your choice :");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1: s.enqueue(); break;
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
