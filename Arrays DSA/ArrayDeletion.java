import java.util.*;
public class ArrayDeletion
{
    int loc,N,k,item;
    int arr[]= {11,22,33,44,55};        
    //arr is for array
    //k is the index where arr[k+1] will be shifted
    //item is the number which was deleted
    //loc is the location where item is to be deleted
    //N is the size of array after contraction //here .length can not be used as array is declared of larger size
    Scanner sc;
    ArrayDeletion()//constructor
    {
        sc= new Scanner(System.in);
        N=5;//current size is zero as array is empty
        item=0;loc=0;
        k=0;
    }
    void delete()
    {
        if(N<=0)//No more size for array (insertion)expansion
        {
            System.out.println("UNDERFLOW");
            System.exit(0);
        }
        System.out.print("Enter the location : ");
        loc=sc.nextInt();
        loc=loc-1;//for users convinience
        if(loc>N)//loc is more than array limit
        {
            System.out.println("Index is not avaliable");
            System.exit(0);
        }
        item=arr[loc];//storing deleted item
        for(k=loc;k<N-1;k++)//to start shifting from back till we reach location loc
        {
            arr[k]=arr[k+1];
        }
        N=N-1;//increasing array size
        System.out.println("Item "+item +" has been deleted");
    }
    void display()
    {
        if(N<=0)//no element exists in array
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
        ArrayDeletion ad = new ArrayDeletion();
        do
        {
            ad.delete();
            ad.display();
            System.out.println("DO YOU WANT MORE?");
            ch=ad.sc.next().charAt(0);
        }while(ch=='y'||ch=='Y'); //to repeat deletion
    }
}