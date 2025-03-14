package Recursion;
import java.util.ArrayList;
// A famous Googe Question
//for a non-smart phone devive where 1 represents"abc" , 2 represents "def",... and so on.
public class PhonePad 
{
    public static void main(String[] args) 
    {
        System.out.println(padRet("", "12").size());
        System.out.println(padCount("", "12"));
    }
    //p for processed and up for unprocessed
    static void pad(String p, String up) 
    {
        if(up.isEmpty()) 
        {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2
        for(int i=(digit-1) * 3;i<digit*3;i++)
        {
            char ch = (char) ('a' + i);
            pad(p + ch, up.substring(1));
        }
    }

    static ArrayList<String> padRet(String p, String up) 
    {
        if(up.isEmpty()) 
        {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2
        ArrayList<String> list = new ArrayList<>();

        for(int i = (digit - 1) * 3; i < digit * 3; i++) 
        {
            char ch = (char) ('a' + i);
            list.addAll(padRet(p + ch, up.substring(1)));
        }
        return list;
    }

    static int padCount(String p, String up) 
    {
        if(up.isEmpty())          return 1;
        int count = 0;
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2
        for(int i = (digit - 1) * 3; i < digit * 3; i++) 
        {
            char ch = (char) ('a' + i);
            count = count + padCount(p + ch, up.substring(1));
        }
        return count;
    }
}
