public class nCrLucasTheorm
{
    // Returns nCr % p. In this Lucas Theorem based program, this function is only called for n < p and r < p.
    static int nCrModpDP(int n, int r, int p)
    {
        // To store last row of pascal triangle. And last entry of last row is nCr
        int[] C = new int[r + 1];       C[0] = 1;

        // One by constructs remaining rows of Pascal Triangle from top to bottom
        for (int i = 1; i <= n; i++)
        {
            // Fill entries of current row using previous row values
            for (int j = Math.min(i, r); j > 0; j--)
                C[j] = (C[j] + C[j - 1]) % p;
        }
        return C[r];
    }
    // Lucas Theorem based function that returns nCr % p
    // This function works like decimal to binary conversion recursive function. First we compute last digits of
    // n and r in base p, then recur for remaining digits
    static int nCrModpLucas(int n, int r, int p)
    {
        if (r == 0)     return 1;
        // Compute last digits of n and r in base p
        int ni = n % p;
        int ri = r % p;
        // Compute result for last digits computed above, and
        // for remaining digits. Multiply the two results and
        // compute the result of multiplication in modulo p.
        return (nCrModpLucas(n / p, r / p, p) * nCrModpDP(ni, ri, p)) % p;
    }
    public static void main(String[] args)
    {
        int n = 1000, r = 900, p = 13;
        System.out.println("Value of nCr % p is " + nCrModpLucas(n, r, p));
    }
}