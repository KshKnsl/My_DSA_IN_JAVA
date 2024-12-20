import java.util.*;
public class A_Sliding
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tt = 0; tt < t; tt++)
        {
            long n = sc.nextInt();
            long m = sc.nextInt();
            long r = sc.nextInt();
            long c = sc.nextInt();
            
            long d;
            
            d = m-c + (n-r)*(m-1)+ (n-r)*m;
            System.out.println(d);
        }
    }
}