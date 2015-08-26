package cn.st.mybatis.core.exception;

import org.springframework.dao.DataAccessException;

/**
 * <p>
 * desciption:
 * </p>
 * 
 * @author coolearth
 * @date 2015年8月7日
 */
public class DataException extends DataAccessException {

    /**
     * @param msg
     */
    public DataException(String msg) {
        super(msg);
        // TODO Auto-generated constructor stub
    }

}
