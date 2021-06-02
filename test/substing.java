import java.util.*;
public class substing {
    public static  int maxm = 300005;
    public static int a,b;
    public static int[]degs = new int[maxm];
    public static Vector<Vector<Integer>> has = new Vector(maxm);
    public static Vector<Vector<Integer>> graph = new Vector(maxm);
    public static boolean[] vis = new boolean[maxm];
    private static pair fr;
    // public static vector<vector<Integer>>has(maxm,vector<Integr>(27,0));
    public static class pair{
        int a ;
        int b;
        pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }
   public static boolean has_cycle(int src,boolean[]rstack)
{
    if(vis[src]==false)
    {
        vis[src] = true;
        rstack[src] = true;
        for(Integer edge : graph.get(src))
        {
            if(!vis[edge] && has_cycle(edge,rstack)){
                return true;
            }
            else if(rstack[edge]){
                return true;
            }
        }
    }
    rstack[src] = false;
    return false;
}


public static boolean end1(Set<pair> ok,pair lr){
    Iterator<pair> i = ok.iterator();
    pair sam = new pair(0,0);
    while (i.hasNext()){
     sam = i.next();
        }
if(sam == lr){
    return true;
}
return false;
}
    public static int solve(String s)
{
    boolean[] rstack = new boolean[maxm];
  
    for(int i=0;i<a;i++)
    {
        if(has_cycle(i,rstack)){
            return -1;
        }
    }
    
    Set<pair> ok = new LinkedHashSet<pair>();
    for(int i=0;i<a;i++){
        if(degs[i]==0){
            ok.add(new pair(degs[i],i));
            has.get(i).setElementAt(1 ,i-'a');
        }
    }
    while(ok!=null)
    {
        Iterator<pair> sanyam = ok.iterator();
        fr = sanyam.next();
        ok.remove(fr);
        
        for(Integer edge : graph.get(fr.b))
        {
            for(int i=0;i<27;i++){
                int adder = 0;
                if(s.charAt(edge)-'a'==i){
                    adder=1;
                }
                has.get(edge).setElementAt( Math.max(has.get(edge).get(i),has.get(fr.b).get(i) + adder),i);
            }
            pair val = new pair(degs[edge],edge);
            pair lr = val;
            Boolean che = ok.contains(val);
            if(che == true){
               lr = val;
            }
            if(!end1(ok,lr)){
                ok.remove(lr);
            }
            degs[edge]--;
            if(degs[edge] >= 0){
                ok.add(new pair(degs[edge],edge));
            }
        }
    }
    int ans = 0;
    for(int i=0;i<a;i++){
        for(int j=0;j<27;j++){
            ans = Math.max(ans,has.get(i).get(j));
        }
    }
    return ans;
}

    public static int beauty(int n,int m,String s,int x[],int y[])
    {
        graph.clear();
        graph.setSize(n);
        Arrays.fill(degs,0);
        has.setSize(n);
        // degs.assign(n,0);
        // vis.assign(n,false);
        Arrays.fill(vis,false);
        for(int i=0;i<n;i++){
            graph.setElementAt(new Vector<Integer>(),i);
            has.setElementAt(new Vector(27,0),i);
        }
        a = n;
        b = m;
        for(int i=0;i<n;i++){
            int fr = x[i] - 1;
            int lr = y[i] - 1;
            // graph[fr].push_back(lr);
            graph.get(fr).add(lr);
            degs[lr]++;
        }
        int ans = solve(s);
        return ans;
    }


    public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			int n = sc.nextInt();
			int m = sc.nextInt();
			String s = sc.next();
			int x[] = new int[m ];
			int y[]= new int[m];
			for(int i=0;i<m;i++)
			{
			x[i]=sc.nextInt();
			y[i] = sc.nextInt();
			}
			// beauty sol = new beauty();
			int ans = beauty(n,m,s,x,y);
			System.out.println(ans);
		}
	}
}
