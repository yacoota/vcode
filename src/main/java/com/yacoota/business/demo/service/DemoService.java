package com.yacoota.business.demo.service;


import com.yacoota.business.demo.model.Demo;
import com.yacoota.business.demo.model.DemoExample;
import com.yacoota.framework.base.service.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DemoService extends BaseService<Demo, DemoExample> {

    List<Demo> select(DemoExample example);

    PageInfo<Demo> selectPageHelper(DemoExample example, int pageNum, int pageSize);

}
