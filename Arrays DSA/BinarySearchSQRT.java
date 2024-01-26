//for finding the square root of a number using binary search
public class BinarySearchSQRT 
{
    public static void main(String[] args) 
    {
        int num = 40,power = 3;
        System.out.printf("%.3f", sqrt(num, power));
    }
    // Time: O(log(n))
    static double sqrt(int n, int p) 
    {
        int s = 0, e = n;
        double root = 0.0;
        while (s <= e) 
        {
            int m = s + (e - s) / 2;

            if(m * m == n)            return m;
            if(m * m > n)             e = m - 1;
            else 
            {
                s = m + 1;
                root = m;
            }
        }
        double incr = 0.1;
        for (int i = 0; i < p; i++) 
        {
            while (root * root <= n) 
            {
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }
        return root;
    }
}