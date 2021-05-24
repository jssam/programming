import java.util.*;

public class Main{
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        long num = scn.nextLong();
        // for(int n =0;n<num;n++){
        //     Long x = scn.nextLong();
        //     Long y = scn.nextLong();
        //     Long r = scn.nextLong();
        //     Long rupee = 0L;
        //     Long stx=1L;
        //     Long sty=1L;
        //     if(x==0&&y==0){System.out.println("NO"); continue;}
        //     while(stx!=x||sty!=y){
        //         if(stx!=x){
        //             stx++;
        //             rupee +=sty;
        //         }
        //         if(sty!=y){
        //             sty++;
        //             rupee +=stx;
        //             System.out.println("re"+rupee);
        //         }
        //         if(rupee>r){
        //             break;
        //         }
        //     }
        //     System.out.println("fi"+rupee);
        //     if(rupee.equals(r)){
        //         System.out.println("YES");
        //     }else{System.out.println("NO");}
            
        // }
           
        

        ///code forces ans 1
        for(int x =0;x<num;x++){
          int a = scn.nextInt();
          int arr[] = new int[a];
          boolean plus = false;
          boolean zero = false;
          boolean sec = false;
          int ans = 0;
          for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
            if(arr[i]<0){
              ans++;
            }
             if(arr[i]==0){
              zero = true;
             }else if(arr[i]>0){
              plus = true;
            }
            if(arr[i]==0&&zero==true){
              sec =true;
            }
          }
          if(zero){
            ans++;
          }
          if(plus)
          {
            ans++;
          }
          if(plus==false&&sec){
            ans++;
          }
        //   if(a==2){
        //     System.out.println(1);
        //     continue;
        //   }
        //   long c= 1;
        // double x = 0;
        //   while(a>=x){
        //      x= Math.pow(2, c);
        //      c++;
        //   }
        //   x = x/2;
        //   System.out.println((int)(x-1));

   
      //     int ans = 0;
      //   for(int i = 1;i<=a;i++){
      //     int n = 0;
      //     for(int j=i;j<=a;j++){
      //            n = n +j;
      //         if(n>a){
      //           break;
      //         }else if(n==a){
      //           ans++;
      //           break;
      //         }
      //     }
      // } 

      System.out.println(ans);
      }
    }
}




    