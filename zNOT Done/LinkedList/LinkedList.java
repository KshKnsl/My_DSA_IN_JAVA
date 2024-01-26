package LinkedList;
import java.util.*;
class Node//This is the class to create a node for us .
{
    Node LINK;//the LINK field of each node
    int info;//the info field of each node 
    Node()//to create the ptr,nptr,start,save nodes
    {
        info=0;
        LINK=null;
    }
    Node(int itm)//To create the node to be inserted
    {
        info=itm;//storing item in the node
        LINK=null;//the node's LINK is to initialised as null for now
    }   
}
public class LinkedList//This class will be LINKing the nodes and also perform the required operations
{
    Node start=null;    //this implies that the list is empty or new list is statrting
    void insert(int item)//to insert a node
    {
        Node ptr=null;//pointer which will move from start till end==It stores the adress of current node and its LINK field contains the adress of next node 
        Node save=null;//It stores the address of previous node and its LINK field contains the adress of current node //or temp
        Node nptr=new Node(item);//calling constructor to create a new node
        if(start==null)//if list is empty the new node i.e. nptr becomes the start
        {
            start=nptr;
        }
        else if(nptr.info<start.info)//insertion takes in the beginning
        {   //here list is not empty but it contains at least one node
            nptr.LINK=start;//The new node is LINKed with the rest of the LinkedList
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
    void delet(int itm)
    {
        int flag=0;
        Node ptr, temp;
        if(start==null)
            System.out.println("Linked list is empty");
        else
        {
            if(start.info==itm)
            {
                temp=start;
                start=start.LINK;
                temp.LINK=null;
                flag=1;
            }
            else
            {
                temp=start;
                ptr=start.LINK;
                while(ptr!=null)
                {
                    if(ptr.info==itm)
                    {
                        temp.LINK=ptr.LINK;
                        ptr.LINK=null;
                        flag=1;
                        break;
                    }
                    else
                    {
                        temp=ptr;
                        ptr=ptr.LINK;
                    }
                }
            }
            if(flag==0)
            {
                System.out.println("Item is not found");
            }
            else
            {
                System.out.println("Item is Deleted");
            }
        }
    }
    void search(int itm)
    {
        int flag=0,ctr=1;
        Node ptr;
        if(start==null)
            System.out.println("Linked list is empty");
        else
        {
            if(start.info==itm)
            {
                flag=1;
            }
            else
            {
                ptr=start.LINK;
                while(ptr!=null)
                {
                    ctr++;
                    if(ptr.info==itm)
                    {
                        flag=1;
                        break;
                    }
                    else
                    {
                        ptr=ptr.LINK;
                    }
                }
            }
            if(flag==0)
            {
                System.out.println("Item is not found");
            }
            else
            {
                System.out.println("Item is found on Location "+ctr);
            }
        }
    }
    
    void display()//to display the LINKed list
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
    public static void main(String s[])
    {
        Scanner sc=new Scanner(System.in);
        LinkedList l=new LinkedList();
        int item,choice;
        char ch;
        do
        {
            System.out.println("Menu\n1.Insert\n2.Delete\n3.Show\n4.Search");
            System.out.println("\nEnter your choice ");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter the item ");
                    item=sc.nextInt();
                    l.insert(item);
                    break;
                case 2:
                    System.out.println("Enter the item ");
                    item=sc.nextInt();
                    l.delet(item);
                    break;
                case 3:
                    l.display();
                    break;
                case 4:
                    System.out.println("Enter the item ");
                    item=sc.nextInt();
                    l.search(item);
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