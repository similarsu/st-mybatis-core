package cn.st.mybatis.core.service;

import java.util.List;

import cn.st.mybatis.core.entity.BaseEntity;
import cn.st.mybatis.core.support.Pager;


/**
 * <p>
 * desciption:
 * </p>
 * 
 * @author coolearth
 * @date 2015年8月7日
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 添加记录
     * 
     * @param entity
     */
    public void add(T entity);

    /**
     * 删除记录
     * 
     * @param id
     */
    public void delete(Long id);

    /**
     * 更新记录
     * 
     * @param entity
     */

    public void update(T entity);

    /**
     * 加载记录
     * 
     * @param id
     * @return
     */
    public T load(Long id);

    /**
     * 获取列表
     * 
     * @param entity
     * @return
     */
    public List<T> findAll(T entity);

    /**
     * 获取记录数
     * 
     * @param entity
     * @return
     */
    public int getCount(T entity);


    /**
     * 分页查找记录数
     * 
     * @param pager
     * @return
     */
    public Pager<T> findPage(T entity);

}
