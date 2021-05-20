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
              for(int n =0;n<num;n++){
                  long a = scn.nextLong();
                  if(a==2){
                    System.out.println(1);
                    continue;
                  }
                  long c= 1;
                  long x = 0;
                  while(a>=x){
                     x= (1<<(c));
                     c++;
                  }
                  x = x/2;
                  System.out.println(x-1);
              }     
     
    }
}
    