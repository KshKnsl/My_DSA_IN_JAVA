package LinkedList;
import java.util.*;
public class ReverseList//This class will be LINKing the nodes and also perform the required operations
{
    Node start;//this implies that the list is empty or new list is statrting
    ReverseList()
    {
        start=null;
    }
    void insert(int item)//to insert a node
    {
        Node ptr=null;//pointer which will move from start till end==It stores the adress of current node and its LINK field contains the adress of LINK node 
        Node save=null;//It stores the address of previous node and its LINK field contains the adress of current node //or temp
        Node nptr=new Node(item);//calling constructor to create a new node
        if(start==null)//if list is empty the new node dtai.e. nptr becomes the start
        {
            start=nptr;
        }
        else if(nptr.info<start.info)//insertion takes in the beginning
        {   //here list is not empty but it contains at least one node
            nptr.LINK=start;//The new node is LINKed with the rest of the ReverseList
            start=nptr;//new node inserted is made the first node
        }
        else//here insertion occurs in middle
        {
            ptr=start.LINK;//to start checking from the first node(i.e. start) till the end of list 
            save=start;//ptr becomes the second node while save becomes the first node
            while(ptr!=null)//to check till we reach the end(i.e. ptr==null) of the list 
            {
                if(nptr.info<ptr.info&&nptr.info>save.info)//to check if the node is to be inserted b/w current node and previous node
                {
                    nptr.LINK=ptr;//current node address in the new nodes LINK field
                    save.LINK=nptr;//new node's address in previous node's LINK field
                    break;
                }
                else//to move the ptr forward
                {
                    save=ptr;//save moves forward
                    ptr=ptr.LINK;//ptr moves forward
                }
            }
            if(ptr==null)//if item is to be inserted at the end
            {   //ptr here is the LINK field of last node
                save.LINK=nptr;//Set the adress of new node in the LINK field of the last node 
            }
        }        
    }     
    void show()//to display the LINKed list
    {
        Node ptr=start;//creating a new node to start from the first node and print it and move forward
        if(start==null)
            System.out.println("List is empty");
        else
        {
            while(ptr!=null)//till the end of the list
            {
                System.out.print(ptr.info+"-->");//printing the information
                ptr=ptr.LINK;//moving the pointer forward
            }
        }
        System.out.println();
    }
    void reverseNewList()
    {
        ReverseList  revlst=new ReverseList();
        Node ptr,nptr;
        revlst.start = null;
        ptr=start;
        while(ptr!=null)
        {
            nptr=new Node(ptr.info);
            if(revlst.start==null)
            {
                revlst.start=nptr;
            }
            else
            {
                nptr.LINK=revlst.start;
                revlst.start=nptr;
            }
            ptr=ptr.LINK;
            revlst.show();
        }
    }
    void reversesame()
    {
        Node p1,p2,temp;
        p1=start;
        p2=p1.LINK;
        p1.LINK=null;
        while(p2!=null)
        {
            start=p2;
            temp=p1;
            p1=p2;
            p2=p1.LINK;
            p1.LINK=temp;
        }
    }
    public static void main(String s[])
    {
        Scanner sc=new Scanner(System.in);
        ReverseList l=new ReverseList();
        int item,choice;
        char ch;
        do
        {
            System.out.println("Menu\n1.Insert\n2.Delete\n3.Show\n4.reverse in different list\n5.reverse in same list");
            System.out.println("\nEnter your choice ");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter the item ");
                    item=sc.nextInt();
                    l.insert(item);
                    break;
                case 3:
                    l.show();
                    break;
                case 4:
                    l.reverseNewList();
                    break;
                case 5:
                    l.reversesame();
                    break;
                default:
                    System.out.println("Wrong Choice");
            }
            System.out.print("Do you want more ");
            ch=sc.next().charAt(0);
        }while(ch=='y');sc.close();
    }
}