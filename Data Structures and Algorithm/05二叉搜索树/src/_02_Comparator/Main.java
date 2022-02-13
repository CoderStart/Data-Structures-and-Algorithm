package _02_Comparator;

public class Main {
    // 内部类
    private static class PersonComparator1 implements Comparator<Person> {
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }

    public static void main(String[] args) {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        // 内部类
        BST<Person> bst1 = new BST<>(new PersonComparator1());
        for (int i = 0; i < data.length; i++) {
            bst1.add(new Person(data[i]));
        }

        System.out.println(bst1);

        // 匿名内部类
        BST<Person> bst2 = new BST<>(new Comparator<Person>() {
            @Override
            public int compare(Person e1, Person e2) {
                return e2.getAge() - e1.getAge();
            }
        });

        for (int i = 0; i < data.length; i++) {
            bst2.add(new Person(data[i]));
        }

        System.out.println(bst2);

    }
}


