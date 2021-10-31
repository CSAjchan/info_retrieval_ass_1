import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LCATest {

    @Test
    void testEmptyLCA() {
        LCA tree = new LCA();

        assertEquals(-1, tree.findLCA(20,40));
        assertEquals(-1, tree.findLCA(0,0));
        assertEquals(-1, tree.findLCA(15,100));
        assertEquals(-1, tree.findLCA(70,55));
    }

    @Test
    void testOneElementInLCA() {
        LCA tree = new LCA();

        tree.insert(50);

        assertEquals(50, tree.findLCA(50,50));
        assertEquals(-1, tree.findLCA(0,50));
        assertEquals(-1, tree.findLCA(50,100));
        assertEquals(-1, tree.findLCA(0,100));
    }

    @Test
    void testTwoElementInLCA() {
        LCA tree = new LCA();

        tree.insert(50);
        tree.insert(30);

        assertEquals(50, tree.findLCA(50,50));
        assertEquals(50, tree.findLCA(30,50));
        assertEquals(30, tree.findLCA(30,30));
        assertEquals(-1, tree.findLCA(0,50));
        assertEquals(-1, tree.findLCA(50,100));
        assertEquals(-1, tree.findLCA(0,100));
        assertEquals(-1, tree.findLCA(30,100));
    }

    @Test
    void testLCA(){

        //create binary tree with its root
        LCA tree = new LCA();

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
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(15);
        tree.insert(25);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(55);
        tree.insert(80);
        tree.insert(90);

        //if the numbers are in the tree
        assertEquals(30, tree.findLCA(20,40));
        assertEquals(50, tree.findLCA(80,20));
        assertEquals(50, tree.findLCA(30,80));
        assertEquals(70, tree.findLCA(60,80));
        assertEquals(30, tree.findLCA(15,40));
        assertEquals(70, tree.findLCA(55,90));
        //if the numbers come one after another in the tree
        assertEquals(80, tree.findLCA(80,90));
        assertEquals(50, tree.findLCA(30,50));
        assertEquals(30, tree.findLCA(30,25));
        //if one or two of the numbers are not in the tree
        assertEquals(-1, tree.findLCA(15,100));
        assertEquals(-1, tree.findLCA(35,70));
        assertEquals(-1, tree.findLCA(5,100));
        //if the same number is used twice
        assertEquals(50, tree.findLCA(50,50));
        //if the same number is used twice which is not in the tree
        assertEquals(-1, tree.findLCA(0,0));
    }

    //I know DAG test won't work as my Node only supports 2 branches to other Nodes
    //left and right, so I will have to change my Node class and insert class completely
    //after I have done that I can go on and make more tests to see if LCA works and
    //if not I can improve the solution as well
}
