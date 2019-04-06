package com.hyc.onlineBookManagement.bean;

public class Page {
    private int page;   // 当前页数
    private int pageSize;  // 每页显示记录的条数
    private int total;   // 总记录数
    private int totalPage;  //总页数
    private int startIndex;  //开始索引

    public Page(int page,int pageSize,int total){
        this.page=page;
        this.pageSize=pageSize;
        this.total=total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        totalPage=getTotal()/getPageSize();
        return (total % pageSize == 0) ? totalPage : totalPage + 1;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return (page-1)*pageSize;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
}
