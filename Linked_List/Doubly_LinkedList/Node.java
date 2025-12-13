/**
 * Blueprint of a node object
 * @author Koketso Gaowelwe
 * 2025/12/01
 */

package Doubly_LinkedList;

public class Node<T> {
    public T data;
    public Node<T> next, prev;

    public Node() {
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public Node<T> getPrev() {
        return this.prev;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    // String representation of the data held by the node
    @Override
    public String toString() {
        if (this.getData() != null) {
            return (String) this.data;
        }
        return null;
    }
}
