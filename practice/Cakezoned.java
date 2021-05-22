import java.util.*;

public class Cakezoned{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        int []arr  = new int [num];
        long os = 0l;
        long es = 0l;
        for(int i = 0;i<num;i++){
            arr[i] = scn.nextInt();
            if(i%2==0){
                es = es+arr[i];
            }else{
                os =  os+arr[i];
            }
        }
        long query = scn.nextLong();
        for(int i = 0;i<query;i++){
            int a = scn.nextInt();
            if(a == 1)
            {
               int l = scn.nextInt();
               int  r = scn.nextInt();
                long x = scn.nextLong();
             int j = r - l;

                if(j % 2 != 0)
                {
                    j += 1;
                    j /= 2;
                    es += j*x;
                    os += j*x;
                }
                else
                {
                    if(l % 2 == 0 && r % 2 == 0)
                    {
                        j /= 2;
                        es += j*x;
                        os += j*x;
                        os += x;
                    }
                    else if(l % 2 != 0 && r % 2 != 0)
                    {
                        j /= 2;
                        es += j*x;
                        os += j*x;
                        es += x;
                    }
                }
            }else if(a==2){
                System.out.println(es);

            }else if(a==3){
                System.out.println(os);
            }
        }
      

    }
}
    