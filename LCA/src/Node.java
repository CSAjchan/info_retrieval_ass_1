//class containing children of the current node(left, right)
//and the value of the node
public class Node {
    int key;
    Node left, right;

    //initialising a node with its value and initialising its children as null
    public Node(int item){
        key = item;
        left = right = null;
    }
}
