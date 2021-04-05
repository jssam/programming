import java.util.*;

public class Main{
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        for(int n = 0;n<=num;n++){
        String str = scn.nextLine();
        String ne = "";
        int size  = str.length();
        if(size>10){
            ne = str.charAt(0)+ne;
            ne = ne+(size-2);
            ne = ne + str.charAt(size-1);
            System.out.println(ne);
        }else{System.out.println(str);}
        
        
        
        
        }        
     
    }
    
}