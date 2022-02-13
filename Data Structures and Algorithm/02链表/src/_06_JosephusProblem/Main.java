package _06_JosephusProblem;

public class Main {
    public static void main(String[] args) {
        josephus();
    }

    static void josephus() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= 8; i++) {
            list.add(i);
        }

        list.reset();

        while (!list.isEmpty()) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }
    }

}
