
import java.io.*;

import java.util.Arrays;
import java.util.Scanner;
public class walmart_sec {
    public static void main(String[] args) throws IOException{
        // Scanner scn = new Scanner(System.in);
        // int n =scn.nextInt();
        // long c =scn.nextLong();
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in)); 
        String inputString = input.readLine();
        String[] str = inputString.split(" ");
        int n  =  Integer.parseInt(str[0]);
        long c = Long.parseLong(str[1]); 
        // System.out.println(c);
 

        long  h[] = new long[n];
        for(int i = 0; i < n; i++){
            h[i] = Long.parseLong(str[i+2]);
            // System.out.println(h[i]);
        }
        long dp[] = new long [200002];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0]= 0;
        dp[1] = ((h[1] - h[0])*(h[1]-h[0])) + c;
        for(int i = 2; i < n; i++){
            for(int j = i - 1; j  >= 0; j--){
              dp[i] = Math.min(dp[i], dp[j] + ((h[j] - h[i])*(h[j]-h[i])) + c);
            }
          }
          System.out.println(dp[n-1]);
    }
}
