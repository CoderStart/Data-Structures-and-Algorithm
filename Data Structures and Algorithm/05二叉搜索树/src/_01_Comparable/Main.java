package _01_Comparable;

public class Main {
    public static void main(String[] args) {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BST<Person> bst = new BST<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(new Person(data[i]));
        }

        System.out.println(bst);
    }
}


