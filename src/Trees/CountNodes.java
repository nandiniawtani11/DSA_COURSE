package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodes {

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

    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }

        int leftNodes= countNodes(root.left);
        int rightNode = countNodes(root.right);

        return leftNodes+rightNode+1;
    }

    public static Node invertTree(Node root) {

        if(root==null){
            return null;
        }

        if(root.left==null && root.right==null){
            return root;
        }

        Node leftNode = invertTree(root.left);
        Node rightNode = invertTree(root.right);

        if(leftNode==null){
            leftNode=rightNode;
            rightNode=null;
            return root;
        }

        if(rightNode==null){
            rightNode=leftNode;
            leftNode=null;
            return root;
        }

        Node temp = leftNode;
        root.left=rightNode;
        root.right=temp;

        return root;
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
        int[] nodes = {1,2,3,-1,-1,4,-1,-1,5,-1,6,-1,-1};
        Node root = new BinaryTree().BuildTree(nodes);
        //System.out.println(countNodes(root));
        levelOrder(root);
        Node invertedRoot= invertTree(root);
        System.out.println();
        levelOrder(invertedRoot);



    }

}
