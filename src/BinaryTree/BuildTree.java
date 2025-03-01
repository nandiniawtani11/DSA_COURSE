package BinaryTree;

import Trees.SumNodes;

public class BuildTree {

    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }


        public static Node buildTree(Node root,int val){
            if(root==null){
                root= new Node(val);
                return root;
            }

            if(root.data>val){
                root.left=buildTree(root.left,val);
            }

            else{
                root.right=buildTree(root.right,val);
            }

            return root;
        }

        public static boolean search(Node root, int val){

            if(root==null){
                return false;
            }

        if(root.data==val){
            return true;
        }

        if(root.data>val){
            return search(root.left,val);
        }
        else {
            return search(root.right,val);
        }
    }


    public static void inOrder(Node root){
        if(root ==null){
            return;
        }

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = {5,1,3,2,4,7};
        Node root =null;
        for(int i=0;i< nodes.length;i++){
            root=buildTree(root,nodes[i]);
        }

        //inOrder(root);

        System.out.println(search(root,50));
    }

}
