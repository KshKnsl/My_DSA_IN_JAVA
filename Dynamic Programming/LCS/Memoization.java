class Memoization 
{
    HashMap<String, Integer> map = new HashMap<>();
    public int longestCommonSubsequence(String text1, String text2) 
    {
        return lca(text1, text2, text1.length(), text2.length());
    }
    
    public int lca(String s1, String s2, int n1, int n2)
    {    
        // Step 4: Create a unique key for HashMap using variable inputs 'n1' & 'n2'
        String currentInputKey = Integer.toString(n1) + ":" + Integer.toString(n2);
        if(map.containsKey(currentInputKey))
            return map.get(currentInputKey);
        
        if(n1 == 0 || n2 == 0) return 0;
        
        // Step 7: Start from end of strings and check if char is equal
        if(s1.charAt(n1-1) == s2.charAt(n2-1))`
        {
            int result = 1 + lca(s1, s2, n1-1, n2-1);
            map.put(currentInputKey, result);    
            return result;
        }
        else if(s1.charAt(n1-1) != s2.charAt(n2-1))
        {    
            int result = Math.max(lca(s1, s2, n1-1, n2), lca(s1, s2, n1, n2-1));
            map.put(currentInputKey, result);
            return result;
        }
        else        return 0;
    }
}