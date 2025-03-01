package BinaryTree;

import java.util.ArrayList;

public class DeleteNode {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data= data;
            this.left=null;
            this.right=null;
        }
    }

    public static Node buildTree(Node root, int val){
        if(root==null){
            root= new Node(val);
            return root;
        }

        if(root.data>val){
            root.left= buildTree(root.left,val);
        }
        else{
            root.right=buildTree(root.right,val);
        }

        return root;
    }

    public static void inOrder(Node root){
        if (root==null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static Node delete(Node root, int val){
        if(root==null){
            return null;
        }

        if(root.data>val){
            root.left= delete(root.left,val);
        }
        else if(root.data<val) {
            root.right=delete(root.right,val);
        }
        else{
            //case1 root is leaf node
            if(root.left== null && root.right==null){
                return null;
            }
            //case2 has one not null node
            else if (root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            // case 3 has 2 non null nodes

            Node iS = immediateSuccessor(root.right);
            root.data=iS.data;
            root.right=delete(root.right, iS.data);
        }
        return root;
    }

    private static Node immediateSuccessor(Node root) {
        while(root.left!=null){
            root=root.left;

        }
        return root;
    }

    public static void printInRange(Node root, int x, int y){

        if(root==null){
            return;
        }

        if(x<=root.data && root.data<=y){
            System.out.println(root.data+" ");
            printInRange(root.left,x,y);
            printInRange(root.right,x,y);
        }

        else if(root.data<x){
            printInRange(root.right,x,y);
        }
        else if(root.data>y){
            printInRange(root.left,x,y);
        }

    }

    public static void pathRoot2Leaf(Node root, ArrayList<Integer> path){
        if(root==null){
            return;
        }

        path.add(root.data);

        if(root.left==null && root.right==null){
            printPath(path);
        }
        else {
            pathRoot2Leaf(root.left,path);
            pathRoot2Leaf(root.right,path);
        }

        path.remove(path.size()-1);
    }

    public static void printPath(ArrayList<Integer> path) {
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] node ={8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<node.length;i++){
            root= buildTree(root,node[i]);
        }
        inOrder(root);
       // delete(root, 5);
        System.out.println();
        //inOrder(root);
        //printInRange(root,10,20);
        pathRoot2Leaf(root, new ArrayList<>());
    }
}
