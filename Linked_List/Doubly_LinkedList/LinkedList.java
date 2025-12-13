package Doubly_LinkedList;

import java.util.*;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(T data) {
        if (data == null) {
            return;
        }

        Node<T> node = new Node<>(data);
        if (this.head == null) {
            this.head = node;
            this.size++;
            return;
        }

        Node<T> current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        node.prev = current;

        this.size++;
    }

    public void addFirst(T data) {
        if (data == null) {
            return;
        }

        if (this.size == 0) {
            add(data);
            Runtime.getRuntime().exit(0);
        }

        Node<T> node = new Node<>(data);

        (this.head).prev = node;
        node.next = head;
        head = node;

        this.size++;

    }

    public void addLast(T data) {
        this.add(data);
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public void addAt(int index, T data) throws IndexOutOfBoundsException {

        if (index < 0 || index > this.getSize()) {
            throw new IndexOutOfBoundsException("Operation cannot be performed.");
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == this.getSize()) {
            addLast(data);
            return;
        }

        Node<T> node = new Node<>(data);
        Node<T> current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        node.next = current.next;
        (current.next).prev = node;
        current.next = node;
        node.prev = current;

        this.size++;

    }

    public void delete(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size)
            throw new IndexOutOfBoundsException("Index specified is out of bound!!");

        if (index == 0) {
            deleteFirst();
        }

        if (index == this.getSize() - 1) {
            deleteLast();
            return;
        }

        Node<T> current = head;
        Node<T> nodeToDelete;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        nodeToDelete = current.next;
        current.next = nodeToDelete.next;
        (nodeToDelete.next).prev = current;

        nodeToDelete.next = null;
        nodeToDelete.prev = null;

        this.size--;

    }

    public void deleteFirst() {
        if (isEmpty()) {
            Runtime.getRuntime().exit(0);
        }

        head = head.next;
        head.prev = null;

        this.size--;
    }

    public void deleteLast() {
        if (isEmpty())
            Runtime.getRuntime().exit(0);

        Node<T> current = head;
        for (int i = 0; i < this.getSize() - 2; i++)
            current = current.next;

        (current.next).prev = null;
        current.next = null;

        this.size--;
    }

    public int indexOf(T data) {
        if (isEmpty()) {
            return -1;
        }

        Node<T> current = head;

        for (int i = 0; i < this.getSize(); i++) {
            if (current.data == data) {
                return i;
            }
            current = current.next;
        }

        return -1;

    }

    public boolean contains(T data) {
        if (isEmpty()) {
            return false;
        }
        return indexOf(data) >= 0 && indexOf(data) < this.getSize();
    }

    @Override
    public Iterator<T> iterator() {
        return new listIterator<>(this);
    }

    @SuppressWarnings(value = { "Unckecked", "hiding" })
    private class listIterator<T> implements Iterator<T> {

        Node<T> current;

        public listIterator(LinkedList<T> list) {
            current = list.head;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            T value;
            if (hasNext()) {
                value = current.data;
                current = current.next;

                return value;
            }

            return null;
        }
    }

    private boolean isEmpty() {
        return (getSize() == 0);
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        Node<T> current = head;

        if (this.getSize() == 0) {
            return null;
        }

        list.append("[ ");
        for (int i = 0; i < this.getSize() - 1; i++) {
            list.append(current.data).append(", ");
            current = current.next;
        }
        list.append(current.data).append(" ]");

        return list.toString();
    }
}
