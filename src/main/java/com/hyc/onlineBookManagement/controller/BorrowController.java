package com.hyc.onlineBookManagement.controller;

import com.hyc.onlineBookManagement.bean.Borrow;
import com.hyc.onlineBookManagement.service.BorrowService;
import com.hyc.onlineBookManagement.utils.Converter;
import com.hyc.onlineBookManagement.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="borrow")
public class BorrowController {
    @Resource
    private BorrowService borrowService;

    @ResponseBody
    @RequestMapping("queryBorrowCount")
    public int queryBorrowCount(HttpServletRequest request){
        String uuid=request.getParameter("uuid");
        String status=request.getParameter("status");
        String userName=request.getParameter("userName");
        String bookName=request.getParameter("bookName");
        String borrow_day=request.getParameter("borrow_day");
        String overdue=request.getParameter("overdue");
        String borrowStartTime=request.getParameter("borrowStartTime");
        String borrowEndTime=request.getParameter("borrowEndTime");
        String backStartTime=request.getParameter("backStartTime");
        String backEndTime=request.getParameter("backEndTime");
        return borrowService.queryBorrowCount(uuid,status,userName,bookName,borrow_day,overdue,borrowStartTime,borrowEndTime,backStartTime,backEndTime);
    }

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
        borrow.setOverdue(null);
        return borrowService.addBorrow(borrow,book_uuid,inNum,outNum);
    }
}
