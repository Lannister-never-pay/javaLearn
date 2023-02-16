package com.emnets.jdbctemplate.test;

import com.emnets.jdbctemplate.entity.Book;
import com.emnets.jdbctemplate.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lannisite
 * @program TestBook
 * @description 描述
 * @date 2023/2/16 12:05
 */

public class TestBook {


    private static final BookService bookService;

    private static final Book book;

    private static List<Object[]> batchArgs;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean02.xml");
        bookService = context.getBean("bookService", BookService.class);
        book = new Book();
        batchArgs = new ArrayList<>();
    }


    @Test
    public void testAdd(){

        book.setUserName("book");
        book.setUserID("1");
        book.setuStatus("1");
        bookService.addBook(book);
    }

    @Test
    public void testUpdate(){
        book.setUserName("book");
        book.setUserID("1");
        book.setuStatus("2");
        bookService.updateBook(book);
    }

    @Test
    public void testDelete(){
        bookService.deleteBook("3");
    }

    @Test
    public void testSelect(){
        int i = bookService.selectCount();
        System.out.println(i);
    }

    @Test
    public void testSelectBook(){
        Book book = bookService.selectById("1");
        System.out.println(book);
    }

    @Test
    public void testSelectAll(){
        List<Book> books = bookService.selectAll();
        System.out.println(books);
    }

    @Test
    public void testBatchAdd(){
        Object[] o1 = {"3","java","c"};
        Object[] o2 = {"4","c++","d"};
        Object[] o3 = {"5","go","e"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchAdd(batchArgs);
    }

    @Test
    public void testBatchUpdate(){
        Object[] o1 = {"java","cc","3"};
        Object[] o2 = {"c++","dd","4"};
        Object[] o3 = {"go","ee","5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchUpdate(batchArgs);
    }

    @Test
    public void testBatchDelete(){
        Object[] o1 = {"3"};
        Object[] o2 = {"5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        bookService.batchDelete(batchArgs);
    }


}
