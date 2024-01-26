public class Varargs
{
    public static void show(int ...arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static void main(String args[])
    {
        Varargs.show(2,5,0);
    }
}