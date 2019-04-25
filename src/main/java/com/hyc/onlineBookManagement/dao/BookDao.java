package com.hyc.onlineBookManagement.dao;

import com.hyc.onlineBookManagement.bean.Book;
import com.hyc.onlineBookManagement.bean.BookClass;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface BookDao {
    //插入新的图书信息
    int insertBook(Book book);

    //根据uuid删除图书信息
    int deleteBook(@Param("uuid")String uuid);

    //根据UUID更新图书信息
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

    //根据条件动态查询图书信息
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

    //根据条件分页模糊查询图书信息
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

    //根据条件查询图书数量
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

    //查询图书类别
    List<BookClass> selectBookClass();

    //插入图书类别
    int insertBookClass(BookClass bookClass);

    //删除图书类别
    int deleteBookClass(@Param("class_uuid")String class_uuid);

    //查询各种图书类型的数量
    List<Book> selectBookClassCount();

    //查询各种图书类型的借出数量
    List<Book> selectBookClassOutCount();

    List<Book> selectBookCountLimitTen();
}
