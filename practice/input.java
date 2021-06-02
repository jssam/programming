import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class input {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(
				new InputStreamReader(System.in));
		}

		String next()
		{
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() { return Integer.parseInt(next()); }

		long nextLong() { return Long.parseLong(next()); }

		double nextDouble()
		{
			return Double.parseDouble(next());
		}

		String nextLine()
		{
			String str = "";
			try {
				str = br.readLine();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args)
	{
        long starttime = System.currentTimeMillis();
		FastReader fr = new FastReader();
		int t= fr.nextInt();
        String hello = fr.nextLine();
        System.out.println(hello);
		while(t-->0){
		    int n= fr.nextInt();
		    int a[] = new int[n];
		    int max = 10001;
		    for(int i=0;i<n;i++){
		        a[i] = fr.nextInt();
		        max= Math.min(max,a[i]);
		    }
		    int moves=0;
		    for(int i=0;i<n;i++){
		        moves+=a[i]-max;
		    }
		    System.out.println(moves);
		}
        long endtime = System.currentTimeMillis();
        System.out.println(endtime-starttime);
	}
}