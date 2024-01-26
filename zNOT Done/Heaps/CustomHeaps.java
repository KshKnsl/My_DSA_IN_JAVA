import java.util.Scanner;
import java.util.ArrayList;
class CustomHeaps <T extends Comparable<T>>
{
    private ArrayList<T> list;
    public CustomHeaps()
    {
        list = new ArrayList<>();
    }

    private void swap(int f,int s)
    {
        T temp= list.get(f);
        list.set(f,list.get(s));
        list.set(s,temp);
    }

    private int parent(int index)    
    {
        return (index-1)/2;
    }
    private int left(int index)
    {
        return 2*index+1;
    }
    private int right(int index)
    {
        return 2*index+2;
    }
    
    public void insert(T value)
    {
        list.add(value);
        upheap(list.size()-1);
    }
    private void upheap(int index) 
    {
        if(index==0)    return;
        int parent=parent(index);
        if(list.get(index).compareTo(list.get(parent))<0)
        {
            swap(index,parent);
            upheap(parent);
        }
    }

    public T remove() throws Exception
    {
        if(list.isEmpty())  throw new Exception("List is Empty");
        T temp= list.get(0);
        T last = list.remove(list.size()-1);
        //setting last element of the list to the first index
        if(!list.isEmpty())
        {
            list.set(0,last);
            downheap(0);
        }
        return temp;
    }
    private void downheap(int index) 
    {
        int min=index;
        int left=left(index);
        int right=right(index);
        if(left< list.size() && list.get(min).compareTo(list.get(left))>0)
        {
            min=left;
        }
        if(right< list.size() && list.get(min).compareTo(list.get(right))>0)
        {
            min=right;
        }
        if(index!=min)
        {
            swap(min,index);
            downheap(min);
        }
    }

 public static void main(String[] args) throws Exception
    {
        CustomHeaps<Integer> ob = new CustomHeaps<>();
        Scanner sc = new Scanner(System.in);
        ob.insert(5);
        ob.insert(3);
        ob.insert(1);
        ob.insert(2);
        ob.insert(4);
        ob.list = ob.heapsort();
        System.out.println(ob.list);
        sc.close();

    }

    public ArrayList<T> heapsort() throws Exception{
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty())
        {
            data.add(remove());
        }
        return data;
    }
}