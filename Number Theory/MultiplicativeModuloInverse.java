// (A x B) % M = 1 you will be given A and M you have to find B
// here B is called as Multiplicative Modulo Inverse of A under M and is the x of Extended Euclidean Algorithm 
class MultiplicativeModuloInverse
{
    public static void main(String[] args)
    {
        int a = 3, m = 11;
        for (int B = 1; B < m; B++)
            if (((a % m) * (B % m)) % m == 1)
            {
                System.out.println("Modulo Inverse:"+B);
                break;
            }
    }
}