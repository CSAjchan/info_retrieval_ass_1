import java.util.ArrayList;
import java.util.List;

//class which creates the binary tree
public class DAG {
    //Root which holds all the nodes which are parents but not children, so it's easier to traverse
    DAGNode root = new DAGNode(Integer.MIN_VALUE);

    //constructor which initialises the binary tree(with its root)
    void insert(DAGNode parent){

        root.children.add(parent);
    }

    void insert(DAGNode parent, DAGNode child){

        parent.children.add(child);
    }

    private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();

    //Together with findLCAInternal finds the path from
    //root node to given root of the tree
    List<Integer> findLCA(int n1, int n2){
        path1.clear();
        path2.clear();
        return findLCAInternal(root, n1, n2);
    }

    private List<Integer> findLCAInternal(DAGNode root, int n1, int n2){
        List<Integer> parentsFound = new ArrayList();

        boolean pathsFound = false;
        for(int i = 0; i < root.children.size(); i++) {
            if (findPath(root.children.get(i), n1, path1) && findPath(root.children.get(i), n2, path2)) {
                pathsFound = true;
            }
        }
        if(pathsFound == false){
            parentsFound.add(-1);
            return parentsFound;
        }

        for(int i = 0; i <path1.size(); i++){
            for(int j = 0; j < path2.size(); j++) {
                if (path1.get(i).equals(path2.get(j))) {
                    parentsFound.add(path1.get(i));
                    break;
                }
            }
        }
        return parentsFound;
    }

    //Finds the path from root to given root of the tree, Stores the path
    //in a vector path[], returns true if path exists otherwise false
    private boolean findPath(DAGNode root, int n, List<Integer>path){

        //base case
        if(root == null){
            return false;
        }

        //Store this node.
        path.add(root.key);

        if(root.key == n){
            return true;
        }

        for(int i = 0; i < root.children.size(); i++){
            if(root.children.get(i) != null && findPath(root.children.get(i), n, path)){
                return true;
            }
        }

        //If not present in subtree rooted with root, remove root from
        //path[] and return false
        path.remove(path.size()-1);

        return false;
    }

}
