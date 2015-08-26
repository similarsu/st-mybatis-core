package cn.st.mybatis.core.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import cn.st.mybatis.core.entity.BaseEntity;
import cn.st.mybatis.core.exception.DataException;
import cn.st.mybatis.core.mapper.BaseMapper;
import cn.st.mybatis.core.service.BaseService;
import cn.st.mybatis.core.support.Pager;

/**
 * <p>
 * desciption:
 * </p>
 * 
 * @author coolearth
 * @date 2015年8月7日
 */
@Transactional
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    protected final static String ADD_ERROR_MSG = "error.base.add";

    protected final static String DELETE_ERROR_MSG = "error.base.delete";

    protected final static String UPDATE_ERROR_MSG = "error.base.update";

    protected final static String FIND_ERROR_MSG = "error.base.find";


    private BaseMapper<T> baseMapper;


    public void injectBaseMapper(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public void add(T entity) {
        // TODO Auto-generated method stub
        try {
            baseMapper.add(entity);
        } catch (Exception e) {
            logger.error(null, e);
            throw new DataException(ADD_ERROR_MSG);
        }

    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        try {
            baseMapper.delete(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error(null, e);
            throw new DataException(DELETE_ERROR_MSG);
        }
    }

    @Override
    public void update(T entity) {
        // TODO Auto-generated method stub
        try {
            baseMapper.update(entity);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error(null, e);
            throw new DataException(UPDATE_ERROR_MSG);
        }
    }

    @Override
    public T load(Long id) {
        // TODO Auto-generated method stub
        try {
            return (T) baseMapper.load(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error(null, e);
            throw new DataException(FIND_ERROR_MSG);
        }
    }

    @Override
    public List<T> findAll(T entity) {
        // TODO Auto-generated method stub
        try {
            return baseMapper.findAll(entity);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error(null, e);
            throw new DataException(FIND_ERROR_MSG);
        }
    }

    @Override
    public int getCount(T entity) {
        // TODO Auto-generated method stub
        try {
            return baseMapper.getCount(entity);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error(null, e);
            throw new DataException(FIND_ERROR_MSG);
        }
    }

    @Override
    public Pager<T> findPage(T entity) {
        // TODO Auto-generated method stub
        try {
            List<T> list = baseMapper.findPage(entity);
            int count = baseMapper.getCount(entity);
            Pager<T> pager = entity.getPager();
            pager.setList(list);
            pager.setTotalCount(count);
            return pager;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error(null, e);
            throw new DataException(FIND_ERROR_MSG);
        }
    }
}
