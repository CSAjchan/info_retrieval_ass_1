import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DAGLCATest {

    @Test
    void testEmptyDAGLCA() {
        DAG tree = new DAG();

        assertEquals(-1, tree.findLCA(20,40).get(0));
        assertEquals(-1, tree.findLCA(0,0).get(0));
        assertEquals(-1, tree.findLCA(15,100).get(0));
        assertEquals(-1, tree.findLCA(70,55).get(0));
    }

    @Test
    void testOneElementInDAGLCA() {
        DAG tree = new DAG();

        DAGNode node = new DAGNode(50);
        tree.insert(node);

        assertEquals(50, tree.findLCA(50,50).get(1));
        assertEquals(-1, tree.findLCA(0,50).get(0));
        assertEquals(-1, tree.findLCA(50,100).get(0));
        assertEquals(-1, tree.findLCA(0,100).get(0));
    }

    @Test
    void testTwoElementInDAGLCA() {
        DAG tree = new DAG();


        DAGNode node = new DAGNode(50);
        tree.insert(node);
        DAGNode parentNode = node;
        node = new DAGNode(30);
        tree.insert(parentNode, node);

        assertEquals(50, tree.findLCA(50,50).get(1));
        assertEquals(50, tree.findLCA(30,50).get(1));
        assertEquals(30, tree.findLCA(30,30).get(2));
        assertEquals(-1, tree.findLCA(0,50).get(0));
        assertEquals(-1, tree.findLCA(50,100).get(0));
        assertEquals(-1, tree.findLCA(0,100).get(0));
        assertEquals(-1, tree.findLCA(30,100).get(0));
    }

    @Test
    void testDAGLCA(){

        //create dag with its superRoot which holds all parent nodes which have no parents of their own
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

        node = new DAGNode(80);
        tree.insert(parentNode, node);
        DAGNode parentNode5 = node;

        node = new DAGNode(15);
        tree.insert(parentNode3, node);
        node = new DAGNode(25);
        tree.insert(parentNode3, node);

        node = new DAGNode(55);
        tree.insert(parentNode4, node);

        node = new DAGNode(90);
        tree.insert(parentNode5, node);

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

        //if the numbers are in the tree
        assertEquals(30, tree.findLCA(20,40).get(2));
        assertEquals(50, tree.findLCA(80,20).get(1));
        assertEquals(50, tree.findLCA(30,80).get(1));
        assertEquals(70, tree.findLCA(60,80).get(2));
        assertEquals(30, tree.findLCA(15,40).get(2));
        assertEquals(70, tree.findLCA(55,90).get(2));
        //if the numbers come one after another in the tree
        assertEquals(80, tree.findLCA(80,90).get(3));
        assertEquals(50, tree.findLCA(30,50).get(1));
        assertEquals(30, tree.findLCA(30,25).get(2));
        //if one or two of the numbers are not in the tree
        assertEquals(-1, tree.findLCA(15,100).get(0));
        assertEquals(-1, tree.findLCA(35,70).get(0));
        assertEquals(-1, tree.findLCA(5,100).get(0));
        //if the same number is used twice
        assertEquals(50, tree.findLCA(50,50).get(1));
        //if the same number is used twice which is not in the tree
        assertEquals(-1, tree.findLCA(0,0).get(0));
    }

}
