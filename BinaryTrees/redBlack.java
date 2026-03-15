package BinaryTrees;

public class redBlack<T extends Comparable<T>> {

    public treeNode<T> root;


    public void insert(T data) {

        this.root = this.insert(data, root);

    }

    private treeNode<T> insert(T data, treeNode<T> node) {
        if (node == null) {
            return new treeNode<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = this.insert(data, node.left);
        } else if (data.compareTo(node.data) > 0) {
            node.right = this.insert(data, node.right);
        }

        return this.balance(node);

    }

    private treeNode<T> balance(treeNode<T> node) {

    }

}