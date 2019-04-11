package com.hyc.onlineBookManagement.service;

import com.hyc.onlineBookManagement.bean.Borrow;

import java.util.List;

public interface BorrowService {
    int queryBorrowCount(String uuid,
                         String status,
                         String userName,
                         String bookName,
                         String borrow_day,
                         String overdue,
                         String borrowStartTime,
                         String borrowEndTime,
                         String backStartTime,
                         String backEndTime);

    boolean addBorrow(Borrow borrow,String uuid,String inNum,String outNum);

    boolean deleteBorrow(String uuid);
}
