package Learning;

public class Node<T> {
    private Node<T> link;
    private T data;

    public Node() {
        this.link = null;
        this.data = null;
    }

    public Node(T data) {
        this.data = data;
        this.link = null;
    }

    public Node<T> getLink() {
        return this.link;
    }

    public T getData() {
        return data;
    }

    public void setLink(Node<T> link) {
        this.link = link;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return (this.data).toString();
    }

}
