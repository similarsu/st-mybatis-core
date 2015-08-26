package cn.st.mybatis.core.support;

/**
 * <p>
 * desciption: 分页基类
 * </p>
 * 
 * @author coolearth
 * @date 2015年8月7日
 */
public class BasePager {

    public static final int DEFAULT_COUNT = 20;

    protected int pageNo = 1;// 页码
    protected int pageSize = 10;// 条数
    protected int totalCount = 0;// 记录数

    /**
     * @param pageNo
     * @param pageSize
     * @param totalCount
     */
    public BasePager(int pageNo, int pageSize, int totalCount) {
        this.totalCount = totalCount <= 0 ? 0 : totalCount;
        this.pageSize = pageSize <= 0 ? DEFAULT_COUNT : pageSize;
        this.pageNo = pageNo <= 0 ? 1 : pageNo;
    }

    public void adjustPage() {
        if (totalCount <= 0) {
            totalCount = 0;
        }
        if (pageSize <= 0) {
            pageSize = DEFAULT_COUNT;
        }
        if (pageNo <= 0) {
            pageNo = 1;
        }
        int totalPage = this.getTotalPage();
        if (pageNo >= totalPage) {
            pageNo = totalPage;
        }
    }

    /**
     * 获取页码
     * 
     * @return
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 获取条数
     * 
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 获取记录数
     * 
     * @return
     */
    public int getTotalCount() {
        return totalCount;
    }



    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 返回总页数
     * 
     * @return
     */
    public int getTotalPage() {
        int totalPage = totalCount / pageSize;
        if (totalCount % pageSize != 0 || totalPage == 0) {
            totalPage++;
        }
        return totalPage;
    }

    /**
     * 是否首页
     * 
     * @return
     */
    public boolean getIsFirstPage() {
        return pageNo <= 1;
    }

    /**
     * 是否尾页
     * 
     * @return
     */
    public boolean getIsLastPage() {
        return pageNo >= getTotalPage();
    }

    /**
     * 获取下一页码
     * 
     * @return
     */
    public int getNextPage() {
        if (getIsLastPage()) {
            return pageNo;
        } else {
            return pageNo + 1;
        }
    }

    /**
     * 获取上一页码
     * 
     * @return
     */
    public int getPrePage() {
        if (getIsFirstPage()) {
            return pageNo;
        } else {
            return pageNo - 1;
        }
    }

    /**
     * 获取偏移量
     * 
     * @return
     */
    public int getOffset() {
        return (pageNo - 1) * pageSize;
    }

}
