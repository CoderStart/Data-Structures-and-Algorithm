package _03_CircleQueue;

public class Main {
    public static void main(String[] args) {
        CircleQueue<Integer> queue = new CircleQueue<Integer>();
        // 0 1 2 3 4 5 6 7 8 9
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }

        // null null null null null 5 6 7 8 9
        for (int i = 0; i < 5; i++) {
            queue.deQueue();
        }

        // 15 16 17 18 19 5 6 7 8 9
        for (int i = 15; i < 23; i++) {
            queue.enQueue(i);
        }

        System.out.println(queue);
        // [5, 6, 7, 8, 9, 15, 16, 17, 18, 19, 20, 21, 22, null, null]

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }
}
