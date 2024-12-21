import java.util.*;

public class B_pspspsps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = " " + sc.next();
            System.out.println(isPossible(n, s) ? "YES" : "NO");
        }
    }

    private static boolean isPossible(int n, String s) {
        int[] nextP = calculateNextP(n, s);
        int[] lastS = calculateLastS(n, s);
        int[] x = calculatex(n, nextP, lastS);

        Arrays.sort(x);
        for (int i = 1; i <= n; i++)
            if (x[i - 1] < i)
                return false;
        return true;
    }

    private static int[] calculateNextP(int n, String s) {
        int[] nextP = new int[n + 2];
        Arrays.fill(nextP, n + 1);
        for (int j = n; j >= 1; j--)
            nextP[j] = (s.charAt(j) == 'p') ? j : nextP[j + 1];
        return nextP;
    }

    private static int[] calculateLastS(int n, String s) {
        int[] lastS = new int[n + 1];
        for (int j = 1; j <= n; j++)
            lastS[j] = (s.charAt(j) == 's') ? j : lastS[j - 1];
        return lastS;
    }

    private static int[] calculatex(int n, int[] nextP, int[] lastS) {
        int[] x = new int[n];
        for (int j = 1; j <= n; j++) {
            int uP = (nextP[j] <= n) ? nextP[j] : Integer.MAX_VALUE;
            int uS = (lastS[j] >= 1) ? n - lastS[j] + 1 : Integer.MAX_VALUE;
            x[j - 1] = (uP != Integer.MAX_VALUE && uS != Integer.MAX_VALUE) ? Math.min(uP, uS) : (uP != Integer.MAX_VALUE ? uP : (uS != Integer.MAX_VALUE ? uS : n));
        }
        return x;
    }
}
