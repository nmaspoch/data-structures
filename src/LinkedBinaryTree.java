import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedBinaryTree<T> {
    private BinaryTreeNode<T> root;
    private int size;

    public LinkedBinaryTree() {
        root = null;
        size = 0;
    }

    public BinaryTreeNode<T> find(T key) {
        return findNode(root, key);
    }

    private BinaryTreeNode<T> findNode(BinaryTreeNode<T> rootNode, T key) {
        if (rootNode == null)
            return null;

        @SuppressWarnings("unchecked")
        Comparable<T> item = (Comparable<T>) key;

        if (item.compareTo(rootNode.getData()) == 0)
            return rootNode;

        else if (item.compareTo(rootNode.getData()) < 0)
            return findNode(rootNode.getLeft(), key);

        else
            return findNode(rootNode.getRight(), key);
    }

    public void insert(T key) {
        insertNode(root, key);
        size += 1;
    }

    private void insertNode(BinaryTreeNode<T> rootNode, T key) {
        @SuppressWarnings("unchecked")
        Comparable<T> item = (Comparable<T>) key;

        if (root == null) {
            root = new BinaryTreeNode<T>(key);
            return;
        }

        if (item.compareTo(rootNode.getData()) < 0) {
            if (rootNode.getLeft() == null) {
                BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(key);
                rootNode.setLeft(newNode);
                newNode.setParent(rootNode);
            } else
                insertNode(rootNode.getLeft(), key);
        } else {
            if (rootNode.getRight() == null) {
                BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(key);
                rootNode.setRight(newNode);
                newNode.setParent(rootNode);
            } else
                insertNode(rootNode.getRight(), key);
        }
    }

    public void delete(T key) {
        deleteNode(root, key);
    }

    private void deleteNode(BinaryTreeNode<T> rootNode, T key) {
        if (root == null)
            return;

        BinaryTreeNode<T> nodeToDelete = find(key);

        if (nodeToDelete != null) {
            BinaryTreeNode<T> parent = nodeToDelete.getParent();

            // Node has no children
            if (nodeToDelete.isLeaf()) {
                if (nodeToDelete.isLeftChild())
                    parent.setLeft(null);
                else
                    parent.setRight(null);
                size -= 1;
            }
            // Node has two children
            else if (nodeToDelete.isComplete()) {
                BinaryTreeNode<T> min = findMinNode(nodeToDelete.getRight());
                delete(min.getData());
                nodeToDelete.setData(min.getData());
            }
            // Node has one child
            else {
                BinaryTreeNode<T> child;
                if (nodeToDelete.hasOnlyLeftChild())
                    child = nodeToDelete.getLeft();
                else
                    child = nodeToDelete.getRight();
                if (nodeToDelete.isLeftChild())
                    parent.setLeft(child);
                else
                    parent.setRight(child);
                child.setParent(parent);
                size -= 1;
            }
            nodeToDelete.setParent(null);
        }
    }

    public BinaryTreeNode<T> findMin()
    {
        var min = findMinNode(root);
        return min;
    }

    private BinaryTreeNode<T> findMinNode(BinaryTreeNode<T> root) {
        if (root == null)
            return null;

        BinaryTreeNode<T> min = root;

        while (min.getLeft() != null)
            min = min.getLeft();
        return min;
    }

    public BinaryTreeNode<T> findMax()
    {
        var max = findMaxNode(root);
        return max;
    }

    private BinaryTreeNode<T> findMaxNode(BinaryTreeNode<T> root) {
        if (root == null)
            return null;

        BinaryTreeNode<T> max = root;

        while (max.getRight() != null)
            max = max.getRight();
        return max;
    }

    public String toString() {
        String output = "";
        List<Integer> items = new ArrayList<Integer>();
        getItems(root, items);

        Iterator<Integer> iterator = items.iterator();

        while (iterator.hasNext()) {
            output += iterator.next() + " ";
        }
        return output.trim();
    }

    private void getItems(BinaryTreeNode<T> root, List<Integer> items) {
        if (root != null) {
            getItems(root.getLeft(), items);
            items.add((Integer) root.getData());
            getItems(root.getRight(), items);
        }
    }

    public int getSize() {
        return size;
    }
}
