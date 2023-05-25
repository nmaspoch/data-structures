import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LinkedBinaryTreeTest {
    @Test
    public void testInsert() {
        // Arrange
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
        // Act
        tree.insert(10);
        tree.insert(7);
        tree.insert(12);
        tree.insert(5);
        tree.insert(6);
        tree.insert(20);
        tree.insert(21);
        // Assert
        assertEquals(7, tree.getSize());
        assertEquals("5 6 7 10 12 20 21", tree.toString());
    }

    @Test
    public void testFind() {
        // Arrange
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
        // Act
        tree.insert(10);
        tree.insert(7);
        tree.insert(12);
        tree.insert(5);
        tree.insert(6);
        tree.insert(20);
        tree.insert(21);

        int value = tree.find(6).getData();
        // Assert
        assertEquals(value, 6);
    }

    @Test
    public void testDeleteRightLeaf() {
        // Arrange
        var tree = generateTree();
        // Act
        tree.delete(132);
        // Assert
        assertEquals(8, tree.getSize());
        assertEquals(null, tree.find(132));
        assertEquals(null, tree.find(130).getLeft());
        assertEquals(null, tree.find(130).getRight());
    }

    @Test
    public void testDeleteLeftLeaf() {
        // Arrange
        var tree = generateTree();
        // Act
        tree.delete(92);
        // Assert
        assertEquals(8, tree.getSize());
        assertEquals(null, tree.find(92));
        assertEquals(null, tree.find(95).getLeft());
        assertEquals(null, tree.find(95).getRight());
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        // Arrange
        var tree = generateTree();
        // Act
        tree.delete(130);
        // Assert
        assertEquals(8, tree.getSize());
        assertEquals(null, tree.find(130));
        assertEquals(true, tree.find(125).isComplete());
        assertEquals(110, (long) tree.find(125).getLeft().getData());
        assertEquals(132, (long) tree.find(125).getRight().getData());
    }

    @Test
    public void testDeleteCompleteNode() {
        // Arrange
        var tree = generateTree();
        // Act
        tree.delete(90);
        // Assert
        assertEquals(8, tree.getSize());
        assertEquals(null, tree.find(90));
        assertEquals("80 92 95 100 110 125 130 132", tree.toString());
    }

    @Test
    public void testFindMin() {
        // Arrange
        var tree = generateTree();
        // Act
        var min = tree.findMin();
        // Assert
        assertEquals(80, (long) min.getData());
    }

    @Test
    public void testFindMax() {
        // Arrange
        var tree = generateTree();
        // Act
        var max = tree.findMax();
        // Assert
        assertEquals(132, (long) max.getData());
    }

    private LinkedBinaryTree<Integer> generateTree() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();

        tree.insert(100);
        tree.insert(90);
        tree.insert(80);
        tree.insert(95);
        tree.insert(92);
        tree.insert(125);
        tree.insert(110);
        tree.insert(130);
        tree.insert(132);

        return tree;
    }
}