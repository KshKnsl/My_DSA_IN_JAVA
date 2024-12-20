import java.util.*;

public class B_Everyone_Loves_Tres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(helper(n));
        }
    }

    public static String helper(int n) {
        if (n == 1) return "-1";
        if (n == 2) return "66";
        if (n == 3) return "-1";
        if (n == 4) return "3366";
        StringBuilder sb = new StringBuilder();
        if(n%2==0){
        for(int i = 0; i < n-2; i++) {
            sb.append("3");
        }
        sb.append("66");}
        else{
            for(int i = 0; i < n-4; i++) {
                sb.append("3");
            }
            sb.append("6366");    
        }
        return sb.toString();
    }
}
