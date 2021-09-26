public class LCA {

    public static void main(String[] args)
    {
        //create binary tree with its root
        BinaryTree tree = new BinaryTree(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);

        /*System.out.println(tree.root.key);
        System.out.println(tree.root.left.key);
        System.out.println(tree.root.right.key);
        System.out.println(tree.root.left.left.key);*/
    }

}
