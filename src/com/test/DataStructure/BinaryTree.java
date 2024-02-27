package com.test.DataStructure;

public class BinaryTree {

    public static void main(String[] args) {
        TreeNode<Character> a = new TreeNode<Character>('A');
        TreeNode<Character> b = new TreeNode<Character>('B');
        TreeNode<Character> c = new TreeNode<Character>('C');
        TreeNode<Character> d = new TreeNode<Character>('D');
        TreeNode<Character> e = new TreeNode<Character>('E');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        System.out.println(a.right.element);

    }

    public static class TreeNode<E> {

        public E element;
        public TreeNode<E> left;
        public TreeNode<E> right;

        public TreeNode(E element)
        {
            this.element = element;
        }
    }
}
