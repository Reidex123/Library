package Learning;

import java.util.*;

public class linkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public linkedList() {
        this.head = null;
        this.size = 0;
    }


    @Override
    public Iterator<T> iterator() {
        return new listIterator(this);
    }

    private class listIterator implements Iterator<T> {
        Node<T> current;

        public listIterator(linkedList<T> list) {
            current = list.head;
        }

        @Override
        public boolean hasNext() {
            return current.getLink() != null;
        }

        @Override
        public T next() {
            T data = null;

            if (hasNext()) {
                current = current.getLink();
                data = current.getData();
            } else {
                System.out.println("The list does not have the next element!!");
            }

            return data;
        }
    }

    // add an element at the end of the list
    public void add(T data) {
        Node<T> node = new Node<>(data);

        if (this.isEmpty()) {
            head = node;
            this.size++;
            return;
        }

        Node<T> current = head;
        while (current.getLink() != null) {
            current = current.getLink();
        }

        node.setLink(current.getLink());
        current.setLink(node);
        this.size++;
    }

    // add an element at the start of the list
    public void addFirst(T data) {

        if (this.isEmpty()) {
            this.add(data);
            return;
        }

        Node<T> node = new Node<>(data);

        node.setLink(head);
        head = node;

        this.size++;

    }

    public void addLast(T data) {
        if (this.isEmpty()) {
            this.add(data);
            return;
        }

        Node<T> node = new Node<>(data);

        Node<T> current = head;

        while (current.getLink() != null) {
            current = current.getLink();
        }

        current.setLink(node);

        this.size++;
    }

    public void addAt(int index, T data) {
        if (index == 0) {
            addFirst(data);
            this.size++;
            return;
        }

        Node<T> node = new Node<>(data);

        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getLink();
        }

        node.setLink(current.getLink());
        current.setLink(node);
        this.size++;

    }

    public void remove(int index) {
        if (isEmpty()) {
            System.out.printf("The list has " + this.getSize() + " elements.");
            Runtime.getRuntime().exit(0);
        }

        if (index < 0 || index >= this.size) {
            System.out.println("Index out of Bounds");
            Runtime.getRuntime().exit(0);
        }

        if (index == 0) {
            head = head.getLink();
            this.size--;
            return;
        }

        Node<T> current = head;
        Node<T> nodeToDelete;
        for (int i = 0; i < index - 1; i++) {
            current = current.getLink();
        }

        nodeToDelete = current.getLink();
        current.setLink(nodeToDelete.getLink());

        nodeToDelete.setLink(null);

        this.size--;
    }

    public boolean contains(T data) {
        if (isEmpty()) {
            return false;
        }

        Node<T> current = head;

        for (int i = 0; i < this.size; i++) {
            if (current.getData() == data) {
                return true;
            }

            current = current.getLink();
        }
        return false;
    }

    public T get(int index) {
        if (index == 0) {
            return head.getData();
        }
        if (index >= this.size || index < 0) {
            System.out.println("Index out of bounds");
            Runtime.getRuntime().exit(0);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getLink();
        }

        return current.getData();
    }

    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "The list is empty!!";
        }
        StringBuilder list = new StringBuilder();
        Node<T> current = head;

        list.append("[ ");
        for (int i = 0; i < this.getSize() - 1; i++) {
            list.append(current.getData()).append(", ");
            current = current.getLink();
        }
        list.append(current.getData()).append(" ]");

        return list.toString();
    }
}
