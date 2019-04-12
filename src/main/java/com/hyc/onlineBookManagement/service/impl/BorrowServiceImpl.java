package com.hyc.onlineBookManagement.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hyc.onlineBookManagement.bean.Borrow;
import com.hyc.onlineBookManagement.bean.Page;
import com.hyc.onlineBookManagement.dao.BookDao;
import com.hyc.onlineBookManagement.dao.BorrowDao;
import com.hyc.onlineBookManagement.service.BorrowService;
import jdk.nashorn.internal.scripts.JS;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service(value = "borrowService")
public class BorrowServiceImpl implements BorrowService {
    @Resource
    private BorrowDao borrowDao;
    @Resource
    private BookDao bookDao;

    @Override
    public int queryBorrowCount(String uuid,
                                String status,
                                String realName,
                                String bookName,
                                String borrow_day,
                                String overdue,
                                String borrowStartTime,
                                String borrowEndTime,
                                String backStartTime,
                                String backEndTime){
        return borrowDao.selectBorrowCount(uuid,status,realName,bookName,borrow_day,overdue,borrowStartTime,borrowEndTime,backStartTime,backEndTime);
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

    @Override
    public String queryBorrowByFuzzyAndPage(String uuid,
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
                                            Integer page){
        int total=borrowDao.selectBorrowCount(uuid,status,realName,bookName,borrow_day,overdue,borrowStartTime,borrowEndTime,backStartTime,backEndTime);
        List<Borrow> borrowList=new ArrayList<Borrow>();
        JSONObject jsonObject=new JSONObject();
        Page pageObject=null;
        if(page!=null) {
            pageObject = new Page(page, pageSize, total);
            borrowList=borrowDao.selectBorrowByFuzzyAndPage(uuid,status,realName,bookName,borrow_day,overdue,borrowStartTime,borrowEndTime,backStartTime,backEndTime,pageObject.getStartIndex(),pageSize);
        }else{
            pageObject=new Page(1,10,total);
            borrowList=borrowDao.selectBorrowByFuzzyAndPage(uuid,status,realName,bookName,borrow_day,overdue,borrowStartTime,borrowEndTime,backStartTime,backEndTime,pageObject.getStartIndex(),pageObject.getPageSize());
        }
        jsonObject.put("jsonBorrowList",JSONObject.toJSON(borrowList));
        jsonObject.put("pagination",JSONObject.toJSON(pageObject));
        return jsonObject.toJSONString();
    }
}
