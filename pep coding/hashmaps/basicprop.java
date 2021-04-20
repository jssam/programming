import java.util.HashMap;
import java.util.ArrayList;
public class basicprop{
    public static void main(String args[]){
        HashMap<String,Integer> hm = new HashMap<>();
        
        hm.put("India",200);
        hm.put("UK",180);
        hm.put("USA",190);
        hm.put("China",170);
        hm.put("Utopia",150);
        
        ArrayList<String> list = new ArrayList<>(hm.keySet());
        System.out.println(list);
        // System.out.println(hm);
        for(String keys : hm.keySet()){
            System.out.print(keys+"-->"+hm.get(keys)+"  ");
        }
        System.out.println();
        System.out.println(hm.remove("China"));
        System.out.println(hm.remove("india"));
        System.out.println(hm.size());
        
    }
}