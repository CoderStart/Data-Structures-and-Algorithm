package _02_ArrayListGenericity;

public class Main {
    public static void main(String[] args) {
        // ArrayList<Student> list1 = new ArrayList<>();
        // list1.add(new Student(18, "zhangsan"));
        // list1.add(new Student(20, "lisi"));
        // list1.add(new Student(22, "wangwu"));
        // System.out.println(list1);
        // list1.clear();
        // // 提醒JVM进行垃圾回收
        // System.gc();

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(99);
        list2.add(88);
        list2.add(77);
        list2.add(66);
        list2.add(55);
        System.out.println(list2);
        Asserts.test(list2.size() == 5);

        for (int i = 0; i < 50; i++) {
            list2.add(i);
        }

        for (int i = 0; i < 50; i++) {
            list2.remove(0);
        }

        System.out.println(list2);

        // ArrayList<Object> list3 = new ArrayList<>();
        // list3.add(10);
        // list3.add(new Student(10, "Jack"));
        // list3.add(22);
        // System.out.println(list3.indexOf(22));
    }
}
