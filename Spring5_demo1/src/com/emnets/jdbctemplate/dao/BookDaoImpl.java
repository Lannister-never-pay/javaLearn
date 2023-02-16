package com.emnets.jdbctemplate.dao;

import com.emnets.jdbctemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author lannisite
 * @program BookDaoImpl
 * @description 描述
 * @date 2023/2/15 23:01
 */

@Repository
public class BookDaoImpl implements BookDao{

    //  注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addBook(Book book) {

        String sql = "insert into t_book values(?,?,?)";
        Object[] args = { book.getUserID(), book.getUserName(), book.getuStatus()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);

    }

    @Override
    public void updateBook(Book book) {
        String sql = "update t_book set user_name=?,u_status=? where user_id=?";
        Object[] args = {  book.getUserName(), book.getuStatus(),book.getUserID()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public void delete(String id) {
        String sql = "delete from t_book where user_id=?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from t_book";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    @Override
    public Book selectById(String id) {

        String sql = "select * from t_book where user_id=?";
        //  第二个参数：RowMapper，是接口，返回不同类型的数据，使用这个接口里面实现类完成数据封装
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),id);
    }

    @Override
    public List<Book> selectBooks() {
        String sql = "select * from t_book";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
    }

    @Override
    public void batchAdd(List<Object[]> batchArgs) {
        String sql = "insert into t_book values(?,?,?)";
        int[] batchUpdate = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(batchUpdate));
    }

    @Override
    public void batchUpdate(List<Object[]> batchArgs) {
        String sql = "update t_book set user_name=?,u_status=? where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDelete(List<Object[]> batchArgs) {
        String sql = "delete from t_book where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }


}
