public class CatalanNumber 
{
    //Catalan numbers are numbers that occur in various counting problems, often involving recursive structures. 
    //The formula to calculate the nth Catalan number is given by:
    // observing the pattern we find that 
    // C(n) = C(0) * C(n-1) + C(1) * C(n-2) + C(2) * C(n-3) + ... + C(n-1) * C(0) = Σ[C(i)*C(n-i-1)] for i = 0 to n-1

    public static void main(String[] args) 
    {
        int n = 10;
        System.out.println(catalan(n));
    }
    public static long catalan(int n) 
    {
        long[] catalan = new long[n + 1];
        catalan[0] = 1;
        for (int i = 1; i <= n; i++) 
        {
            for (int j = 0; j < i; j++) 
                catalan[i] += catalan[j] * catalan[i - j - 1];
        }
        return catalan[n];
    }
}
