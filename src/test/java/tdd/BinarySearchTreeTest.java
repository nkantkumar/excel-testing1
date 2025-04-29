package tdd;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {


    @Test
    public void insertBST(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        assertTrue(bst.contains(10));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(15));
        assertFalse(bst.contains(100));
    }

    @Test
    public void testInorderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        assertEquals("5 10 15", bst.inorderTraversal());
    }
}
