import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class input {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	static public void main(String[] args)
	{

        long starttime = System.currentTimeMillis();
		FastReader fr = new FastReader();
		int t= fr.nextInt();
        
		while(t-->0){
		    int a= fr.nextInt();
			int b= fr.nextInt();
			char[][]arr = new char[a][b];
			Scanner scn = new Scanner(System.in);
		for(int i = 0;i<arr.length;i++){
			for(int j = 0;j<arr.length;i++){
				arr[i][j] = fr.next();
			}
		}
			
			
			


			}
		  
		}
	// long endtime = System.currentTimeMillis();
	// System.out.println(endtime-starttime);
}