package Linked_List;
public class linkedList<T> {
    private int size = 0;
    private Node<T> head;

    public void addLast(T data) {
        Node<T> node = new Node<T>(data);

        if (this.isEmpty()) {
            head = node;
        } else {
            Node<T> current = head;

            while (current.getLink() != null) {
                current = current.getLink();
            }

            current.setLink(node);
        }
        size++;
    }

    public void addFirst(T data) {
        if (this.isEmpty()) {
            this.addLast(data);
        }

        Node<T> node = new Node<T>(data);
        node.setLink(head);
        head = node;
        this.size++;
    }

    public void addAt(int index, T data) {
        if (index == 0) {
            this.addFirst(data);
            return;
        }

        Node<T> node = new Node<T>(data);
        Node<T> current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.getLink();
        }

        node.setLink(current.getLink());
        current.setLink(node);

        this.size++;
    }

    public void delete(int index) {
        if (this.isEmpty()) {
            System.out.println("There's nothing to delete!!");
            return;
        }
        if (index > this.size) {
            System.out.println("IndexOutOfBounds");
            return;
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

    public int getSize() {
        return size;
    }

    public String toString() {
        Node<T> node = head;

        StringBuilder formattedString = new StringBuilder();

        while (node.getLink() != null) {
            formattedString.append(node.getData()).append(" -> ");
            node = node.getLink();
        }
        formattedString.append(node.getData());

        return formattedString.toString();
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
