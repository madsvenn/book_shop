package util;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PageInfo {
    List list;

    int currentPage = 1; //当前页数

    int recordSize = 10; //每页记录数

    int recordCount; //总记录数

    String url;

    String method;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRecordSize() {
        return recordSize;
    }

    public void setRecordSize(int recordSize) {
        this.recordSize = recordSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getPageCount(){

        return this.recordCount%this.recordSize==0?this.recordCount/this.recordSize:this.recordCount/this.recordSize+1;
    }

    public PageInfo(HttpServletRequest request){
        String currentPage = request.getParameter("currentPage");
        if(currentPage!=null){
            this.setCurrentPage(Integer.valueOf(currentPage));
        }

        this.url=request.getRequestURI().toString();
        String method = request.getParameter("method");
        if(method!=null){
            this.setMethod(method);
        }

        request.setAttribute("pageInfo",this);
    }
}
