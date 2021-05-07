import java.util.*;
import java.lang.*;
import java.io.*;
public class hackinfyquesth {
    public static void main (String[] args)
	{
        Scanner scn = new Scanner(System.in);
        long a = scn.nextLong();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<9;i++){
            int  x = scn.nextInt();
            
            hm.put(i+1,x);
        }
        String st = Long.toString(a);
        int maxnum=1;
        int maxchar =(int)st.charAt(0)-48;
        int startingindx=0;
        int endingindx = 0;
        int s = 0;
        while(s<st.length()){
            char atpos = st.charAt(s);
            int num =0 ;
            int i = s+1;
        for(i = s+1;i<st.length();i++){
            if(st.charAt(i)==atpos){
                num++;
            }else{break;}
        }
        if(num>maxnum){
            maxnum = num;
            startingindx = s;
            
            maxchar=(int)atpos;
            endingindx = i;
        }
        System.out.print(atpos);
        System.out.print(maxchar);
        s = i;
    }
    StringBuilder str = new StringBuilder(st);
    System.out.print(maxchar);

    int modval = hm.get(maxchar);
for(int i =startingindx;i<=endingindx;i++ ){
str.setCharAt(i, (char)modval);
}

String newval = str.toString();
System.out.println("hello"+newval);
  long newvalue = Long.parseLong(newval);
    if(newvalue>a){
        System.out.print(newvalue);
    }else{
        System.out.print(a);
    }

    }
}
