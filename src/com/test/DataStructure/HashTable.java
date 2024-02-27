package com.test.DataStructure;

public class HashTable<E> {

    private final int TABLE_SIZE = 10;
    private final Object[] table = new Object[TABLE_SIZE];

    public void insert(E obj) {
        int index = hash(obj);
        table[index] = obj;
    }

    public boolean contains(E obj) {
        int index = hash(obj);
        return table[index] == obj;
    }

    private int hash(E obj) {
        return obj.hashCode() % TABLE_SIZE;
    }

    public static void main(String[] args) {
        HashTable<String> table = new HashTable<>();
        table.insert("abcd");
        System.out.println(table.contains("abcd"));
    }
}
