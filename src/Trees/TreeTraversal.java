package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

    public static class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static class BinaryTree{

        int ind=-1;
        public Node BuildTree(int[] nodes){
            ind++;

            if(nodes[ind]==-1){
                return null;
            }

            Node newNode = new Node(nodes[ind]);
            newNode.left=BuildTree(nodes);
            newNode.right=BuildTree(nodes);

            return newNode;

        }
    }

    public static void preOrder(Node root){
        if(root==null){
            return;
        }

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root ==null){
            return;
        }

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public static  void postOrder(Node root){
        if(root==null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            Node currentNode= queue.remove();
            if(currentNode==null){
                System.out.println();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }else{
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
                System.out.print(currentNode.data+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,3,-1,-1,4,-1,-1,5,-1,-1};
        Node root = new BinaryTree().BuildTree(nodes);

        //System.out.println(root.data);
        preOrder(root);
        //inOrder(root);
        //postOrder(root);
        //levelOrder(root);
    }
}
