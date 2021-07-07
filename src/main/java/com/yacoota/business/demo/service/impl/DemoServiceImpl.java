package com.yacoota.business.demo.service.impl;


import com.yacoota.business.demo.mapper.DemoMapper;
import com.yacoota.business.demo.model.Demo;
import com.yacoota.business.demo.model.DemoExample;
import com.yacoota.business.demo.service.DemoService;
import com.yacoota.framework.base.service.impl.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class DemoServiceImpl extends BaseServiceImpl<Demo, DemoExample> implements DemoService {

    @Autowired
    private DemoMapper mapper;

    @Override
    protected void setBaseMapper() {
        super.mapper = mapper;
    }

    @Override
    public PageInfo<Demo> selectPageHelper(DemoExample example, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(mapper.selectByExampleWithBLOBs(example));
    }

    @Cacheable(value="demos", key="#id")
    public Demo select(Long id) {
        DemoExample example = new DemoExample();
        example.createCriteria().andIdEqualTo(Long.valueOf(id));
        List<Demo> list = mapper.selectByExampleWithBLOBs(example);
        return Optional.ofNullable(list).map(l -> l.get(0)).orElse(null);
    }


    @Override
    @Transactional
    public int insert(Demo demo) {
        return super.insert(demo);
    }

}
