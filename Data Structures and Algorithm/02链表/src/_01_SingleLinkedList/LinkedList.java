package _01_SingleLinkedList;

public class LinkedList<E> extends AbstractList<E> {
    private Node<E> first; // 指向第一个元素结点

    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    // 清除所有的元素
    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    // 返回指定索引处的元素
    @Override
    public E get(int index) {
        return nodeOf(index).element;
    }

    // 修改指定索引处的元素，返回被修改的元素
    @Override
    public E set(int index, E element) {
        Node<E> node = nodeOf(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    // 在指定索引处插入指定的元素
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            Node<E> prev = nodeOf(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    // 删除指定索引处的元素，返回被删除的元素
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> prev = nodeOf(index - 1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    // 返回指定元素的索引
    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null)   return i;
                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element))   return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    // 返回index索引处的结点对象
    private Node<E> nodeOf(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size = ").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) string.append(", ");
            string.append(node.element);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
