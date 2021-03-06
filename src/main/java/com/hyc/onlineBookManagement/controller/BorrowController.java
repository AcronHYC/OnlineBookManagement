package com.hyc.onlineBookManagement.controller;

import com.hyc.onlineBookManagement.annotation.LoginToken;
import com.hyc.onlineBookManagement.bean.Borrow;
import com.hyc.onlineBookManagement.service.BorrowService;
import com.hyc.onlineBookManagement.utils.Converter;
import com.hyc.onlineBookManagement.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hyc.onlineBookManagement.annotation.LoginToken;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="borrow")
public class BorrowController {
    @Resource
    private BorrowService borrowService;

    @LoginToken
    @ResponseBody
    @RequestMapping(value="/deleteBorrow")
    public boolean deleteBorrow(@RequestBody Map<String,String> params){
        String uuid=params.get("uuid");
        return borrowService.deleteBorrow(uuid);
    }

    @LoginToken
    @ResponseBody
    @RequestMapping("queryBorrowCount")
    public int queryBorrowCount(HttpServletRequest request){
        String uuid=request.getParameter("uuid");
        String status=request.getParameter("status");
        String realName=request.getParameter("realName");
        String bookName=request.getParameter("bookName");
        String borrow_day=request.getParameter("borrow_day");
        String real_borrow_day=request.getParameter("real_borrow_day");
        String overdue=request.getParameter("overdue");
        String borrowStartTime=request.getParameter("borrowStartTime");
        String borrowEndTime=request.getParameter("borrowEndTime");
        String backStartTime=request.getParameter("backStartTime");
        String backEndTime=request.getParameter("backEndTime");
        return borrowService.queryBorrowCount(uuid,status,realName,bookName,borrow_day,real_borrow_day,overdue,borrowStartTime,borrowEndTime,backStartTime,backEndTime);
    }

    @LoginToken
    @ResponseBody
    @RequestMapping(value="addBorrow", method = RequestMethod.POST)
    public boolean addBorrow(@RequestBody Map<String,String> params) {
        Borrow borrow=new Borrow();
        String book_uuid=params.get("uuid");
        String user_uuid=params.get("user_uuid");
        String inNum=params.get("inNum");
        String outNum=params.get("outNum");
        borrow.setUuid(UUIDUtils.getUUID());
        borrow.setStatus("未还");
        borrow.setUser_uuid(user_uuid);
        borrow.setBook_uuid(book_uuid);
        borrow.setBorrow_date(Converter.strToDate(params.get("borrow_date")));
        borrow.setBack_date(null);
        borrow.setBorrow_day(params.get("borrow_day"));
        borrow.setReal_borrow_day(null);
        borrow.setOverdue(null);
        return borrowService.addBorrow(borrow,book_uuid,inNum,outNum);
    }

    @LoginToken
    @ResponseBody
    @RequestMapping(value="updateBorrow", method = RequestMethod.POST)
    public boolean updateBorrow(@RequestBody Map<String,String> params) {
        String uuid=params.get("uuid");
        String status=params.get("status");
        String book_uuid=params.get("book_uuid");
        String back_date=params.get("back_date");
        String real_borrow_day=params.get("real_borrow_day");
        String overdue=params.get("overdue");
        return borrowService.updateBorrow(uuid,status,null,book_uuid,null,back_date,null,real_borrow_day,overdue);
    }

    @LoginToken
    @ResponseBody
    @RequestMapping(value = "/queryBorrowByFuzzyAndPage")
    public String queryBorrowByFuzzyAndPage(HttpServletRequest request){
        String uuid=request.getParameter("uuid");
        String status=request.getParameter("status");
        String realName=request.getParameter("realName");
        String bookName=request.getParameter("bookName");
        String borrow_day=request.getParameter("borrow_day");
        String real_borrow_day=request.getParameter("real_borrow_day");
        String overdue=request.getParameter("overdue");
        String borrowStartTime=request.getParameter("borrowStartTime");
        String borrowEndTime=request.getParameter("borrowEndTime");
        String backStartTime=request.getParameter("backStartTime");
        String backEndTime=request.getParameter("backEndTime");
        try {
            int page = Integer.parseInt(request.getParameter("page"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            return borrowService.queryBorrowByFuzzyAndPage(uuid,status,realName,bookName,borrow_day,real_borrow_day,overdue,borrowStartTime,borrowEndTime,backStartTime,backEndTime,pageSize,page);
        } catch (Exception e) {
            return borrowService.queryBorrowByFuzzyAndPage(uuid,status,realName,bookName,borrow_day,real_borrow_day,overdue,borrowStartTime,borrowEndTime,backStartTime,backEndTime,null,null);
        }
    }


    @ResponseBody
    @RequestMapping(value = "/queryBorrowByFuzzyAndPageAndUserid")
    public String queryBorrowByFuzzyAndPageAndUserid(HttpServletRequest request){
        String user_uuid=request.getParameter("user_uuid");
        String status=request.getParameter("status");
        String bookName=request.getParameter("bookName");
        String borrow_day=request.getParameter("borrow_day");
        String real_borrow_day=request.getParameter("real_borrow_day");
        String overdue=request.getParameter("overdue");
        String borrowStartTime=request.getParameter("borrowStartTime");
        String borrowEndTime=request.getParameter("borrowEndTime");
        String backStartTime=request.getParameter("backStartTime");
        String backEndTime=request.getParameter("backEndTime");
        try {
            int page = Integer.parseInt(request.getParameter("page"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            return borrowService.queryBorrowByFuzzyAndPageAndUserid(user_uuid,status,bookName,borrow_day,real_borrow_day,overdue,borrowStartTime,borrowEndTime,backStartTime,backEndTime,pageSize,page);
        } catch (Exception e) {
            return borrowService.queryBorrowByFuzzyAndPageAndUserid(user_uuid,status,bookName,borrow_day,real_borrow_day,overdue,borrowStartTime,borrowEndTime,backStartTime,backEndTime,null,null);
        }
    }
}
