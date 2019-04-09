package com.hyc.onlineBookManagement.service;

import com.hyc.onlineBookManagement.bean.Book;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    boolean addBook(Book book);

    boolean deleteBook(String uuid);

    boolean updateBook(String uuid,
                       String img,
                       String bookName,
                       String author,
                       String publish,
                       String ISBN,
                       String price,
                       String class_uuid,
                       String inNum,
                       String outNum,
                       String introduction);

    List<Book> queryBookByParams(String uuid,
                                  String img,
                                  String bookName,
                                  String author,
                                  String publish,
                                  String ISBN,
                                 String price,
                                  String class_uuid,
                                 String inNum,
                                 String outNum,
                                  String introduction);

    String queryBookByFuzzyAndPage(String uuid,
                                   String img,
                                   String bookName,
                                   String author,
                                   String publish,
                                   String ISBN,
                                   String price,
                                   String class_uuid,
                                   String inNum,
                                   String outNum,
                                   String introduction,
                                   Integer pageSize,
                                   Integer page);
}
