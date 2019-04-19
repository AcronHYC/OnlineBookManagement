package com.hyc.onlineBookManagement.dao;

import com.hyc.onlineBookManagement.bean.Borrow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BorrowDao {
    //根据条件查询借阅记录的数量
    int selectBorrowCount(@Param("uuid")String uuid,
                          @Param("status")String status,
                          @Param("realName")String realName,
                          @Param("bookName")String bookName,
                          @Param("borrow_day")String borrow_day,
                          @Param("real_borrow_day")String real_borrow_day,
                          @Param("overdue")String overdue,
                          @Param("borrowStartTime")String borrowStartTime,
                          @Param("borrowEndTime")String borrowEndTime,
                          @Param("backStartTime")String backStartTime,
                          @Param("backEndTime")String backEndTime);

    //插入新的借阅记录
    int insertBorrow(Borrow borrow);

    //根据UUID删除借阅记录
    int deleteBorrow(@Param("uuid")String uuid);

    //根据UUID更新借阅记录
    int updateBorrow(@Param("uuid")String uuid,
                     @Param("status")String status,
                     @Param("user_uuid")String user_uuid,
                     @Param("book_uuid")String book_uuid,
                     @Param("borrow_date")String borrow_date,
                     @Param("back_date")String back_date,
                     @Param("borrow_day")String borrow_day,
                     @Param("real_borrow_day")String real_borrow_day,
                     @Param("overdue")String overdue);

    //根据条件动态查询借阅记录
    List<Borrow> selectBorrowByParams(@Param("uuid")String uuid,
                                      @Param("status")String status,
                                      @Param("realName")String realName,
                                      @Param("bookName")String bookName,
                                      @Param("borrow_date")String borrow_date,
                                      @Param("back_date")String back_date,
                                      @Param("borrow_day")String borrow_day,
                                      @Param("real_borrow_day")String real_borrow_day,
                                      @Param("overdue")String overdue);

    //根据条件分页模糊查询借阅记录
    List<Borrow> selectBorrowByFuzzyAndPage(@Param("uuid")String uuid,
                                            @Param("status")String status,
                                            @Param("realName")String realName,
                                            @Param("bookName")String bookName,
                                            @Param("borrow_day")String borrow_day,
                                            @Param("real_borrow_day")String real_borrow_day,
                                            @Param("overdue")String overdue,
                                            @Param("borrowStartTime")String borrowStartTime,
                                            @Param("borrowEndTime")String borrowEndTime,
                                            @Param("backStartTime")String backStartTime,
                                            @Param("backEndTime")String backEndTime,
                                            @Param("startIndex")Integer startIndex,
                                            @Param("pageSize")Integer pageSize);
}
