class Finite_AutoMata 
{	
	static int NO_OF_CHARS = 256;
	static int getNextState(char[] pattern, int M, int state, int x)
	{
		// If the character c is same as next character in patterntern,then simply increment state
		if(state < M && x == pattern[state])
			return state + 1;
		// ns stores the result which is next state
		int ns, i;

		// ns finally contains the longest prefix, which is also suffix in "pattern[0..state-1]c"
		// Start from the largest possible value and stop when you find a prefix which is also suffix
		for (ns = state; ns > 0; ns--)
		{
			if (pattern[ns-1] == x)
			{
				for (i = 0; i < ns-1; i++)
					if (pattern[i] != pattern[state-ns+1+i])	break;
					if (i == ns-1)						return ns;
			}
		}
		return 0;
	}

	/* This function builds the TF table which represents Finite Automata for a given patterntern */
	static void computeTF(char[] pattern, int M, int TF[][])
	{
		int state, x;
		for (state = 0; state <= M; ++state)
			for (x = 0; x < NO_OF_CHARS; ++x)
				TF[state][x] = getNextState(pattern, M, state, x);
	}

	/* Prints all occurrences of pattern in txt */
	static void search(char[] pattern, char[] txt)
	{
		int M = pattern.length;
		int N = txt.length;
		int[][] TF = new int[M+1][NO_OF_CHARS];

		computeTF(pattern, M, TF);

		int i, state = 0;
		for (i = 0; i < N; i++)
		{
			state = TF[state][txt[i]];
			if (state == M)
				System.out.println("patterntern found "	+ "at index " + (i-M+1));
		}
	}
	public static void main(String[] args) 
	{
		char[] pattern = "AABAACAADAABAAABAA".toCharArray();
		char[] txt = "AABA".toCharArray();
		search(txt,pattern);
	}
}