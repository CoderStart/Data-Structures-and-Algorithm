package _01_ArrayListInt;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(99);
        list.add(88);
        list.add(77);
        list.add(66);
        list.add(55);
        list.set(4, 10);
        System.out.println(list);

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        Asserts.test(list.get(4) == 10);
    }
}
