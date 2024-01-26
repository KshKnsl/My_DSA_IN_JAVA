package Exceptionhandling;
import java.io.*;
class exceptiondemo
{
    public static void main(String s[]) throws Exception
    {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter a number : ");
        Exception e=new Exception();
        try 
        {
            int n=Integer.parseInt(br.readLine());
            System.out.println("Number +"+n);
        }
        catch(Exception ae)
        {
          System.out.println(e);  
        }
    }
}