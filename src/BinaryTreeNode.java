public class BinaryTreeNode<T> {
    private T dataItem;
    private BinaryTreeNode<T> parent, left, right;

    public BinaryTreeNode()
    {
        dataItem = null;
        parent = null;
        left = null;
        right = null;
    }

    public BinaryTreeNode(T data)
    {
        dataItem = data;
        parent = null;
        left = null;
        right = null;
    }

    public T getData()
    {
        return dataItem;
    }

    public BinaryTreeNode<T> getParent()
    {
        return parent;
    }

    public BinaryTreeNode<T> getLeft()
    {
        return left;
    }

    public BinaryTreeNode<T> getRight()
    {
        return right;
    }

    public void setData(T data)
    {
        dataItem = data;
    }

    public void setParent(BinaryTreeNode<T> dataItem)
    {
        parent = dataItem;
    }

    public void setLeft(BinaryTreeNode<T> dataItem)
    {
        left = dataItem;
    }

    public void setRight(BinaryTreeNode<T> dataItem)
    {
        right = dataItem;
    }

    public Boolean isLeaf()
    {
        return left == null && right == null;
    }

    public Boolean isComplete()
    {
        return left != null && right != null;
    }

    public Boolean isLeftChild()
    {
        if (parent == null)
            return false;

        var leftChild = parent.getLeft();
        if (leftChild == null)
            return false;
        return ((Comparable<T>)leftChild.getData()).compareTo(dataItem) == 0;
    }

    public Boolean isRightChild()
    {
        if (parent == null)
            return false;

        var rightChild = parent.getRight();
        if (rightChild == null)
            return false;
        return ((Comparable<T>)rightChild.getData()).compareTo(dataItem) == 0;
    }

    public Boolean hasOnlyLeftChild()
    {
        return left != null && right == null;
    }

    public Boolean hasOnlyRightChild()
    {
        return left == null && right != null;
    }


    
}
