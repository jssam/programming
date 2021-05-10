import java.util.*;
public class graph {
    public static class Edge{
        int src;
        int ngh;
        int weight;
        Edge(int src,int ngh,int weight){
            this.src = src;
            this.ngh = ngh;
            this.weight = weight;
        }
        ///print ARAM   se ho jaye isliye phm isme use karenge to string
        public String toString(){
            return src +" -> "+ ngh +" @ "+ weight;
        }

    }
   public  static void main(String[] args) {
       int c  = 7;
       ArrayList<Edge> graph[] = new ArrayList[c];
       for(int i = 0;i<graph.length;i++){
           graph[i] = new ArrayList<>();
       }
       graph[0].add(new Edge(0,1,10));
       graph[0].add(new Edge(0,3,40));
       graph[1].add(new Edge(1,0,10));
       graph[1].add(new Edge(1,2,10));
       graph[2].add(new Edge(2,1,10));
       graph[2].add(new Edge(2,3,10));
       graph[3].add(new Edge(3,0,40));
       graph[3].add(new Edge(3,2,10));
       graph[3].add(new Edge(3,4,10));
       graph[4].add(new Edge(4,3,10));
       graph[4].add(new Edge(4,5,3));
       graph[5].add(new Edge(5,4,3));
       graph[4].add(new Edge(4,6,8));
       graph[5].add(new Edge(5,6,10));
       graph[6].add(new Edge(6,4,8));
       graph[6].add(new Edge(6,5,10));

       for(int i = 0 ;i<graph.length;i++){
           System.out.println(i+ " -> " + graph[i]);
       }

   }
}
