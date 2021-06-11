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
	public static int gcd(int a,int b){
		if(b==0){return a;}else{
			return gcd(b,a%b);
		}
	}
	 static public void main(String[] args)
	{
        // long starttime = System.currentTimeMillis();
		FastReader fr = new FastReader();
		int t= fr.nextInt();
        
		while(t-->0){
		    int a= fr.nextInt();
			int arr[] = new int[a];
		
			int min = fr.nextInt();

			int max = fr.nextInt();

			for(int i = 0;i<a;i++){
				arr[i] = fr.nextInt();
			}
			Arrays.sort(arr);
			int i = 0;
			int j = arr.length-1;
			int s = 0;
			while(i<j){
				if(arr[i]+arr[j]<min){
					i++;
				}else if(arr[i]+arr[j]>max){
					j--;
				}
			}
			
				System.out.println(s);

		    // int b= fr.nextInt();
		    // int c= fr.nextInt();
		    // int d= fr.nextInt();
			// int a1 = Math.max(a,b);
			// int a2 = Math.min(a,b);
			// int b1 = Math.max(c,d);
			// int b2 = Math.min(c,d);
			
			// if(b2>a1||a2>b1){
			// 	System.out.println("NO");
			// }else{
			// 	System.out.println("YES");

			// }
		  
		}
        // long endtime = System.currentTimeMillis();
        // System.out.println(endtime-starttime);
	}
}