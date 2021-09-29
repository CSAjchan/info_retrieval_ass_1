import java.util.ArrayList;
import java.util.List;

//class which creates the binary tree
public class BinaryTree {
    //Root of the binary tree
    Node root;

    //constructor just to initialise the binary tree
    BinaryTree(){
        root = null;
    }

    //constructor which initialises the binary tree(with its root)
    void insert(int key){
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key){

        //if tree is empty
        if(root == null){
            root = new Node(key);
            return root;
        }

        //otherwise
        if(key < root.key){
            root.left = insertRec(root.left, key);
        }
        else if(key > root.key){
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();

    //Together with findLCAInternal finds the path from
    //root node to given root of the tree
    int findLCA(int n1, int n2){
        path1.clear();
        path2.clear();
        return findLCAInternal(root, n1, n2);
    }

    private int findLCAInternal(Node root, int n1, int n2){
        if(!findPath(root,n1,path1)||!findPath(root,n2,path2)){
            return -1;
        }

        int i;
        for(i = 0; i <path1.size() && i < path2.size(); i++){
            if(!path1.get(i).equals(path2.get(i))){
                break;
            }
        }
        return path1.get(i-1);
    }

    //Finds the path from root to given root of the tree, Stores the path
    //in a vector path[], returns true if path exists otherwise false
    private boolean findPath(Node root, int n, List<Integer>path){

        //base case
        if(root == null){
            return false;
        }

        //Store this node.
        path.add(root.key);

        if(root.key == n){
            return true;
        }

        if(root.left != null && findPath(root.left, n, path)){
            return true;
        }

        if(root.right != null && findPath(root.right, n, path)){
            return true;
        }

        //If not present in subtree rooted with root, remove root from
        //path[] and return false
        path.remove(path.size()-1);

        return false;
    }

}
