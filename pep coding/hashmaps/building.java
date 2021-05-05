import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }
    private  int findthelinkplace(int bi,K key){
        LinkedList<HMNode> a = buckets[bi];
        for(int i = 0;i<a.size();i++){
            HMNode b = a.get(i);
            if(key.equals(b.key)){
                return i;
            }
        }
        return -1;
    }
    private  int hashcode(K key){
        int hc =    key.hashCode();
        int bi = Math.abs(hc%buckets.length);
        return bi;
    }
     private void rehash() throws Exception {
        LinkedList<HMNode> []oldbucket = buckets;
        initbuckets(oldbucket.length*2);
        size = 0;
        for(LinkedList<HMNode>ll:oldbucket){
            for(HMNode node : ll){
                put(node.key,node.value);
            }
        }
    }
    public void put(K key, V value) throws Exception {
      int bi = hashcode(key);
      int li = findthelinkplace(bi,key);
      
      if(li == -1){
          //update
           buckets[bi].addLast(new HMNode(key,value));
          size++;
    
      }else{
          //new add
               HMNode node = buckets[bi].get(li);
          node.value = value;
      }
      double lamda = (size*1.0)/buckets.length;
      if(lamda>2.0){
          rehash();
      }
    }
   
    public V get(K key) throws Exception {
      int bi = hashcode( key);
      int li = findthelinkplace( bi,key);
      
      if(li!=-1){
          //update
          
           HMNode node = buckets[bi].get(li);
         return node.value;
      }else{
          //new add
         return null;
      }
    }

    public boolean containsKey(K key) {
      int bi = hashcode( key);
      int li = findthelinkplace( bi,key);
      
      if(li!=-1){
          //update
           return true;
      }else{
          //new add
        return false;
      }
    }

    public V remove(K key) throws Exception {
        int bi = hashcode(key);
      int li = findthelinkplace( bi,key);
      
      if(li!=-1){
          //update
          HMNode node = buckets[bi].remove(li);
          size--;
          return node.value;
      }else{
          //new add
          return null;
      }
    }

    public ArrayList<K> keyset() throws Exception {
      ArrayList<K> a = new ArrayList<>();
      for(LinkedList<HMNode> li:buckets){
          for(HMNode node: li){
              a.add(node.key);
          }
      }
      return a;
    }

    public int size() {
      return this.size;
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}