package Trees;

public class TreeHeight {

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

    public static int treeHeight(Node root){

        if(root==null){
            return 0;
        }

        if(root.left==null && root.right==null){
            return 0;
        }


        int leftHeight= treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        int height= Math.max(leftHeight,rightHeight);

        return height+1;
    }



    public static void main(String[] args) {
        int[] nodes = {1,2,3,-1,-1,4,-1,-1,5,-1,6,-8,-1,-1,-1};
        Node root = new BinaryTree().BuildTree(nodes);
        System.out.println(treeHeight(root));

    }

}
