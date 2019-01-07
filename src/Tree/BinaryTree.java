package Tree;

import java.util.*; 

public class BinaryTree {
    private TreeNode root=null;
    public BinaryTree(){
        root = new TreeNode(1,"A");
    }

    public void createBinaryTree(){
        TreeNode nodeB=new TreeNode(2,"B");
        TreeNode nodeC=new TreeNode(3,"C");
        TreeNode nodeD=new TreeNode(4,"D");
        TreeNode nodeE=new TreeNode(5,"E");
        TreeNode nodeF=new TreeNode(6,"F");
        root.leftChild=nodeB;
        root.rightChild=nodeC;
        nodeB.leftChild=nodeD;
        nodeB.rightChild=nodeE;
        nodeC.rightChild=nodeF;
    }

    public void createBinaryTreePre (ArrayList<String> data ){
        createBinaryTreePre(data.size(),data);
    }

    private TreeNode createBinaryTreePre(int size, ArrayList<String> data) {
        if (data.size()==0){
            return null;
        }
        Object d=data.get(0);
        TreeNode node;
        int index=size-data.size();
        if (d.equals("#")){
            node=null;
            data.remove(0);
            return node;
        }
        node=new TreeNode(index,d);
        if (index==0){
            root=node;
        }
        data.remove(0);
        node.leftChild=createBinaryTreePre(size,data);
        node.rightChild=createBinaryTreePre(size,data);
        return node;
    }


    public void preOrder(TreeNode root){
        if (root==null){
            return;
        }else{
            System.out.print(root.getData()+"  ");
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    public void midOrder(TreeNode root){
        if (root==null){
            return;
        }else {
            midOrder(root.leftChild);
            System.out.print ( root.getData()+"  ");
            midOrder(root.rightChild);
        }
    }

    public void postOrder(TreeNode root){
        if (root==null){
            return;
        }else {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            System.out.print( root.getData()+"  ");
        }
    }

      public void PreOder1(TreeNode root){
          if(root == null){
              return;
          }
          Stack<TreeNode> stack = new Stack<TreeNode>();
          stack.push(root);
          while(!stack.isEmpty()){
              TreeNode node= stack.pop();
              //压入子结点
              System.out.print ( node.getData()+"  ");
              if(node.rightChild!=null){
                  stack.push(node.rightChild);

              }
              if(node.leftChild!=null){
                  stack.push(node.leftChild);
              }
          }
      }
    /**
     * 中序非递归遍历二叉树
     * @param root
     */
    public void midOrder1(TreeNode root){
       if (root==null){
           return;
       }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        while (p!=null ||!stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                p=p.leftChild;
            }
            if (!stack.isEmpty()){
                 p=stack.pop();
                System.out.print(p.getData()+"  ");
                p=p.rightChild;
            }
        }
    }

    /**
     * 二叉树的非递归后序遍历
     * @param root
     */
    public void postOrder1(TreeNode root){
         if (root==null){
             return;
         }
         Stack<TreeNode> stack=new Stack<>();
        TreeNode p,q;
        p=root;q=null;
        while (p!=null||!stack.isEmpty()){
            while (p!=null){
                stack.push(p);p=p.leftChild;
            }
            if (!stack.isEmpty()){
                p=stack.peek();
                if (p.rightChild==null||p.rightChild==q){
                    stack.pop();
                    System.out.print(p.getData()+"  ");
                    q=p;
                    p=null;
                }else {
                    p=p.rightChild;
                }
            }
        }
    }


    public class TreeNode<T>{
        private int index;
        private T data;
        private TreeNode  leftChild;
        private TreeNode  rightChild;
        public TreeNode(int index,T data){
            this.index=index;
            this.data=data;
            this.leftChild=null;
            this.rightChild=null;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }



    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
        BinaryTree tree=new BinaryTree();
        ArrayList<String> lists=new ArrayList();
        String[] s=new String[15];
        System.out.println("请输入数据(15个字符)： ");
        for(int i = 0; i < 15; i++){
        	s[i] = input.next();
        }
        for (String str:s){
            lists.add(str);
        }
        tree.createBinaryTreePre(  lists);
        System.out.println("请选择遍历方式：");
        System.out.println("1.递归先序遍历：");
        System.out.println("2.递归中序遍历：");
        System.out.println("3.递归后序遍历：");
        System.out.println("4.非递先序遍历:");
        System.out.println("5.非递归中序遍历：");
        System.out.println("6.非递归后序遍历：");
        int i = input.nextInt();
        switch(i){
        case 1:System.out.println("二叉树的递归先序遍历结果为:");
        	   System.out.print("preOder data: ");
        	   tree.preOrder(tree.root);
        	break;
        case 2: System.out.println("二叉树的递归中序遍历结果为:");
        		System.out.print("midOder data: ");
        		tree.midOrder(tree.root);
        	break;	
        case 3: System.out.println("二叉树的递归后序遍历结果为:");
        		System.out.print("postOder data: ");
        		tree.postOrder(tree.root);
        	break;	
        case 4: System.out.println("二叉树的非递归先序遍历遍历结果为:");
        		System.out.print("nonpreOder data: ");
        		tree.PreOder1(tree.root);
        	break;	
        case 5:  System.out.println("二叉树的非递归中序遍历遍历结果为:");
        		 System.out.print("nonmidOder data: ");
        		 tree.midOrder1(tree.root);
        	break;	
        case 6: System.out.println("二叉树的非递归后序遍历遍历结果为:");
        		System.out.print("nonmidOder data: ");
        		tree.postOrder1(tree.root);
        	break;	
        }
        
    }
}
