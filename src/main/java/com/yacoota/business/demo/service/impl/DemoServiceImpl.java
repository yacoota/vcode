package com.yacoota.business.demo.service.impl;


import com.yacoota.business.demo.mapper.DemoMapper;
import com.yacoota.business.demo.model.Demo;
import com.yacoota.business.demo.model.DemoExample;
import com.yacoota.business.demo.service.DemoService;
import com.yacoota.framework.base.service.impl.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public int insert(Demo demo) {
        return super.insert(demo);
    }

}
