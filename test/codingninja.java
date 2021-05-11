import java.util.*;
class codingninja{

     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        long x = 1;
        for(int i = 2;i<n/2;i++){
            long a  = n-x;
            boolean hell  = check(a);
            if(hell){
                System.out.println("yes");
                return;
            }
            x+=i;
        }
        System.out.print("no");
    }
    public static boolean check(long a){
        System.out.println("a"+a);

        long x = (long) Math.sqrt((4L*a)+1L+0.00);
        long hell = (x-1L)/2L;
        System.out.println(hell*(hell+1L));
        if((hell*(hell+1L))==a){
            return true;
        }else{
            return false;
        }
    }
}