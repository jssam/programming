// /* Read input from STDIN. Print your output to STDOUT*/

// import java.io.*;
// import java.util.*;
// public class CandidateCode {
//    public static void main(String args[] ) throws Exception {
// Scanner scn = new Scanner(System.in);
// int a = scn.nextInt();
// for(int i = 0;i<a;i++){
//    int l = scn.nextInt();
//    int h = scn.nextInt();
//     //  System.out.println(l);
//     //  System.out.println(h);
//    if(l==h){
//       System.out.println("0");
//       continue;
//    }
//    segseive(l,h);
// }

//    }
//    public static ArrayList<Integer> prime;
//    public static void segseive(int l,int h){
//       prime = new ArrayList<>();
//       int sq = (int)Math.sqrt(h);
//       sieve(h);
//       boolean isprime[] = new boolean[h-l+1];
//       int small = Integer.MAX_VALUE;
//       int max = Integer.MIN_VALUE;
//       boolean non = true;

//       for(int p: prime){
//          int rm = (l/p)*p;
//          if(rm<l){
//             rm += p;
//          }
//          if(p<small&&p>=l){
//                small = p;
//                non = false;
//             }
//             if(p>max&&p>=l){
//                max = p;
//             }
//       }

//     //   for(int i = l;i<=h;i++){
//     //      if(isprime[i-l]){
//     //         if(i<small){
//     //            small = i;
//     //            non = false;
//     //         }
//     //         if(i>max){
//     //            max = i;
//     //         }
//     //      }
//     //   }
//       if(non == true){
//          System.out.println("-1");
//          return;
//       }
//        System.out.println(max-small);
//    }
//    public static void sieve(int n){
//       boolean isprime[] = new boolean[n+1];
//       Arrays.fill(isprime,true);
//       for(int i = 2;i<=n;i++){
//          if(isprime[i]){
//             //  System.out.print(i);
//             prime.add(i);
//             for(int j =i*i;j<=n;j= j+i){
//                isprime[j] = false;
//             }
//          }
//       }
//    }
// }



/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;
public class CandidateCode {
   public static void main(String args[] ) throws Exception {
Scanner scn = new Scanner(System.in);
int a = scn.nextInt();
sieve(100001);
for(int i = 0;i<a;i++){
   int l = scn.nextInt();
   int h = scn.nextInt();
    //  System.out.println(l);
    //  System.out.println(h);
   if(l==h){
      System.out.println("0");
      continue;
   }
   segseive(l,h);

}

   }
   public static ArrayList<Integer> prime;
   public static void segseive(int l,int h){
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      boolean non = true;
        for(int p:prime){
            if(p<min&&p>=l&&p<=h){
                min = p;
                non = false;
             }
             if(p>max&&p>=l&&p<=h){
                max = p;
             }
             if(p>h){break;}
        }
        if(non == true){
            System.out.println("-1");
            return;
         }
          System.out.println(max-min);
   }
   
//////seive
   public static void sieve(int n){
      prime = new ArrayList<>();
      boolean isprime[] = new boolean[n+1];
      Arrays.fill(isprime,true);
      for(int i = 2;i<=n;i++){
         if(isprime[i]){
            //  System.out.print(i);
            prime.add(i);

            for(int j =i*i;j<=n;j= j+i){
                if(j>i&&j<Integer.MAX_VALUE){
               isprime[j] = false;
            }else{
                break;
            }
            }
         }
      }
   }
}
