package com.hyc.onlineBookManagement.dao;

import com.hyc.onlineBookManagement.bean.Borrow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BorrowDao {
    int selectBorrowCount(@Param("uuid")String uuid,
                          @Param("status")String status,
                          @Param("userName")String userName,
                          @Param("bookName")String bookName,
                          @Param("borrow_day")String borrow_day,
                          @Param("overdue")String overdue,
                          @Param("borrowStartTime")String borrowStartTime,
                          @Param("borrowEndTime")String borrowEndTime,
                          @Param("backStartTime")String backStartTime,
                          @Param("backEndTime")String backEndTime);

    int insertBorrow(Borrow borrow);

    int deleteBorrow(@Param("uuid")String uuid);

    int updateBorrow(@Param("uuid")String uuid,
                     @Param("status")String status,
                     @Param("user_uuid")String user_uuid,
                     @Param("book_uuid")String book_uuid,
                     @Param("borrow_date")String borrow_date,
                     @Param("back_date")String back_date,
                     @Param("borrow_day")String borrow_day,
                     @Param("overdue")String overdue);

    List<Borrow> selectBorrowByParams(@Param("uuid")String uuid,
                                      @Param("status")String status,
                                      @Param("userName")String userName,
                                      @Param("bookName")String bookName,
                                      @Param("borrow_date")String borrow_date,
                                      @Param("back_date")String back_date,
                                      @Param("borrow_day")String borrow_day,
                                      @Param("overdue")String overdue);

    List<Borrow> selectBorrowByFuzzyAndPage(@Param("uuid")String uuid,
                                            @Param("status")String status,
                                            @Param("userName")String userName,
                                            @Param("bookName")String bookName,
                                            @Param("borrow_day")String borrow_day,
                                            @Param("overdue")String overdue,
                                            @Param("borrowStartTime")String borrowStartTime,
                                            @Param("borrowEndTime")String borrowEndTime,
                                            @Param("backStartTime")String backStartTime,
                                            @Param("backEndTime")String backEndTime);
}
