public class interview {
  public static void main(String[] args) {
   
    int n  = 1;
    int s = n;
    int ans = 0;
    while(n%10!=0){
    int a = n%10;
    ans+=(a*a*a);
    n = n/10;
    }
    if(n!=0){
    ans+=(n*n*n);
    }
    if(ans== s){
   System.out.println(s+" is amstrong number");
    }else{
        System.out.println(s+ " not amstrong number");

    }
    String a = "true";
    if(System.out.printf("da")==null){
        ans++;
    }
   } 
}
