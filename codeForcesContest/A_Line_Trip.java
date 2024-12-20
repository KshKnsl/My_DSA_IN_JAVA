import java.util.*;

public class A_Line_Trip
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tt = 0; tt < t; tt++)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++)
            arr[j] = sc.nextInt();
            int max = arr[0];
            int i=0;
            for (;i < arr.length-1; i++)
            {
                if (arr[i+1] >=k) break;
                max = Math.max(max, arr[i+1]-arr[i]);    
            }
            max = Math.max(max, (k-arr[i])*2);
                System.out.println(max);
        }
    }
}