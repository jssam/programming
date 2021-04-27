import java.io.*;
import java.util.*;

public class gcc_print{
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
    public static ArrayList find(ArrayList<Edge>[]graph,int src,ArrayList<Integer>x,boolean []vt){
        
            vt[src] = true;
            x.add(src);
            for(Edge edge:graph[src]){
                int nbr = edge.nbr;
                if(vt[nbr]!=true){
                    find(graph,nbr,x,vt);
                }
            }
        return x;
        
    }
    public static void gcc(ArrayList<Edge>[]graph,ArrayList<ArrayList<Integer>>given,boolean []vt){
        for(int i = 0;i<vt.length;i++){
            if(vt[i]!=true){
                ArrayList<Integer> x = new ArrayList<>();
                ArrayList<Integer> a = find(graph,i,x,vt);
                given.add(a);
            }
        }
        return ;
    }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean [] vt = new boolean [vtces];
      gcc(graph,comps,vt);
      
      System.out.println(comps);
   }
}