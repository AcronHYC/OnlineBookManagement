package com.hyc.onlineBookManagement.service;

import com.hyc.onlineBookManagement.bean.Book;
import com.hyc.onlineBookManagement.bean.BookClass;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    //添加新书
    boolean addBook(Book book);

    //根据UUID删除旧书
    boolean deleteBook(String uuid);

    //根据UUID更新图书信息
    boolean updateBook(String uuid,
                       String img,
                       String bookName,
                       String author,
                       String publish,
                       String isbn,
                       String price,
                       String class_uuid,
                       String state,
                       String inNum,
                       String outNum,
                       String introduction);

    //根据条件动态查询图书信息
    List<Book> queryBookByParams(String uuid,
                                  String img,
                                  String bookName,
                                  String author,
                                  String publish,
                                  String isbn,
                                 String price,
                                  String class_uuid,
                                 String state,
                                 String inNum,
                                 String outNum,
                                  String introduction);

    //根据条件分页模糊查询图书信息
    String queryBookByFuzzyAndPage(String uuid,
                                   String img,
                                   String bookName,
                                   String author,
                                   String publish,
                                   String isbn,
                                   String price,
                                   String class_uuid,
                                   String state,
                                   String inNum,
                                   String outNum,
                                   String introduction,
                                   Integer pageSize,
                                   Integer page);

    //查询图书类别
    List<BookClass> queryBookClass();

    //添加图书类别
    boolean addBookClass(BookClass bookClass);

    //删除图书类别
    boolean deleteBookClass(String class_uuid);

    //查询各种图书类型的数量
    List<Book> queryBookClassCount();

    //查询各种图书类型的借出数量
    List<Book> queryBookClassOutCount();

    List<Book> queryBookCountLimitTen();
}
