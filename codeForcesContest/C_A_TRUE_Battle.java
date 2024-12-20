import java.io.*;
import java.util.*;

public class C_A_TRUE_Battle
{
    static class Scan
    {
        BufferedReader br;
        StringTokenizer st;

        public Scan()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
                try
                {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e)
                {
                }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    static int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b)
    {
        return (a / gcd((int) a, (int) b)) * b;
    }

    static int binarySearch(int[] arr, int key)
    {
        int left = 0, right = arr.length - 1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    static int[] nextArray(Scan sc, int n)
    {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        return arr;
    }

    // template ends here
    public static String generateBinaryString(int n)
    {
        if (n == 1)
            return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++)
            sb.append('0');
        sb.append('1');
        return sb.toString();
    }

    static boolean win(String s)
    {
        boolean win = false;

        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)=='1' && s.charAt(i+1)=='1')
            {
                win = true;
                break;
            }
            if(s.charAt(0)=='1' || s.charAt(s.length()-1)=='1')
            {
                win = true;
                break;
            }
        }
        return win;
    }

    public static void main(String[] args)
    {
        Scan sc = new Scan();
        int t = sc.nextInt();

        for (int testCase = 0; testCase < t; testCase++)
        {
            int n = sc.nextInt();
            String st = sc.next();
            if (win(st))
                out.println("YES");
            else
                out.println("NO");
        }
        out.flush();
    }
}