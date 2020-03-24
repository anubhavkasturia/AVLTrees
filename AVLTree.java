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
    private int getBalance(Node node){
        int lh=-1;
        int rh=-1;

        if(node.left!=null){lh=node.left.height;}
        if(node.right!=null){lh=node.right.height;}

        return lh-rh;
    }
    private int getHeight(Node node){
        int lh=-1;
        int rh=-1;

        if(node.left!=null){lh=node.left.height;}
        if(node.right!=null){lh=node.right.height;}

        return Math.max(lh, rh)+1;
    }

    public Node addData(Node node, int data){

        if(node==null){
            Node datavalue=new Node(data, null, null);
            return datavalue;
        }

        if(data>node.data){
            node.right=addData(node.right, data);
        }
        else if(data<node.data){
            node.left=addData(node.left, data);
        }
       
        node.height=getHeight(node);
        node.balance=getBalance(node);

        node=fix(node);
        return node;

    }
    private Node fix(Node node){
        if(getBalance(node)>1){ //left heavy hai
            if(getBalance(node.left)>0){
                //rr
                node=rightrotation(node);
            }else{
                //lr
                node=leftrotation(node.left);
                node=rightrotation(node);
            }
        }
        else if(getBalance(node)<-1){ //right heavy hai
            if(getBalance(node.right)>0){ // samecondition<0 toh yha //ll
                //rl
                node=rightrotation(node.right);
                node=leftrotation(node);
            }else{
                //ll
                node=leftrotation(node);
            }
            
            }
        return node;
        }
    
    private Node rightrotation(Node node){
        Node nnode=node.left; //saves the address of B attached to A(the root node)
        
        Node temp=nnode.right;//saves location of  Br attached to B ?Save toh krlia par hataya thodi?
        
        nnode.right=node;//right rotation B top pe A right mai
        
        node.left=temp;//?yha pe change krdi location isilie update hogya?
        
        node.height=getHeight(node); //gets height of A
        node.balance=getBalance(node); //gets balanceFactor of A

        node.height=getHeight(nnode); //gets height of B
        node.balance=getBalance(nnode); //gets balanceFactor of B



        return nnode;
    }
    private  Node leftrotation(Node node){
        Node nnode=node.right; //saves the address of B attached to A(the root node)
        
        Node temp=nnode.left;//saves location of  Br attached to B ?Save toh krlia par hataya thodi?
        
        nnode.left=node;//left rotation B top pe A left mai
        
        node.right=temp;//?yha pe change krdi location isilie update hogya?
        
        node.height=getHeight(node); //gets height of A
        node.balance=getBalance(node); //gets balanceFactor of A

        node.height=getHeight(nnode); //gets height of B
        node.balance=getBalance(nnode); //gets balanceFactor of B



        return nnode;
    }
    
    
    
    
    
    
    }

 
    


