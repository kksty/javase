package com.test.LibraryManagementSystem;

import java.io.Serializable;

class Book implements Serializable {

    private String title;
    private String author;
    private int price;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "书名：《" + title + "》, 作者：" + author + ", 价格：" + price + "元";
    }

}
