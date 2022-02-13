package Stack;

public class LinkedList<E> extends AbstractList<E> {
    private Node<E> first; // 指向第一个元素结点
    private Node<E> last; // 指向最后一个元素结点

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;
        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            if (prev != null) {
                sb.append(prev.element);
            } else {
                sb.append("null");
            }

            sb.append("_").append(element).append("_");

            if (next != null) {
                sb.append(next.element);
            } else {
                sb.append("null");
            }

            return sb.toString();
        }
    }

    // 清除所有的元素
    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
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

        if (index == size) { // 在最后面添加元素
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, null);
            if (oldLast == null) { // 此时链表为空
                first = last;
            } else {
                oldLast.next = last;
            }
        } else {
            Node<E> next = nodeOf(index); // 待插入结点的下一个
            Node<E> prev = next.prev; // 待插入结点的上一个
            Node<E> node = new Node<>(prev, element, next);
            next.prev = node;
            if (prev == null) { // 等价于index==0，即在最前面添加元素
                first = node;
            } else {
                prev.next = node;
            }
        }

        size++;
    }

    // 删除指定索引处的元素，返回被删除的元素
    @Override
    public E remove(int index) {
        rangeCheck(index);

        Node<E> node = nodeOf(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) { // 等价于index==0
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) { // 等价于index==size-1
            last = prev;
        } else {
            next.prev = prev;
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

        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size = ").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) string.append(", ");
            string.append(node);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
