import java.util.*;
import java.lang.*;
import java.io.*;
// import java.util.Collections;
class input{
	public static int lowerbound(int arr[], int N, int X)
		{
			int mid;

			int low = 0;
			int high = N;

			while (low < high) {
				mid = low + (high - low) / 2;

				if (X <= arr[mid]) {
					high = mid;
				}
				else {
					low = mid + 1;
				}
			}
			if(low < N && arr[low] < X) {
			   low++;
			}
			return low;
		}

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
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		FastReader fr = new FastReader();
		int t= fr.nextInt();

// for(int j = 0;j<string.length;j++){
// 	String n = string[j];
	// System.out.println(n);
	// n = n.replaceAll("\\s", "");
			while(t-->0){
				
				int a= fr.nextInt();
				int b= fr.nextInt();
			
				if((b&(b-1))==0){
					out.println("Yes");
				}else{
					out.println("No");

				}
				// ArrayList<Integer> even = new ArrayList<>();
				// ArrayList<Integer> odd = new ArrayList<>();
				// for(int i = 0;i<n;i++){
				// 	int x = fr.nextInt();
				// 	if(x%2==0){
				// 		even.add(x);
				// 	}else{
				// 		odd.add(x);
				// 	}
				// }
				// // Collections.sort(even, Collections.reverseOrder());
				// Collections.sort(odd, Collections.reverseOrder());
				// StringBuilder sb = new StringBuilder();
				// for(Integer a:even){
				// 	sb.append(a+" ");
				// }
				// for(Integer a:odd){
				// 	sb.append(a+" ");
				// }

				// System.out.println(sb.toString());

				
			// fr.next();
			// if(n.charAt(0)=='1'){
			// 	String a = n.substring(0,1)+'0'+n.substring(1);
			// 	System.out.println(a);
			//  }
			//  else{
			// 	String s="1";
			// 	String b=s+n;
			// 	System.out.println(b);
			//  }
			// int a = fr.nextInt();
			// int b = fr.nextInt();
			// int x = fr.nextInt();
			// System.out.println((int)(Math.floor((b-a)/x)));
			// String c  = n.substring(0, 2);
			// if(n.length()<4){
			// 	System.out.println("Error");
			// 	continue;
			// }
			// String b = n.substring(2, n.length()-1);
			// // System.out.println(b);

			// if(!c.equals("</")){
			// 	System.out.println("Error");
			// 	continue;
			// }
			// // System.out.println(b);
			// // System.out.println(c);
			// boolean sam = true;
			// for(int i = 0;i<b.length();i++){
			// 	// int x= (int)b.charAt(i);
			// 	// System.out.println(x);

			// 	if((b.charAt(i)>='0'&&b.charAt(i)<='9')||(b.charAt(i)>='a'&&b.charAt(i)<='z')){
					
			// 		continue;
			// 	}else{
			// 		sam = false;
			// 		// System.out.println(b.charAt(i));
			// 		System.out.println("Error");
			// 		break;
			// 	}
			
			// }
			// if(sam){
		
			// if(n.charAt(n.length()-1)!='>'){
			// 	// System.out.println(n.charAt(n.length()-1));

			// 	System.out.println("Error");
			// 	continue;
			// }
		
			// System.out.println("Success");
			// }
			// int count0 = 0;
			// int count1 = 0;
			// String str = fr.nextLine();
			// for(int i = 0;i<n;i++){
			// 	if((str.charAt(i)-'0')==0){
			// 		count0++;
			// 	}else{
			// 		count1++;
			// 	}
				
			// }
			// if(count0>=count1){
			// 	System.out.println(0);
			// }else{
			// 	System.out.println(count1-count0);

			// }






		    // int y= fr.nextInt();

			// int arr[] = new int[x];

			// for(int i = 0;i<x;i++){
			// 	arr[i] = fr.nextInt();
			// }
			// for(int i =0;i<y;i++){
			// 	int qu= fr.nextInt();
			// 	int s  = lowerbound(arr,x,qu);
			// 	if(s==x){
			// 		System.out.println("POSITIVE");
					
			// 	}
			// 	if(arr[s]!=qu){
			// 		if(s==0){
			// 		System.out.println("POSITIVE");
			// 		}
			// 		else if((x-s)%2==1){
			// 		System.out.println("NEGATIVE");
			// 		}
			// 		else if((x-s)%2==0){
			// 		System.out.println("POSITIVE");
			// 		}
					
			// 	}
			// 	else{
			// 		System.out.println(0);
					
			// 	}

			// }


		    // int x1= fr.nextInt();
		    // int x2= fr.nextInt();
		    // int y1= fr.nextInt();
		    // int y2= fr.nextInt();
		    // int z1= fr.nextInt();
		    // int z2= fr.nextInt();
			// if(x2>=x1&&y2>=y1&&z1>=z2){
			// 	System.out.println("YES");
			// }else{
			// 	System.out.println("NO");

			// }
			// int b= fr.nextInt();
			// if(i==n/2&&j==m/2){
			// 	System.out.println(n +" "+1+" "+1+" "+m);
			// }else if(i<=n/2&&j<m/2){
			// 	System.out.println(1 +" "+n+" "+n+" "+m);
			// }else if(i<n/2&&j<=m/2){
			// 	System.out.println(n +" "+1+" "+n+" "+m);
			// }else if(i>=n/2&&j>m/2){
			// 	System.out.println(n+" "+m+" " +1+" "+1);
			// }else if(i>n/2&&j>=m/2){
			// 	System.out.println(n+" "+m+" "+1+" "+1);
			// }
			
			}
			out.close();} 
		}
	// long endtime = System.currentTimeMillis();
	// System.out.println(endtime-starttime);
