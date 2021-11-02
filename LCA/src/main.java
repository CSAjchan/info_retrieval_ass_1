public class main {
   public static void main(String[] args)
    {
        /* Let us create following BST
              50
            /    \
           /      \
         30        70
        /   \     /   \
      20     40  60    80
      /  \      /        \
     15   25   55         90
       */

        /*
        DAG tree = new DAG();

        DAGNode node = new DAGNode(50);
        tree.insert(node);

        DAGNode parentNode = node;
        node = new DAGNode(30);
        DAGNode parentNode2 = node;
        tree.insert(parentNode, node);

        node = new DAGNode(70);
        tree.insert(parentNode, node);
        parentNode = node;

        node = new DAGNode(20);
        tree.insert(parentNode2, node);
        DAGNode parentNode3 = node;
        node = new DAGNode(40);
        tree.insert(parentNode2, node);

        node = new DAGNode(60);
        tree.insert(parentNode, node);
        DAGNode parentNode4 = node;

        DAGNode newParentNode = new DAGNode(1000);
        tree.insert(newParentNode);
        node = new DAGNode(80);
        tree.insert(parentNode, node);
        tree.insert(newParentNode, node);
        DAGNode parentNode5 = node;
        node = new DAGNode(500);
        tree.insert(newParentNode, node);

        node = new DAGNode(15);
        tree.insert(parentNode3, node);
        node = new DAGNode(25);
        tree.insert(parentNode3, node);

        node = new DAGNode(55);
        tree.insert(parentNode4, node);

        node = new DAGNode(90);
        tree.insert(parentNode5, node);

        System.out.println("LCA(20, 40): " + tree.findLCA(20,40).get(1));
        System.out.println("LCA(80, 20): " + tree.findLCA(80,20).get(0));
        System.out.println("LCA(30, 80): " + tree.findLCA(30,80).get(0));
        System.out.println("LCA(60, 80): " + tree.findLCA(60,80).get(1));
        System.out.println("LCA(80,500): " + tree.findLCA(80,500).get(0));
        */

    }

}

