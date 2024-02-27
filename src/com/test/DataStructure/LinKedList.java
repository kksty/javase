package com.test.DataStructure;

public class LinKedList<E> {

    private final Node<E> head = new Node<>(null);
    private int size = 0;

    public void add(E elemment, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        Node<E> prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node<E> node = new Node<>(elemment);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index < size - 1)
            throw new IndexOutOfBoundsException();
        Node<E> prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        E e = prev.next.element;
        prev.next = prev.next.next;
        return e;
    }

    public E get(int index) {
        if (index < 0 || index < size - 1)
            throw new IndexOutOfBoundsException();
        Node<E> node = head;
        while (index-- >= 0) {
            node = node.next;
        }
        return node.element;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<E> node = head.next;
        while (node != null) {
            str.append(node.element).append(" ");
            node = node.next;
        }
        return str.toString();

    }

    private static class Node<E> {
        private final E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    public static void main(String[] args) {
        LinKedList<String> list = new LinKedList<>();
        list.add("123", 0);
        list.add("456", 1);
        System.out.println(list.remove(1));
        System.out.println(list.toString());

    }

}