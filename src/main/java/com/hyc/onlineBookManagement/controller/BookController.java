package com.hyc.onlineBookManagement.controller;

import com.hyc.onlineBookManagement.bean.Book;
import com.hyc.onlineBookManagement.service.BookService;
import com.hyc.onlineBookManagement.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/book")
public class BookController {
    @Resource
    private BookService bookService;

    @ResponseBody
    @RequestMapping(value="/addBook", method = RequestMethod.POST)
    public boolean addBook(@RequestBody Map<String,String> params){
        try {
            Book book = new Book();
            book.setUuid(UUIDUtils.getUUID());
            book.setImg(params.get("img"));
            book.setBookName(params.get("bookName"));
            book.setAuthor(params.get("author"));
            book.setPublish(params.get("publish"));
            book.setISBN(params.get("ISBN"));
            book.setPrice(params.get("price"));
            book.setClass_uuid(params.get("class_uuid"));
            book.setInNum(params.get("inNum"));
            book.setOutNum(params.get("outNum"));
            book.setIntroduction(params.get("introduction"));
            return bookService.addBook(book);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @ResponseBody
    @RequestMapping(value="/deleteBook")
    public boolean deleteBook(@RequestBody Map<String,String> params){
        String uuid=params.get("uuid");
        return bookService.deleteBook(uuid);
    }

    @ResponseBody
    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public boolean updateBook(@RequestBody Map<String,String> params) {
        String uuid=params.get("uuid");
        String img=params.get("img");
        String bookName=params.get("bookName");
        String author=params.get("author");
        String publish=params.get("publish");
        String ISBN=params.get("ISBN");
        String price=params.get("price");
        String class_uuid=params.get("class_uuid");
        String inNum=params.get("inNum");
        String outNum=params.get("outNum");
        String introduction=params.get("introduction");
        return bookService.updateBook(uuid,img,bookName,author,publish,ISBN,price,class_uuid,inNum,outNum,introduction);
    }

    @ResponseBody
    @RequestMapping("/queryBookByParams")
    public List<Book> queryBookByParams(HttpServletRequest request){
        String uuid=request.getParameter("uuid");
        String img=request.getParameter("img");
        String bookName=request.getParameter("bookName");
        String author=request.getParameter("author");
        String publish=request.getParameter("publish");
        String ISBN=request.getParameter("ISBN");
        String price=request.getParameter("price");
        String class_uuid=request.getParameter("class_uuid");
        String inNum=request.getParameter("inNum");
        String outNum=request.getParameter("outNum");
        String introduction=request.getParameter("introduction");
        return bookService.queryBookByParams(uuid,img,bookName,author,publish,ISBN,price,class_uuid,inNum,outNum,introduction);
    }

    @ResponseBody
    @RequestMapping(value = "/queryBookByFuzzyAndPage")
    public String queryBookByFuzzyAndPage(HttpServletRequest request) {
        String uuid=request.getParameter("uuid");
        String img=request.getParameter("img");
        String bookName=request.getParameter("bookName");
        String author=request.getParameter("author");
        String publish=request.getParameter("publish");
        String ISBN=request.getParameter("ISBN");
        String price=request.getParameter("price");
        String class_uuid=request.getParameter("class_uuid");
        String inNum=request.getParameter("inNum");
        String outNum=request.getParameter("outNum");
        String introduction=request.getParameter("introduction");
        try {
            int page = Integer.parseInt(request.getParameter("page"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            return bookService.queryBookByFuzzyAndPage(uuid,img,bookName,author,publish,ISBN,price,class_uuid,inNum,outNum,introduction, pageSize, page);
        } catch (Exception e) {
            return bookService.queryBookByFuzzyAndPage(uuid,img,bookName,author,publish,ISBN,price,class_uuid,inNum,outNum,introduction, null, null);
        }
    }
}
