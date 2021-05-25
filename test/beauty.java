import java.util.*;
import java.lang.*;
import java.io.*;
 
 
public final class beauty
{
	public static int dp[][] =  new int[300003][30];
	public static int g[] = new int[300003];
	public static int p[] = new int[300003];
	public static int l[]= new int[300003];
	public static int used[] = new int[300003];
	public static int lg=0;
	
	public static void insert(int u,int v)
	{

		lg++;
		g[lg]=v;
		p[lg]=l[u];
		l[u]=lg;
	}
	
	public static void dfs(int u,int k,String a,int[]sam)
	{

		if(used[u]!=0 && used[u]<k)
		{
			sam[0]=-1;
            return ;
		}
		if(used[u]!=0)
		return;
		used[u]=k;
		int v;
		for(int i=l[u];i!=0;i=p[i])
		{
			v=g[i];
			dfs(v,k+1,a,sam);
			for(int j=0;j<26;j++)
			{
				if(dp[u][j]<dp[v][j])
				dp[u][j]=dp[v][j];
			}
		}
		dp[u][a.charAt(u-1)-'a']++;
		used[u]=1000000;
	}
	
	
	public static int beauty1(int n,int m, String s,int x[],int y[])
	{

		for(int[] r : dp){
			Arrays.fill(r,0);
		}
		Arrays.fill(g,0);
		Arrays.fill(p,0);
		Arrays.fill(l,0);
		Arrays.fill(used,0);
		for(int i=0;i<m;i++){
			insert(x[i],y[i]);
		}
		for(int i=1;i<=n;i++){
            int[]sam = new int[1];
            sam[0]= 0;
			dfs(i,1,s,sam);
            if(sam[0]==-1){
                return -1;
            }
		}
		int res=0;
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<26;j++)
			{
				if(dp[i][j]>res)
				res=dp[i][j];
			}
		}
		return res;
	}
	
	
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String s = sc.next();
		int x[] = new int[m];
		int y[]= new int[m];
		for(int i=0;i<m;i++)
		{
		x[i]=sc.nextInt();
		y[i] = sc.nextInt();
		}
		// beauty sol = new beauty();
		int ans = beauty1(n,m,s,x,y);
		System.out.println(ans);
	}
}