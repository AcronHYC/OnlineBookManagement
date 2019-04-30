package com.hyc.onlineBookManagement.service;

import com.hyc.onlineBookManagement.bean.Borrow;

import java.util.List;

public interface BorrowService {
    //根据条件查询借阅记录数量
    int queryBorrowCount(String uuid,
                         String status,
                         String realName,
                         String bookName,
                         String borrow_day,
                         String real_borrow_day,
                         String overdue,
                         String borrowStartTime,
                         String borrowEndTime,
                         String backStartTime,
                         String backEndTime);

    //添加借阅记录，同时计算借阅图书的在馆数量和借出数量，更新借阅图书的信息
    boolean addBorrow(Borrow borrow,String uuid,String inNum,String outNum);

    //根据UUID删除借阅记录
    boolean deleteBorrow(String uuid);

    //根据UUID更新借阅记录的信息，若更新了借阅状态，同时计算借阅图书的在馆数量和借出数量，更新借阅图书的信息
    boolean updateBorrow(String uuid,
                         String status,
                         String user_uuid,
                         String book_uuid,
                         String borrow_date,
                         String back_date,
                         String borrow_day,
                         String real_borrow_day,
                         String overdue);

    //根据条件分页模糊查询借阅记录
    String queryBorrowByFuzzyAndPage(String uuid,
                                     String status,
                                     String realName,
                                     String bookName,
                                     String borrow_day,
                                     String real_borrow_day,
                                     String overdue,
                                     String borrowStartTime,
                                     String borrowEndTime,
                                     String backStartTime,
                                     String backEndTime,
                                     Integer pageSize,
                                     Integer page);

    String queryBorrowByFuzzyAndPageAndUserid(String user_uuid,
                                              String status,
                                              String bookName,
                                              String borrow_day,
                                              String real_borrow_day,
                                              String overdue,
                                              String borrowStartTime,
                                              String borrowEndTime,
                                              String backStartTime,
                                              String backEndTime,
                                              Integer pageSize,
                                              Integer page);
}
