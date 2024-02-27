package com.test.DataStructure;

public class ArrayList<E> {

    private int size = 0;
    private int capacity = 10;
    private Object[] array = new Object[capacity];

    public void add(E element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size >= capacity) {
            int newCapacity = capacity + (capacity >> 1); // 扩容为原来的1.5倍
            Object[] newarray = new Object[newCapacity];
            System.arraycopy(array, 0, newarray, 0, size);
            array = newarray;
            capacity = newCapacity;
        }
        for (int i = size; i > index; i--)
            array[i] = array[i - 1];
        array[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException();
        E e = (E) array[index];
        for (int i = index; i < size; i++)
            array[i] = array[i + 1];
        size--;
        return e;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException();
        return (E) array[index];
    }

    public String result() {
        System.out.println(capacity);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {
            str.append(array[i]).append(" ");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A", 0);
        list.add("B", 1);
        list.add("C", 2);
        System.out.println("删除" + list.remove(1));
        System.out.println("获取" + list.get(0));
        System.out.println(list.result());
    }

}
