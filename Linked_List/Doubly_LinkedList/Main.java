package Doubly_LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Size = " + list.getSize()); //Size = 3
        System.out.println(list.toString() + "\n"); //[ 1, 2, 3 ]

        list.addAt(2, 6);

        System.out.println("Size = " + list.getSize()); //4
        System.out.println(list.toString() + "\n"); //[ 1, 2, 6, 3 ]

        list.deleteFirst();

        System.out.println("Size = " + list.getSize()); // 3
        System.out.println(list.toString() + "\n"); //[ 2, 6, 3 ]

        list.deleteLast();

        System.out.println("Size = " + list.getSize()); // 2
        System.out.println(list.toString() + "\n"); // [ 2, 6 ]

        System.out.println(list.indexOf(6)); // 1

        System.out.println(list.contains(2)); //true
        System.out.println(list.contains(10) + "\n"); //false

        list.delete(1);

        System.out.println("Size = " + list.getSize()); // 1
        System.out.println(list.toString()); // [ 2 ]

    }
}
