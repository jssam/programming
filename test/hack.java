import java.util.*;
import java.lang.*;
import java.io.*;
public class hack {
    public static void main (String[] args)
	{
            Scanner scn = new Scanner(System.in);
            int a = scn.nextInt();
            int [] arr = new int[a];
            PriorityQueue<Integer>pq = new PriorityQueue<>();
            for(int i =0;i<arr.length;i++){
                arr[i] = scn.nextInt();
                if(i<5){
                    pq.add(arr[i]);
                }
            }

            for(int i = 5;i<arr.length;i++){
                if(arr[i]>pq.peek()){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
            long mul = 1;
            while(pq.size()!=0){
                int c = pq.remove();
                mul = mul*c;
            }
            if(mul<0){
                mul = (int)mul + 1000000007;
            }
            System.out.print(mul);


    }
}
