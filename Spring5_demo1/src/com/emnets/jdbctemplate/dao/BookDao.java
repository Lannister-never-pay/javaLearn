package com.emnets.jdbctemplate.dao;

import com.emnets.jdbctemplate.entity.Book;

import java.util.List;

public interface BookDao {
    void addBook(Book book);

    void updateBook(Book book);

    void delete(String id);

    int selectCount();

    Book selectById(String id);

    List<Book> selectBooks();

    void batchAdd(List<Object[]> batchArgs);

    void batchUpdate(List<Object[]> batchArgs);

    void batchDelete(List<Object[]> batchArgs);
}
