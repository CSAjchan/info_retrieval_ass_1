public class LCA {
    public static void main(String[] args)
    {
        //create binary tree with its root
        BinaryTree tree = new BinaryTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("LCA(20, 40): " + tree.findLCA(20,40));
        System.out.println("LCA(80, 20): " + tree.findLCA(80,20));
        System.out.println("LCA(30, 80): " + tree.findLCA(30,80));
        System.out.println("LCA(60, 80): " + tree.findLCA(60,80));

    }

}
