private void displayReverseHelper(Node node){
      if(node==null){
      	return;
      }
    displayReverseHelper(node.next);
    System.out.println(node.data+" ");

    }

    public void displayReverse(){
      displayReverseHelper(head);
      System.out.println();
    }
