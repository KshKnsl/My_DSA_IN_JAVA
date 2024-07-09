// The KMP algorithm preprocesses the pattern and constructs an auxiliary lps array.
// The lps array stores the length of the longest proper prefix which is also a suffix.
// We search for lps in subpatterns, focusing on substrings that are both prefix and suffix.
// For each sub-pattern pat[0..i], lps[i] stores the length of the maximum matching proper prefix which is also a suffix.

// In the preprocessing part:
// - We calculate values in the lps array.
// - We keep track of the length of the longest prefix suffix value for the previous index.
// - We initialize lps[0] and the length variable.
// - If pat[len] and pat[i] match, we increment len by 1 and assign the incremented value to lps[i].
// - If pat[i] and pat[len] do not match and len is not 0, we update len to lps[len-1].

// See computeLPSArray() for implementation details.


// JAVA program for implementation of KMP pattern
// searching algorithm

class Knuth_Moris_Patt
{
	void KMPSearch(String pat, String txt)
	{
		int M = pat.length();
		int N = txt.length();
		int lps[] = new int[M];
		int j = 0; // index for pat[]

		// 50+Preprocess the pattern (calculate lps[])
		computeLPSArray(pat, M, lps);
		int i = 0; // index for txt[]
		while ((N - i) >= (M - j)) 
        {
			if (pat.charAt(j) == txt.charAt(i)) 
            {
				j++;    i++;
			}
			if (j == M) 
            {
				System.out.println("Found pattern "	+ "at index " + (i - j));
				j = lps[j - 1];
			}
			// mismatch after j matches
			else if (i < N	&& pat.charAt(j) != txt.charAt(i)) 
            {
				// Do not match lps[0..lps[j-1]] characters,a they will match anyway
				if (j != 0)		j = lps[j - 1];
				else    		i = i + 1;
			}
		}
	}
	void computeLPSArray(String pat, int M, int lps[])
	{
		// length of the previous longest prefix suffix
		int len = 0, i = 1;
		lps[0] = 0;

		while (i < M) 
        {
			if (pat.charAt(i) == pat.charAt(len)) lps[i++] = ++len;
			else // (pat[i] != pat[len])
			{
				// This is tricky. Consider the example. AAACAAAA and i = 7. The idea is similar to search step.
				if (len != 0) 		len = lps[len - 1];
				else // if (len == 0)
				{
					lps[i] = len;
					i++;
				}
			}
		}
	}
	public static void main(String args[])
	{
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		new Knuth_Moris_Patt().KMPSearch(pat, txt);
	}
}