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
        System.out.print(list.toString()); //[ 2, 6, 3 ]
    }
}
