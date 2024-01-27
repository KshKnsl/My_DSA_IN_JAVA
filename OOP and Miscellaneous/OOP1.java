public class OOP1 
{
    public static void main(String args[])
    {
        Student[] ob = new Student[100000000];
        
        for(int i=0;i<=3000000;i++)
        {
            ob[i]=new Student(i);
            //ob[i].print();
            //System.gc();
                    //System.out.println(" Destroying objects ");

        }
        for(int i=0;i<=3000000;i++)
        {
            ob[i]=new Student(i);
            //ob[i].print();
            //System.gc();
                    //System.out.println(" Destroying objects ");

        }
    }        
}
class Student
{
    int rno;
    String name;
    double percente;
    Student()
    {
        rno=0;
        name="";
        percente=0.0D;
        //System.out.println("In Student () " );
    }
    Student(int rno)
    {
        this();
        this.rno=rno;
        name="Kush";
        percente=90.0D;
        //System.out.println("In Student (int rno) " );

    }
    void print()
    {
        System.out.println("Rno = "+ rno);
        System.out.println("Name = "+name);
        System.out.println("Percent = "+ percente);
    }
    protected void finalize()throws Throwable
    {
        System.out.println(" Destroying objects 1");
    }
}
