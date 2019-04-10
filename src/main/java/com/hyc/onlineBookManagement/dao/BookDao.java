package com.hyc.onlineBookManagement.dao;

import com.hyc.onlineBookManagement.bean.Book;
import com.hyc.onlineBookManagement.bean.BookClass;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface BookDao {
    int insertBook(Book book);

    int deleteBook(@Param("uuid")String uuid);

    int updateBook(@Param("uuid")String uuid,
                   @Param("img")String img,
                   @Param("bookName")String bookName,
                   @Param("author")String author,
                   @Param("publish")String publish,
                   @Param("isbn")String isbn,
                   @Param("price")String price,
                   @Param("class_uuid")String class_uuid,
                   @Param("state")String state,
                   @Param("inNum")String inNum,
                   @Param("outNum")String outNum,
                   @Param("introduction")String introduction);

    List<Book> selectBookByParams(@Param("uuid")String uuid,
                                   @Param("img")String img,
                                   @Param("bookName")String bookName,
                                   @Param("author")String author,
                                   @Param("publish")String publish,
                                   @Param("isbn")String isbn,
                                   @Param("price")String price,
                                   @Param("class_uuid")String class_uuid,
                                  @Param("state")String state,
                                   @Param("inNum")String inNum,
                                   @Param("outNum")String outNum,
                                   @Param("introduction")String introduction);

    List<Book> selectBookByFuzzyAndPage(@Param("uuid")String uuid,
                                       @Param("img")String img,
                                       @Param("bookName")String bookName,
                                       @Param("author")String author,
                                       @Param("publish")String publish,
                                       @Param("isbn")String isbn,
                                       @Param("price")String price,
                                       @Param("class_uuid")String class_uuid,
                                        @Param("state")String state,
                                       @Param("inNum")String inNum,
                                       @Param("outNum")String outNum,
                                       @Param("introduction")String introduction,
                                       @Param("startIndex")Integer startIndex,
                                       @Param("pageSize")Integer pageSize);

    int selectBookCount(@Param("uuid")String uuid,
                        @Param("img")String img,
                        @Param("bookName")String bookName,
                        @Param("author")String author,
                        @Param("publish")String publish,
                        @Param("isbn")String isbn,
                        @Param("price")String price,
                        @Param("class_uuid")String class_uuid,
                        @Param("state")String state,
                        @Param("inNum")String inNum,
                        @Param("outNum")String outNum,
                        @Param("introduction")String introduction);

    List<BookClass> selectBookClass();

    int insertBookClass(BookClass bookClass);

    int deleteBookClass(@Param("class_uuid")String class_uuid);
}