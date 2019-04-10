package com.hyc.onlineBookManagement.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hyc.onlineBookManagement.bean.Book;
import com.hyc.onlineBookManagement.bean.BookClass;
import com.hyc.onlineBookManagement.bean.Page;
import com.hyc.onlineBookManagement.dao.BookDao;
import com.hyc.onlineBookManagement.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    @Override
    public boolean addBook(Book book){
        boolean flag=false;
        try {
            bookDao.insertBook(book);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteBook(String uuid){
        boolean flag=false;
        try {
            bookDao.deleteBook(uuid);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateBook(String uuid,
                               String img,
                               String bookName,
                               String author,
                               String publish,
                               String isbn,
                               String price,
                               String class_uuid,
                              String state,
                               String inNum,
                               String outNum,
                               String introduction){
        boolean flag=false;
        try {
            bookDao.updateBook(uuid,img,bookName,author,publish,isbn,price,class_uuid,state,inNum,outNum,introduction);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Book> queryBookByParams(String uuid,
                                        String img,
                                        String bookName,
                                        String author,
                                        String publish,
                                        String isbn,
                                        String price,
                                        String class_uuid,
                                        String state,
                                        String inNum,
                                        String outNum,
                                        String introduction){
        return bookDao.selectBookByParams(uuid,img,bookName,author,publish,isbn,price,class_uuid,state,inNum,outNum,introduction);
    }

    @Override
    public String queryBookByFuzzyAndPage(String uuid,
                                          String img,
                                        String bookName,
                                        String author,
                                        String publish,
                                        String isbn,
                                         String price,
                                        String class_uuid,
                                          String state,
                                         String inNum,
                                         String outNum,
                                        String introduction,
                                   Integer pageSize,
                                   Integer page){
        int total=bookDao.selectBookCount(uuid,img,bookName,author,publish,isbn,price,class_uuid,state,inNum,outNum,introduction);
        List<Book> bookList=new ArrayList<Book>();
        JSONObject jsonObject=new JSONObject();
        Page pageObject=null;
        if(page!=null){
            pageObject=new Page(page,pageSize,total);
            bookList=bookDao.selectBookByFuzzyAndPage(uuid,img,bookName,author,publish,isbn,price,class_uuid,state,inNum,outNum,introduction,pageObject.getStartIndex(),pageSize);
        }else{
            pageObject=new Page(1,10,total);
            bookList=bookDao.selectBookByFuzzyAndPage(uuid,img,bookName,author,publish,isbn,price,class_uuid,state,inNum,outNum,introduction,pageObject.getStartIndex(),pageObject.getPageSize());
        }
        jsonObject.put("jsonBookList",JSONObject.toJSON(bookList));
        jsonObject.put("pagination",JSONObject.toJSON(pageObject));
        return jsonObject.toJSONString();
    }

    @Override
    public List<BookClass> queryBookClass(){
        return bookDao.selectBookClass();
    }

    @Override
    public boolean addBookClass(BookClass bookClass){
        boolean flag=false;
        try {
            bookDao.insertBookClass(bookClass);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteBookClass(String class_uuid){
        boolean flag=false;
        try {
            bookDao.deleteBookClass(class_uuid);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
