import java.util.*;

public class C_MEX_Cycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
            List<List<Integer>> adj = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
            for (int i = 1; i <= n; i++) {
                adj.get(i).add(i == 1 ? n : i - 1);
                adj.get(i).add(i == n ? 1 : i + 1);
            }
            adj.get(x).add(y);
            adj.get(y).add(x);

            int[] a = new int[n + 1];
            Arrays.fill(a, -1);
            a[x] = 0; a[y] = 1;
            Queue<Integer> q = new LinkedList<>();
            q.add(x); q.add(y);

            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : adj.get(u)) {
                    if (a[v] == -1) {
                        Set<Integer> s = new HashSet<>();
                        for (int nei : adj.get(v)) if (a[nei] != -1) s.add(a[nei]);
                        int mex = 0;
                        while (s.contains(mex)) mex++;
                        a[v] = mex;
                        q.add(v);
                    }
                }
            }

            for (int i = 1; i <= n; i++) if (a[i] == -1) a[i] = 0;
            for (int i = 1; i <= n; i++) System.out.print(a[i] + (i < n ? " " : "\n"));
        }
    }
}
