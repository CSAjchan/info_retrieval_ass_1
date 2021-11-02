import java.util.ArrayList;
import java.util.List;

//class containing children of the current node(left, right)
//and the value of the node
public class DAGNode {
    int key;
    List<DAGNode> children;

    //initialising a node with its value and initialising its children as null
    public DAGNode(int item){
        key = item;
        children = new ArrayList<>();
    }
}
