import java.util.*;
  import java.io.*;
  
  public class prep {
    public static void main(String args[]) throws IOException {
      Scanner scn  = new Scanner(System.in);
    //   int N  = scn.nextInt();
    //   int X = scn.nextInt();
    //   int K = scn.nextInt();
    //   int[] arr1 = new int[N];
    //   for(int i = 0;i<N ; i++){
    //     arr1[i] = scn.nextInt();
    //   }
    //    int[] arr2 = new int[N];
    //   for(int i = 0;i<N ; i++){
    //     arr2[i] = scn.nextInt();
    //   }
    //   int res = 0;
    //   int days = 1;
    //   while(res<X){
    //     for(int i = 0;i<N;i++){
    //       int hell = (days*arr2[i])+arr1[i];
    //       if(hell>=K){
    //         res = res+hell;
    //       }
    //     }
    //     if(res>=X){
    //       System.out.print(days);
    //       return;
    //     }
    //     days++;
    //   }
    int n = scn.nextInt();
    n = n^(n>>1);
    System.out.print(n&1);
    
    }
  }