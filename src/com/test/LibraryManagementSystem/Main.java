package com.test.LibraryManagementSystem;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Main
 */
class Main {

    private static List<Book> LIST;

    public static void main(String[] args) {
        System.out.println("正在初始化数据...");
        load();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("======== 图书管理系统 ==========");
            System.out.println("1.录入书籍信息");
            System.out.println("2.查询书籍信息");
            System.out.println("3.删除书籍信息");
            System.out.println("4.修改书籍信息");
            System.out.println("5.退出系统");
            System.out.println("================================");
            switch (scanner.nextInt()) {
                case 1:
                    insert(scanner);
                    break;
                case 2:
                    query();
                    break;
                case 3:
                    delete(scanner);
                    break;
                case 4:
                    modify(scanner);
                    break;
                case 5:
                    System.out.println("正在保存数据...");
                    save();
                    System.out.println("感谢使用！");
                    return;
            }

        }
    }

    private static void save() {
        try (ObjectOutputStream put = new ObjectOutputStream(new FileOutputStream("Book.txt"))) {
            put.writeObject(LIST);
            put.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private static void load() {
        File file = new File("Book.txt");
        if (file.exists()) {
            try (ObjectInputStream get = new ObjectInputStream(new FileInputStream(file))) {
                LIST = (List<Book>) get.readObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            LIST = new LinkedList<>();
        }
    }

    private static void insert(Scanner scanner) {
        scanner.nextLine();
        System.out.print("请输入书籍的标题：");
        String title = scanner.nextLine();
        System.out.print("请输入作者信息：");
        String author = scanner.nextLine();
        System.out.print("请输入书籍的价格：");
        int price = scanner.nextInt();
        scanner.nextLine();
        Book book = new Book(title, author, price);
        LIST.add(book);
        System.out.println("书籍添加成功：" + book);
    }

    private static void query() {
        for (int i = 0; i < LIST.size(); i++) {
            System.out.println(i + "." + LIST.get(i));
        }
    }

    private static void delete(Scanner scanner) {
        scanner.nextLine();
        System.out.println("请输入要删除的书籍的序号：");
        int index = scanner.nextInt();
        scanner.nextLine();
        while (index < 0 || index >= LIST.size()) {
            System.out.println("输入有误，请重新输入");
            index = scanner.nextInt();
            scanner.nextLine();
        }
        LIST.remove(index);
        System.out.println("删除成功");
    }

    private static void modify(Scanner scanner) {
        scanner.nextLine();
        System.out.println("请输入要修改的书籍的序号：");
        int index = scanner.nextInt();
        scanner.nextLine();
        while (index < 0 || index >= LIST.size()) {
            System.out.println("输入有误，请重新输入");
            index = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.print("请输入书籍的标题：");
        String title = scanner.nextLine();
        System.out.print("请输入作者信息：");
        String author = scanner.nextLine();
        System.out.print("请输入书籍的价格：");
        int price = scanner.nextInt();
        scanner.nextLine();
        Book book = new Book(title, author, price);
        LIST.set(index, book);
        System.out.println("修改成功：" + book);
    }
}