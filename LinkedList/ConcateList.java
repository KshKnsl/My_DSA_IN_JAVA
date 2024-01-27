package LinkedList;
import java.util.*;
public class ConcateList//This class will be LINKing the nodes and also perform the required operations
{
    Node start;//this implies that the list is empty or new list is statrting
    ConcateList()
    {
        start=null;
    }
    void insert(int item)//to insert a node
    {
        Node ptr=null;//pointer which will move from start till end==It stores the adress of current node and its LINK field contains the adress of LINK node 
        Node save=null;//It stores the address of previous node and its LINK field contains the adress of current node //or temp
        Node nptr=new Node(item);//calling constructor to create a new node
        if(start==null)//if list is empty the new node i.e. nptr becomes the start
        {
            start=nptr;
        }
        else if(nptr.info<start.info)//insertion takes in the beginning
        {   //here list is not empty but it contains at least one node
            nptr.LINK=start;//The new node is LINKed with the rest of the ConcateList
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
    void concate(ConcateList L2)
    {
        Node ptr=start;
        Node save=start;
        while(ptr!=null)
        {
            save=ptr;//save moves forward
            ptr=ptr.LINK;//ptr mov/es forward
        }
        save.LINK=L2.start;
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
    public static void main(String s[])
    {
        Scanner sc=new Scanner(System.in);
        ConcateList L1=new ConcateList();
        ConcateList L2=new ConcateList();
        int item;
        char ch;
        System.out.println("FOR LIST 1");
        do
        {
            System.out.println("Enter the item ");
            item=sc.nextInt();
            L1.insert(item);
            System.out.print("Do you want more ?");
            ch=sc.next().charAt(0);
        }while(ch=='y');
        System.out.println("FOR LIST 2");
        do
        {
            System.out.println("Enter the item ");
            item=sc.nextInt();
            L2.insert(item);
            System.out.print("Do you want more ?");
            ch=sc.next().charAt(0);
        }while(ch=='y');
        L1.concate(L2);
        L1.show();sc.close();
    }
}   