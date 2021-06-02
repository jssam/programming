import java.util.*;

public class beautygraph {
    public static int beauty(int n, int m, String s, int x[], int y[]) {
        ArrayList<Integer>[] out = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            out[i] = new ArrayList<Integer>();
        }

        int deg[] = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = x[i];
            int b = y[i];
            deg[b]++;
            out[a].add(b);
        }
        Queue<Integer> q = new ArrayDeque<>();
        int f[][] = new int[n + 1][26];

        for (int i = 1; i <= n; i++) {
            if (deg[i] == 0) {
                q.offer(i);
                f[i][s.charAt(i - 1) - 'a']++;
            }
        }

        int count = 0;
        while (count < n && q.size() > 0) {
            int v = q.poll();

            for (int i : out[v]) {

                for (int j = 0; j < 26; j++) {
                    if (j == s.charAt(i - 1) - 'a')
                        f[i][j] = Math.max(f[v][j] + 1, f[i][j]);
                    else
                        f[i][j] = Math.max(f[v][j], f[i][j]);
                }

                if (--deg[i] == 0) {
                    q.offer(i);
                }
            }

            count++;
        }

        if (count < n) {
            return -1;
        } else {
            int ans = 0;
            for (int arr[] : f) {
                for (int i : arr) {
                    ans = Math.max(i, ans);
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String s = sc.next();
            int x[] = new int[m];
            int y[] = new int[m];
            for (int i = 0; i < m; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }
            // beauty sol = new beauty();
            int ans = beauty(n, m, s, x, y);
            System.out.println(ans);
        }
    }
}
