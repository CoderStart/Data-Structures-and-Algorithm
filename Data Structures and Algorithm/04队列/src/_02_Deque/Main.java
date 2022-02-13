package _02_Deque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> queue = new Deque<Integer>();
        queue.enQueueFront(11);
        queue.enQueueFront(22);
        queue.enQueueRear(33);
        queue.enQueueRear(44);

        /* 尾  44  33   11  22 头 */

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueueRear());
        }
    }
}