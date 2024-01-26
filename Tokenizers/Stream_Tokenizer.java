package Tokenizers;
import java.io.*;
class Stream_Tokenizer
{
    public static void main()throws FileNotFoundException , IOException
    {
        FileReader fr = new FileReader("kk.txt");
        StreamTokenizer st=new StreamTokenizer(fr);
        int tt=0;double n;
        String str;
        do
        {
            tt=st.nextToken();
            System.out.println(tt);
            switch(tt)
            {
                case StreamTokenizer.TT_NUMBER:
                    n=st.nval;
                    System.out.println("NVAL :  "+n);
                    break;
                case StreamTokenizer.TT_WORD:
                    str=st.sval;
                    System.out.println("SVAL :  "+str);
                    break;
                
            }
        }while(tt!=-1);
    }
}
/*
import java.io.*;
class Stream_Tokenizer
{
    public static void main()throws FileNotFoundException
    {
        FileReader fr = new FileReader("kk.txt");
        System.out.println(StreamTokenizer.TT_EOF);//-1
        System.out.println(StreamTokenizer.TT_EOL);//10
        System.out.println(StreamTokenizer.TT_NUMBER);//-2
        System.out.println(StreamTokenizer.TT_WORD);//-3
        System.out.println();
    }
}
*/