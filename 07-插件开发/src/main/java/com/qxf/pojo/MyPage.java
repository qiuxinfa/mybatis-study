package com.qxf.pojo;

/**
 * @Auther: qiuxinfa
 * @Date: 2020/3/8
 * @Description: com.qxf.pojo
 */
public class MyPage {
    private Integer currentPage;    //当前页是第几页
    private Integer pageSize;       //每页的大小

    public MyPage(){

    }

    public MyPage(Integer currentPage,Integer pageSize){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
