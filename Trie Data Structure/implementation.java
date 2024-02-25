//retrieval digital data structure
//stores common information only once
//stored in form of a tree. head node will have 26 child nodes for a to z . and every child node has its own 26[] nodes of children . also every node has a boolean variable to mark the end of the words.
public class implementation 
{
    static class Node
    {
        Node[] child;
        boolean endOfWord;
        public Node()
        {
            child = new Node[26];
            for(int i=0;i<26;i++)
            {
                child[i]=null;
            }
            endOfWord=false;
        }
    }
    public static Node root = new Node();

    static void insert(String word)
    {
        Node curr= root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(curr.child[ch-'a']==null)//not existing so add
            {
                curr.child[ch-'a']=new Node();
            }
            if(i==word.length()-1)
            {
                curr.child[ch-'a'].endOfWord=true;
            }
            curr = curr.child[ch-'a'];
        }
        //insertion done
    }
    
    static boolean search(String word)
    {
        Node curr= root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(curr.child[ch-'a']==null)//not existing so false
            return false;
            if(i==word.length()-1 && curr.child[ch-'a'].endOfWord==false)
            {
                return false;
            }
            curr = curr.child[ch-'a'];
        }
        return true;
    }
    public static void main(String[] args) 
    {
        String words[]={"the","a","an","any","there","their"};
        //now traverse for every character of every word and store it in the tree
        for(int i=0;i < words.length;i++)
        {
            insert(words[i].toLowerCase());
        }
        System.out.println(search("any"));
    }
}
