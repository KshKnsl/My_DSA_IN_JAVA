class Recursive 
{
    // Recursive Approach
    private int solveRec(String st1, String st2, int i, int j)
    {
        if(st1.length()==i)            return 0;
        if(st2.length()==j)            return 0;
        int ans = 0;
        if(st1.charAt(i) == st2.charAt(j))
            return 1 + solveRec(st1, st2, i+1, j+1);
        else
            ans = Math.max(solveRec(st1, st2, i, j+1), solveRec(st1, st2, i+1, j));
        return ans;
    }
    public int longestCommonSubsequence(String st1, String st2) 
    {
        return solveRec(st1, st2, 0, 0);
    }
}