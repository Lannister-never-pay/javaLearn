package com.emnets.jdbctemplate.service;

import com.emnets.jdbctemplate.dao.BookDao;
import com.emnets.jdbctemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lannisite
 * @program BookService
 * @description 描述
 * @date 2023/2/15 23:01
 */

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    public void updateBook(Book book){
        bookDao.updateBook(book);
    }

    public void deleteBook(String id){
        bookDao.delete(id);
    }

    public int selectCount(){
        return bookDao.selectCount();
    }

    public Book selectById(String id){
        return bookDao.selectById(id);
    }

    public List<Book> selectAll(){
        return bookDao.selectBooks();
    }

    public void batchAdd(List<Object[]> batchArgs){
        bookDao.batchAdd(batchArgs);
    }

    public void batchUpdate(List<Object[]> batchArgs){
        bookDao.batchUpdate(batchArgs);
    }

    public void batchDelete(List<Object[]> batchArgs){
        bookDao.batchDelete(batchArgs);
    }

}
