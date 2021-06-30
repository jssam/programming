import java.util.*;
import java.lang.*;
import java.io.*;
// import java.util.Collections;
class justpay{
	public static int lowerbound(ArrayList<Integer> arr, int N, int X)
		{
            int l=-1,r=arr.size();
            while(l+1<r) {
               int m=(l+r)>>>1;
               if(arr.get(m)<=X) l=m;
               else r=m;
            }
            return l+1;
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
public static ArrayList<Integer> g[]= new ArrayList[1001];
public static class pair implements Comparable<pair>{
    int a ;
    ArrayList<Integer>al;
    pair(int a , ArrayList<Integer> l){
        this.a = a;
        this.al = l;
    }

    public int compareTo(pair o) {
        
        return o.a-this.a;
    }
}
public static ArrayList<pair>pt =  new ArrayList<>();

public static void dfs(int st,int e,int vis[],ArrayList<Integer> rs,int w){
    rs.add(st);
    if(st == e){
               
    pair sam = new pair(w*(rs.size()-1),rs);
     pt.add(sam);
        return;
    }
    for(Integer u : g[st]){
        if(vis[u] == 0){
           vis[st] = 1;
           dfs(u,e,vis,rs,w);
           vis[st] = 0;
        }
    }
 }
	static public void main(String[] args)
	{

		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		FastReader fr = new FastReader();
		int n= fr.nextInt();
        long m= fr.nextLong();
        long t= fr.nextLong();
        int c= fr.nextInt();
        for(int i = 0;i<g.length;i++){
            g[i] = new ArrayList<>();
        }
        while(m-->0){
            int u= fr.nextInt();
            int v= fr.nextInt();
            g[u].add(v);
            g[v].add(u);
        }
        ArrayList<Integer> rs = new ArrayList<>();
        int w = c;
        int vis[] = new int[n+1];
        dfs(1,n,vis,rs,w);
        Collections.sort(pt);
        ArrayList<Integer> rt[]= new ArrayList[n+1];
        for(int i = 0;i<n+1;i++){
            rt[i] = new ArrayList<>();
        }
        for(int i=0;i<pt.size();i++){
            int nes = pt.get(i).al.size();
            for(Integer u : pt.get(i).al){
                rt[u].add(nes);
            }
        }
        long trt[] = new long[n+1];
        trt[1] = 1;
        trt[n] = 1;
        for(int i=2;i<=n-1;i++){
            if(rt[i].size() > 0){
                int tm = rt[i].get(0);
                int up = lowerbound(rt[i],rt[i].size(),tm)-rt[i].size() ;
                System.out.println(rt[i]);
                trt[i] = up;
            }
        }

        for(int i=1;i<=n;i++){
        out.print(trt[i]+" ");
    }
       

        out.close();
	}
			
         
} 
		

