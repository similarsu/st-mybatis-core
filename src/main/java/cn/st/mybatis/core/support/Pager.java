package cn.st.mybatis.core.support;

import java.util.List;

/**
 * <p>
 * desciption:分页处理类
 * </p>
 * 
 * @author coolearth
 * @date 2015年8月7日
 */
public class Pager<T> extends BasePager {

    /**
     * @param pageNo
     * @param pageSize
     * @param totalCount
     */
    public Pager(int pageNo, int pageSize, int totalCount) {
        super(pageNo, pageSize, totalCount);
        // TODO Auto-generated constructor stub
    }

    public Pager(int pageNo, int pageSize) {
        super(pageNo, pageSize, 0);
        // TODO Auto-generated constructor stub
    }


    private List<T> list;// 数据列表

    private int maxIndexPages = 5;// 索引数

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }



    public int getMaxIndexPages() {
        return maxIndexPages;
    }

    public void setMaxIndexPages(int maxIndexPages) {
        this.maxIndexPages = maxIndexPages;
    }

    @Override
    public void adjustPage() {
        // TODO Auto-generated method stub
        super.adjustPage();
        if (maxIndexPages <= 0) {
            maxIndexPages = 0;
        }
    }

    /**
     * 索引页导航
     * 
     * @return
     */
    public int[] getIndexPages() {
        int firstPage = getFirstIndexPage();
        int lastPage = getLastIndexPage(firstPage);
        int len = lastPage - firstPage + 1;
        int[] indexPages = new int[len];
        for (int i = 0; i < len; i++) {
            indexPages[i] = firstPage + i;
        }
        return indexPages;
    }

    /**
     * 获取分页索引首页
     * 
     * @return
     */
    private final int getFirstIndexPage() {
        int firstPage = 1;
        int halfIndexPage = maxIndexPages / 2;
        int totalPage = super.getTotalPage();
        if (pageNo <= halfIndexPage) {
            firstPage = 1;
        } else if (pageNo > totalPage - halfIndexPage) {
            firstPage = totalPage - maxIndexPages + 1;
            firstPage = Math.max(1, firstPage);
        }

        else {
            firstPage = pageNo - halfIndexPage;
        }

        return firstPage;
    }

    /**
     * 获取索引页尾页
     * 
     * @param firstPage
     * @return
     */
    private final int getLastIndexPage(int firstPage) {
        int lastPage = firstPage + maxIndexPages - 1;
        int totalPage = super.getTotalPage();
        return Math.min(lastPage, totalPage);
    }

    public static void main(String[] args) {
        Pager pager = new Pager(-1, 10, 50);
        int[] indexPages = pager.getIndexPages();
        pager.adjustPage();
        int curPage = pager.getPageNo();
        for (int i : indexPages) {
            if (curPage == i) {
                System.out.print("[" + i + "]\t");
            } else {
                System.out.print(i + "\t");
            }

        }
        System.out.println(pager.getTotalPage());
    }

}
