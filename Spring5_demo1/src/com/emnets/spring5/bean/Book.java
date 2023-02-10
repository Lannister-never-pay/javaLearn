package com.emnets.spring5.bean;

import java.util.List;

/**
 * @author lannisite
 * @program Book
 * @description 描述
 * @date 2023/2/9 16:38
 */

public class Book {

    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Book{" +
                "list=" + list +
                '}';
    }
}
