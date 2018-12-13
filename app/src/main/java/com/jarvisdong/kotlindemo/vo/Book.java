package com.jarvisdong.kotlindemo.vo;

/**
 * Created by JarvisDong on 2018/12/12.
 * OverView:
 */

public class Book {
    private int id;
    private String bookName;
    private String bookDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }
}
