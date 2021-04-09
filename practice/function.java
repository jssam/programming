public class function {
    ////////////////normal stack
    public static class CustomStack {
        int[] data;
        int tos;
    
        public CustomStack(int cap) {
          data = new int[cap];
          tos = -1;
        }
    
        int size() {
          return tos+1;
        }
        void display() {
         for(int i =tos;i>=0;i--){
             System.out.print(data[i]+" ");
         }
         System.out.println();
        }
        void push(int val) {
          if(size()<data.length){
              tos++;
              data[tos] = val;
          }else{System.out.println("Stack overflow");return;}
        }
        int pop() {
          if(tos!=-1){
              tos--;
              return data[tos+1];     
          }else{System.out.println("Stack underflow"); return -1;}
        }
        int top() {
              if(tos!=-1){
    return data[tos];
          }else{System.out.println("Stack underflow"); return -1;}   
}
    ///////dynamic stack
    void pushdynamic(int val) {
        if (tos == data.length - 1) {
            int s = size()*2;
            int arr[] = new int[s];
            for(int i =0;i<data.length;i++){
                arr[i]=data[i];  
            }
          data = arr;
        } 
          tos++;
          data[tos] = val;
      }
////////////Normal  queue////
public CustomQueue(int cap) {
    data = new int[cap];
    front = 0;
    size = 0;
  }
  int size() {
    return this.size;
  }
  void display() {
    for(int i = 0;i<size;i++){
        int idx = (front+i)%data.length;
        System.out.print(data[idx]+" ");
    }
    System.out.println();
  }

  void add(int val) {
      if(size == data.length){
          System.out.println("Queue overflow");
          return ;
      }
    int idx = (front+size)%data.length;
    data[idx] = val;
    size++;
    
  }

  int remove() {
      if(size==0){
           System.out.println("Queue underflow");
           return -1;
      }
    int val = data[front];
    data[front] = 0;
    front = (front+1)%data.length;
    size--;
    return val;
  }

  int peek() {
      if(size==0){
           System.out.println("Queue underflow");
           return -1;
      }
     return data[front];
  }
  //////////////dynamic queue
  void add_dynamic(int val) {
    // write ur code here
    if(size == data.length){
      int arr[] = new int[data.length*2];
      for(int i =0;i<data.length;i++){
          arr[i] = data[(front+i)%data.length];
      }
      front = 0;
      arr[size]=val;
      data = arr;
      size++;
    } else {
      int idx = (front + size) % data.length;
      data[idx] = val;
      size++;
    }
}
    }
}

