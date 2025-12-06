package Singly_LinkedList;
public class Node<T> {
    private T data;
    private Node<T> link;

    public Node(T data) {
        this.data = data;
        this.link = null;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getLink() {
        return this.link;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLink(Node<T> link) {
        this.link = link;
    }
}