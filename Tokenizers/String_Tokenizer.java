package Tokenizers;
/*import java.util.*;
class String_Tokenizer
{
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Sentence :");
        String str=sc.nextLine();
        StringTokenizer st=new StringTokenizer(str);
        int count=st.countTokens();
        for(int i=0;i<count;i++)
        {
            String a=st.nextToken();
            System.out.println(a);
        }
    }
}
*/
import java.io.*;
import java.util.StringTokenizer;
class String_Tokenizer
{
    public static void main()throws IOException,FileNotFoundException
    {
        FileReader fr=new FileReader("kk.txt");
        BufferedReader br=new BufferedReader(fr);
        String str;
        while((str=br.readLine())!=null)
        {
            StringTokenizer st=new StringTokenizer(str);
            int count=st.countTokens();
            for(int i=0;i<count;i++)
            {
                String a=st.nextToken();
                System.out.println(a);
            }
        }
        br.close();
    }
}