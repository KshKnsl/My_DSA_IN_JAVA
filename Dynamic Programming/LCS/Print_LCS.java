class Print_LCS
{
    String LCS(String X, String Y, int n, int m) 
    {
        int dp[][]= new int[n + 1][m + 1]; // DP - matrix
        // base case of recursion --> for initialization of dp - matrix
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                if (i == 0 || j == 0)
                    dp[i][j] = 0;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (X.charAt(i - 1) == Y.charAt(j - 1)) // when last character is same
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else // when last character is not same -> pick max
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        //The LCS DP matrix is ready
        
        int i = n, j = m;
        String lcs = ""; // store charecter when it is equal in the table 
        while (i > 0 && j > 0) 
        {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) 
            {
                lcs += X.charAt(i-1); // insert in String 
                i--; j--;
            }
            else 
            {
                if (dp[i][j - 1] > dp[i - 1][j])
                        j--; // move to the larger side 
                else    i--;
            }
        }
        StringBuilder sb = new StringBuilder(lcs);
        sb.reverse();
        return sb.toString();
    }
}