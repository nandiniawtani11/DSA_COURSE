package Trees;

public class TreeDiameter {

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

    public static class TreeInfo{
        int ht;
        int diam;
        public TreeInfo(int ht, int diam){
            this.ht=ht;
            this.diam=diam;
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

    public static TreeInfo treeDiameter(Node root){
        if(root==null){
            return new TreeInfo(0,0);
        }

        TreeInfo leftNode= treeDiameter(root.left);
        TreeInfo rightNode = treeDiameter(root.right);

        int myheight= Math.max(leftNode.ht,rightNode.ht)+1;

        int diam1= leftNode.diam;
        int diam2= rightNode.diam;
        int diam3= leftNode.ht+rightNode.ht+1;

        int mydiam =Math.max(Math.max(diam1,diam2),diam3);

        return new TreeInfo(myheight,mydiam);

    }


    public static void main(String[] args) {
        int[] nodes = {1,2,3,-1,-1,4,-1,-1,5,-1,6,-8,-1,-1,-1};
        Node root = new BinaryTree().BuildTree(nodes);
        System.out.println(treeDiameter(root).diam);

    }


}
