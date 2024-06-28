public class KarpRabin 
{
    private final int PRIME = 101;
    // Function to calculate the hash value of a string
    private double calculateHash(String str) 
    {
        double hash = 0;
        for (int i = 0; i < str.length(); i++) 
            hash += str.charAt(i) * Math.pow(PRIME, i);
        //Mathematically, hash+= char*primeNo^index
        return hash;
    }

    private double updateHash(double hash, char oldChar, char newChar, int len) 
    {
        hash = (hash - oldChar) / PRIME;
        hash += hash + newChar * Math.pow(PRIME, len - 1);
        //Mathematically, newHash = (prevHash - oldChar)/primeNo(to the power 1) + newChar*primeNo^(len-1)
        return hash;
    }
    public void search(String text, String pattern) 
    {
        int len = pattern.length();
        double hash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0, len));//initial hash value of pattern

        for (int i = 0; i <= text.length() - len; i++) 
        {
            if (textHash == hash) //there is a possibility of collision
            {
                if (text.substring(i, i + len).equals(pattern)) 
                    System.out.println("Pattern found at index " + i);
            }

            if (i < text.length() - len)
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + len), len);
        }
    }
}