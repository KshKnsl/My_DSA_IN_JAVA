import java.util.*;
public class ArrayInsertion
{
    int arr[],item,loc,N,k;
    //arr is for array
    //k is the index where arr[k-1] will be shifted
    //item is the number to be inserted
    //loc is the location where item is to be inserted
    //N is the size of array //here .length can not be used as array is declared of larger size to support expansion
    Scanner sc;
    ArrayInsertion()//constructor
    {
        sc= new Scanner(System.in);
        N=0;//current size is zero as array is empty
        arr=new int[5];//array of larger size
        item=0;loc=0;
        k=0;
    }
    void insert()
    {
        if(N==5)//No more size for array (insertion)expansion
        {
            System.out.println("OVERFLOW");
            System.exit(0);
        }
        System.out.println("Enter the location and item");
        loc=sc.nextInt();
        loc=loc-1;//for users convinience
        item=sc.nextInt();
        if(loc>N)//loc is more than array limit
        {
            System.out.println("Index is not avaliable");
            System.exit(0);
        }
        for(k=N;k>loc;k--)//to start shifting from back till we reach location loc
        {
            arr[k]=arr[k-1];
        }
        arr[loc]=item;//inserting item
        N=N+1;//increasing array size
        System.out.println("Item has been inserted");
    }
    void display()
    {
        if(N<=0)//no element has been inserted
        {
            System.out.println("No element in the list");
            System.exit(0);
        }
        System.out.print("The Array is :");
        for(int i=0;i<N;i++)
        {
            System.out.print(arr[i]+" , ");
        }
    }
    public static void main()
    {
        char ch;
        ArrayInsertion ai = new ArrayInsertion();
        do
        {
            ai.insert();
            ai.display();
            System.out.println("DO YOU WANT MORE?");
            ch=ai.sc.next().charAt(0);
        }while(ch=='y'||ch=='Y'); //to repeat insertion
    }
}