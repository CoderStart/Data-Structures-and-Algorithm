package _04_CircleDeque;

public class Main {
    public static void main(String[] args) {
        CircleDeque<Integer> queue = new CircleDeque<Integer>();

        for (int i = 0; i < 10; i++) {
            queue.enQueueFront(i + 1);
            queue.enQueueRear(i + 100);
        }

        // [8, 7, 6, 5, 4, 3, 2, 1, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, null, null, 10, 9]

        for (int i = 0; i < 3; i++) {
            queue.deQueueFront();
            queue.deQueueRear();
        }

        queue.enQueueFront(11);
        queue.enQueueFront(12);

        System.out.println(queue);
        // [11, 7, 6, 5, 4, 3, 2, 1, 100, 101, 102, 103, 104, 105, 106, null, null, null, null, null, null, 12]

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueueFront());
        }
    }
}
