import java.util.*;
import java.lang.*;
import java.io.*;

public class runs {
    
        public static void main (String[] args) throws java.lang.Exception
        {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int o = scn.nextInt();
        int c = scn.nextInt();
        int remaining = (20-o)*6;
        int maxrun = remaining*6;
        int finalrun = maxrun+c;
        if(finalrun>r){
           System.out.print("YES");
        }else{
           System.out.print("NO"); 
        }
    }
}

