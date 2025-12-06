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
        for (int i = 0; i < this.getSize(); i++) {
            list.append(current.data).append(", ");
            current = current.next;
        }
        list.append(" ]");

        return list.toString();
    }
}