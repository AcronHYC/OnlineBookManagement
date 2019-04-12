package com.hyc.onlineBookManagement.service;

import com.hyc.onlineBookManagement.bean.Borrow;

import java.util.List;

public interface BorrowService {
    int queryBorrowCount(String uuid,
                         String status,
                         String realName,
                         String bookName,
                         String borrow_day,
                         String overdue,
                         String borrowStartTime,
                         String borrowEndTime,
                         String backStartTime,
                         String backEndTime);

    boolean addBorrow(Borrow borrow,String uuid,String inNum,String outNum);

    boolean deleteBorrow(String uuid);

    String queryBorrowByFuzzyAndPage(String uuid,
                                     String status,
                                     String realName,
                                     String bookName,
                                     String borrow_day,
                                     String overdue,
                                     String borrowStartTime,
                                     String borrowEndTime,
                                     String backStartTime,
                                     String backEndTime,
                                     Integer pageSize,
                                     Integer page);
}
