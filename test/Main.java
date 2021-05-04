import java.util.*;

public class Main{
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        Long num = scn.nextLong();
        for(int n =0;n<num;n++){
            Long x = scn.nextLong();
            Long y = scn.nextLong();
            Long r = scn.nextLong();
            Long rupee = 0L;
            Long stx=1L;
            Long sty=1L;
            if(x==0&&y==0){System.out.println("NO"); continue;}
            while(stx!=x||sty!=y){
                if(stx!=x){
                    stx++;
                    rupee +=sty;
                }
                if(sty!=y){
                    sty++;
                    rupee +=stx;
                    System.out.println("re"+rupee);
                }
                if(rupee>r){
                    break;
                }
            }
            System.out.println("fi"+rupee);
            if(rupee.equals(r)){
                System.out.println("YES");
            }else{System.out.println("NO");}
            
        }        
     
    }
}
    