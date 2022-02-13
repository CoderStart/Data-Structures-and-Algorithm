package _01_SingleLinkedList;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(20);
        list.add(0, 44);
        list.add(30);
        list.add(list.size(), 55);
        list.remove(1);
        System.out.println(list);

        List<Integer> list2 = new ArrayList<>();
        list2.add(20);
        list2.add(0, 44);
        list2.add(30);
        list2.add(list.size(), 55);
        list2.remove(1);
        System.out.println(list);
    }
}
