package FileHandling;

import java.io.*;
import java.util.*;
class FilePrograms{}
class filemanagemeent
{
    public static void main()throws IOException
    {
        FileWriter fr = new FileWriter("names.txt",true);
        BufferedWriter bw=new BufferedWriter(fr);
        PrintWriter pw = new PrintWriter(bw);
        FileWriter fr2 = new FileWriter("names2.txt",true);
        BufferedWriter bw2=new BufferedWriter(fr2);
        PrintWriter pw2 = new PrintWriter(bw2);
        String name,c="";
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        pw2.println(bw);
        pw2.println(bw2);
        do
        {
            System.out.print("Enter name :");
            name=br.readLine();
            pw.println(name);
            pw2.print(bw);
            System.out.print("Do you want more?  ");
            c=br.readLine();
        }while(c.equalsIgnoreCase("YES"));
        pw.println("hello");
        pw.close();
        bw.close();
        fr.close();
        pw2.close();
        bw2.close();
        fr2.close();
    }
}
class Binary
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        FileOutputStream fos = new FileOutputStream("names.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        for(int i=1;i<=5;i++)
        {
            System.out.println("Enter marks : ");
            int n= sc.nextInt();
            dos.writeInt(n);
            System.out.println("Enter float : ");
            float f= sc.nextFloat();
            dos.writeFloat(f);
        }
        dos.close();
        fos.close();
        FileInputStream fis = new FileInputStream("names.txt");
        DataInputStream dis = new DataInputStream(fis);
        while(dis!=null)
        {
            try
            {
                System.out.println(dis.readInt());
                System.out.println(dis.readFloat());
            }
            catch(EOFException e)
            {
            }
        }
        sc.close();
        fis.close();
    }
}
class filemanageme{
    public static void main()throws IOException
    {
        FileWriter fw = new FileWriter("names.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        String n ;
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        for(int i=1;i<=5;i++)
        {   System.out.print("Enter a word :");
            n=br.readLine();
            pw.println(n);
        }
        bw.close();
        System.out.println("Printing file");
        FileReader fr  = new FileReader("names.txt");
        BufferedReader br2 = new BufferedReader(fr);
        while(br2!=null)
            System.out.println(br2.readLine());
        fr.close();
        pw.close();fw.close();
    }
}    

class FileProg2
{
    public static void main(String s[]) throws Exception
    {
        String str;
        FileReader fr=new FileReader("File2.txt");
        BufferedReader br = new BufferedReader(fr);
        while(br.readLine()!=null)
        {
            str=br.readLine();
            System.out.println(str);
        }
        fr.close();
        br.close();        
    }
}

class FileProg3
{
    public static void main(String s[]) throws Exception
    {
        String str;
        FileReader fr=new FileReader("File2.txt");
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        while(br.readLine()!=null)
        {
            str=br.readLine();
            System.out.println(str);
        }
        fr.close();
        br.close();        
    }
}

class kk
{
    public static void main(String args[]) throws IOException
    {
        FileReader fr = new FileReader("kk.txt");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("kk2.txt");
        PrintWriter pw= new PrintWriter(fw);
        int c;
        for(int i=1;i<=5;i++)
        {
            c=br.read();
            pw.println(c);
        }
        fr.close();
        fw.close();
    }
}

class k
{
    public static void main(String args[]) throws IOException
    {
        FileReader fr = new FileReader("kk.txt");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("kk2.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw= new PrintWriter(bw);
        int c;String str;
        while((str=br.readLine())!=null)
        {
            c=Integer.parseInt(str);
            pw.println(c);
        }
        fr.close();
        fw.close();
    }
}

class filemanagement2
{
    public static void main()throws IOException
    {
        FileWriter fw = new FileWriter("names.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        String n;
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        for(int i=1;i<=5;i++)
        {   
            System.out.print("Enter a word :");
            n=br.readLine();
            pw.println(n);
        }
        bw.close();
        System.out.println("Printing file");
        FileReader fr  = new FileReader("names.txt");
        BufferedReader br2 = new BufferedReader(fr);
        for(int j=1;j<=5;j++)
            System.out.println(br2.readLine());
        fr.close();br2.close();
        pw.close();fw.close();
    }
}  

class READNAMES
{
    public static void main() throws IOException
    {
        FileReader fr=new FileReader("names.txt");
        BufferedReader br = new BufferedReader(fr);
        String st="";
        FileWriter fw = new FileWriter("Mod.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        while((st=br.readLine())!=null)
        {
            if(st.startsWith("a")&&st.endsWith("a"))
                pw.println(st);
        }        
        pw.close();
        fr.close();
    }
}

class testReaderType
{
    public static void main()throws Exception
    {
        int a=5;
        short b=5;
        byte c=5;
        long d=5L;
        FileWriter fw = new FileWriter("FILE.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        pw.println(a);
        pw.println(b);
        pw.println(c);
        pw.println(d);
        pw.close();
        bw.close();
        fw.close();
        fw.close();
        bw.close();
        pw.close();
        FileReader fr = new FileReader("FILE.txt");
        BufferedReader  br=new BufferedReader(fr);
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        br.close();
    }
}

class testReaderDta
{
    public static void main()throws Exception
    {
        short b=565;
        double c=5.024;
        long d=5L;
        FileOutputStream fos = new FileOutputStream("FILE1.dat");
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeChars("He is a good man");
        dos.writeShort(b);
        dos.writeDouble(c);
        dos.writeLong(d);
        dos.close();
        fos.close();
        FileInputStream fis = new FileInputStream("FILE1.txt");
        DataInputStream dis = new DataInputStream(fis);
        System.out.println(dis.readInt());
        System.out.println(dis.readShort());
        System.out.println(dis.readInt());
        System.out.println(dis.readInt());
        System.out.println(dis.readInt());
        dis.close();
    }
}

 