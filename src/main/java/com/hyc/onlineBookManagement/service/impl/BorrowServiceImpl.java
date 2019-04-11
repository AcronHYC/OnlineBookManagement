package com.hyc.onlineBookManagement.service.impl;

import com.hyc.onlineBookManagement.bean.Borrow;
import com.hyc.onlineBookManagement.dao.BookDao;
import com.hyc.onlineBookManagement.dao.BorrowDao;
import com.hyc.onlineBookManagement.service.BorrowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "borrowService")
public class BorrowServiceImpl implements BorrowService {
    @Resource
    private BorrowDao borrowDao;
    private BookDao bookDao;

    @Override
    public int queryBorrowCount(String uuid,
                                String status,
                                String userName,
                                String bookName,
                                String borrow_day,
                                String overdue,
                                String borrowStartTime,
                                String borrowEndTime,
                                String backStartTime,
                                String backEndTime){
        return borrowDao.selectBorrowCount(uuid,status,userName,bookName,borrow_day,overdue,borrowStartTime,borrowEndTime,backStartTime,backEndTime);
    }

    @Override
    public boolean addBorrow(Borrow borrow,String uuid,String inNum,String outNum){
        boolean flag=false;
        try {
            borrowDao.insertBorrow(borrow);
            bookDao.updateBook(uuid,null,null,null,null,null,null,null,null,String.valueOf(Integer.parseInt(inNum)-1),String.valueOf(Integer.parseInt(outNum)+1),null);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteBorrow(String uuid){
        boolean flag=false;
        try {
            borrowDao.deleteBorrow(uuid);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
