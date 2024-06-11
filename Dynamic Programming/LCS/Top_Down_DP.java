import java.util.Arrays;

class Top_Down_DP 
{
    int solveMemo(String st1, String st2, int i, int j, int[][] dp)
    {
        if(st1.length()==i)            return 0;
        if(st2.length()==j)            return 0;
        // Step-3 => Checking if answer is already Presnt in my dp[i][j] then JUST RETURN IT..
        if(dp[i][j] != -1)             return dp[i][j];

        // Step-2 => Recursive Calls and add the answer to the dp[i][j] 
        int ans = 0;
        if(st1.charAt(i) == st2.charAt(j))
            return 1 + solveMemo(st1, st2, i+1, j+1, dp);
        else
            ans = Math.max(solveMemo(st1, st2, i, j+1, dp), solveMemo(st1, st2, i+1, j, dp));
        return dp[i][j] = ans;
    }
    public int longestCommonSubsequence(String st1, String st2) 
    {
        //Step-1 => dp Creation and initilization....
        int [][]dp = new int[st1.length()][st2.length()];
        for(int i[] : dp)
        {
            Arrays.fill(i, -1);
        }
        return solveMemo(st1, st2, 0, 0, dp);
    }
}