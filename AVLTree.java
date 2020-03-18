public class AVLTree{
    private class Node{
        int data;
        Node left;
        Node right;
        int height=-1;
        int balance=0;
    
        Node(int data,Node left,Node right){
        this.data=data;
        this.left=left;
        this.right=right;
    }
}
    private Node root;
    private int size;

    public AVLTree(int[]arr){
        this.root=construct(arr,0,arr.length-1);
        this.size=size(this.root);
    }

    private Node construct(int[]arr,int start,int end){

        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node node=new Node(arr[mid],null,null);
        node.left=construct(arr, start, mid-1);
        node.right=construct(arr, mid+1, end);
        node.height=getHeight(node);
        node.balance=getBalance(node);

        return node;
    }

    public void display() {
        display(this.root);
    }
    
    private void display(Node node) {
       if (node == null) {
           return;
       }
       String str = " ";
       str += node.left != null ? node.left.data : ".";
       str += "->" + node.data + "<-";
       str += node.right != null ? node.right.data : ".";
       System.out.println(str);
    
       display(node.left);
       display(node.right);
    }
    public int size(){
        return size(this.root);
    }
    public int size(Node node){
      if(node==null){
          return 0;
      }
      int lsize=size(node.left);
      int rsize=size(node.right);
      return lsize+rsize+1;
  
  }
    private static int getBalance(Node node){
        int lh=-1;
        int rh=-1;

        if(node.left!=null){lh=node.left.height;}
        if(node.right!=null){lh=node.right.height;}

        return lh-rh;
    }
    private static int getHeight(Node node){
        int lh=-1;
        int rh=-1;

        if(node.left!=null){lh=node.left.height;}
        if(node.right!=null){lh=node.right.height;}

        return Math.max(lh, rh)+1;
    }
}

    


