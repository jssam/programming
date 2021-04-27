import java.io.*;
import java.util.*;
public class priority{
    public static void main(String[] args) throws Exception{
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // PriorityQueue<Character> pq = new PriorityQueue<>(Collections.reverseOrder());
        // // pq.add(10);
        // // pq.add(-10);
        // pd.add('s');
        // pd.add('s');
        // // pq.add(1);
        // // pq.add(0);
        // // pq.add(105);
        // // pq.add(-100);
        // // pq.add(26);
        // // pq.add(45);
        // // pq.add(-310);
        // System.out.println(pq);

        // while(pq.size() > 0){
        //     System.out.print(pq.remove() +"  ");
        // }


        /////k largest elementcd
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
  
        for (int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(br.readLine());
        }
  
        int k = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int j =0;
        while(j<k){
            pq.add(arr[j]);
            j++;
        }
        for(int i = k;i<arr.length;i++){
            if(arr[i]>pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        
        while(pq.size()>0){
            System.out.println(pq.remove());
        }


    }
}
