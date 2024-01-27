import java.util.*;
public class Calender
{
    public static void main()
    {
        int d,h,m;
        int day,month,year,hh,mm;//present parameters
        Scanner sc = new Scanner(System.in);
        Calendar c = Calendar.getInstance();
        System.out.println("Enter the values:");
        System.out.println("No. of days :");    d=sc.nextInt();
        System.out.println("No. of hours :");   h=sc.nextInt();
        System.out.println("No. of minutes :"); m=sc.nextInt();
        day=c.get(Calendar.DAY_OF_MONTH);
        month=c.get(Calendar.MONTH)+1;
        year=c.get(Calendar.YEAR);
        hh=c.get(Calendar.HOUR);
        mm=c.get(Calendar.MINUTE);
        System.out.println(hh);
        int arr[]={31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=1;i<=d;i++)
        {  
            day=day+1;
            if(day==arr[month-1])
            {
                day=1;
                month=month+1;
            }            
        }
        for(int i=1;i<=h;i++)
        {
            if(hh==24)
            {
                hh=0;
                day=day+1;
                if(day==arr[month])
                {
                    day=1;
                    month=month+1;
                }
            }
            hh=hh+1;
        }
        for(int i=1;i<=m;i++)
        { 
            mm++;
            if(mm==60)
            {
                hh++;
                if(hh==24)
                {
                    hh=0;
                    day=day+1;
                    if(day==arr[month])
                    {
                        day=1;
                        month=month+1;
                    }
                }
            }           
        }
        System.out.println(day+"-"+month+"-"+year+";"+hh+":"+mm);
        sc.close();
    }
}
