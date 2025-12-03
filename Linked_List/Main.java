package Linked_List;
public class Main {
    public static void main(String[] args) {
        linkedList<Integer> list = new linkedList<>();

        for (int i = 1; i <= 10; i++) {
            list.addLast(i);
        }

        //System.out.println(list.toString());

        list.addFirst(20);
        list.addAt(3, 13);
        System.out.println(list.getSize());
        list.remove(0);

        System.out.println(list.toString());
        System.out.println(list.getSize());
    }
}