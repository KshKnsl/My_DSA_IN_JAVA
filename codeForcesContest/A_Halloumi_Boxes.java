import java.util.*;
public class A_Halloumi_Boxes
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tt=0;tt<t;tt++)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int j=0;j<n;j++)
                arr[j] = sc.nextInt();
            boolean sorted= true;
            for(int i=1;i<arr.length;i++)

            {
                if(arr[i]<arr[i-1]) {
                    sorted = false;
                    break;
                }
            }
            if(k==1 && !sorted)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}