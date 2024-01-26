package Tokenizers;

import java.util.Arrays;
import java.text.DecimalFormat;

class StringBufferDemo 
{
    public static void main(String[] args) 
    {
      // constructor 1
      StringBuffer sb = new StringBuffer();
      System.out.println(sb.capacity());

      // constructor 2
      StringBuffer sb2 = new StringBuffer("Kunal Kushwaha");
      System.out.println(sb2.toString());
   
      // constructor 3
      StringBuffer sb3 = new StringBuffer(30);
      System.out.println(sb3.capacity());
      sb.append("WeMakeDevs");
      sb.append(" is nice!");
      sb.insert(2, " Rahul ");
      sb.replace(1, 5, "Kushwaha");
      sb.delete(1, 5);
      sb.reverse();
      String str = sb.toString();
      System.out.println(str);

      // remove whitespaces

      String sentence = "Hi h   hjh  hjkso  siowi     w ";
      System.out.println(sentence);
      // split
      String arr = "Kunal,Apoorv,Rahul,Snehal";
      String[] names = arr.split(",");
      System.out.println(Arrays.toString(names));

      // rounding off
      DecimalFormat df = new DecimalFormat("00.0000");
      System.out.println(df.format(7.29));
   }
}