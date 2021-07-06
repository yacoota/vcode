package com.yacoota.framework.base.service.impl;

import com.yacoota.framework.base.mapper.BaseMapper;
import com.yacoota.framework.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 添加类/接口功能描述。
 *
 * @author WYC
 */
public abstract class BaseServiceImpl<R, E> implements BaseService<R, E> {

    // 添加变量功能描述。
    @Autowired
    protected BaseMapper<R, E> mapper;

    /**
     * 添加方法功能描述。
     *
     * @author WYC
     */
    protected abstract void setBaseMapper();

    /**
     * 添加override说明。
     *
     * @see com.yacoota.framework.base.service.BaseService#select(Object)
     */
    @Override
    public List<R> select(E example) {
        return mapper.selectByExample(example);
    }

    /**
     * 添加override说明。
     *
     * @see com.yacoota.framework.base.service.BaseService#insert(Object)
     */
    @Override
    public int insert(R record) {
        return mapper.insertSelective(record);
    }

    /**
     * 添加override说明。
     *
     * @see com.yacoota.framework.base.service.BaseService#update(Object, Object)
     */
    @Override
    public int update(R record, E example) {
        return mapper.updateByExampleSelective(record, example);
    }

    /**
     * 添加override说明。
     *
     * @see com.yacoota.framework.base.service.BaseService#delete(Object)
     */
    @Override
    public int delete(E example) {
        return mapper.deleteByExample(example);
    }

}
