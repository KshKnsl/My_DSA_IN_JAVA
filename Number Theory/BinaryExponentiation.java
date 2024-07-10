public class BinaryExponentiation
{
    // Function to calculate a^b in O(log b) time complexity

    //remember
    // (a+b)%m = (a%m) + (b%m)
    // (a*b)%m = (a%m) * (b%m)
    // (a-b)%m = (a%m) - (b%m)
    // (a/b)%m = (a%m) * (b^-1%m) 
    //where b^-1 is the multiplicative modulo inverse of b under m

    static int MOD = 1000000007;
    public static void main(String[] args) {
        int a = 2, b = 10;
        System.out.println(power(a, b));
    }
    static int power(int a, int b)
    {
        int res = 1;
        while (b > 0)
        {
            if ((b % 2) == 1)  //----> odd i.e. b & 1 == 1 
                res = res * a;
            a = (a * a)%MOD;
            b = b / 2; // or b = b>>1;
        }
        return res;
    }
}
