//class which creates the binary tree
public class BinaryTree {
    //Root of the binary tree
    Node root;

    //constructor which initialises the binary tree(with its root)
    BinaryTree(int key){
        root = new Node(key);
    }

    //constructor just to initialise the binary tree
    BinaryTree(){
        root = null;
    }
}
