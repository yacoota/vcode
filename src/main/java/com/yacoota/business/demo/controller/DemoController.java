package com.yacoota.business.demo.controller;

import com.github.pagehelper.PageInfo;
import com.yacoota.business.demo.model.Demo;
import com.yacoota.business.demo.model.DemoExample;
import com.yacoota.business.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService service;

    @Autowired
    private StringEncryptor encryptor;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String index(@PathVariable String id) {
        log.info("采集数据：{}", id);
        return id;
    }

    @GetMapping(value = {"", "/", "/datas"})
    @ResponseStatus(HttpStatus.OK)
    public PageInfo<Demo> list(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo<Demo> result = service.selectPageHelper(new DemoExample(), pageNum, pageSize);
        log.info("demo/list-->查询结果：" + result.getSize());
        return result;
    }

    @GetMapping(value = "/data/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Demo select(@PathVariable("id") String id) {
        DemoExample example = new DemoExample();
        example.createCriteria().andIdEqualTo(Long.valueOf(id));
        List<Demo> list = service.select(example);
        return Optional.ofNullable(list).map(l -> l.get(0)).orElse(null);
    }

    @PostMapping("/data")
    @ResponseStatus(HttpStatus.CREATED)
    public Object insert(@RequestBody Demo demo) {
        return service.insert(demo);
    }

    @PatchMapping("/data/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object update(@PathVariable("id") String id, @RequestBody Demo demo) {
        DemoExample example = new DemoExample();
        example.createCriteria().andIdEqualTo(Long.valueOf(id));
        return service.update(demo, example);
    }

    @PutMapping("/data/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object modify(@PathVariable("id") String id, @RequestBody Demo demo) {
        DemoExample example = new DemoExample();
        example.createCriteria().andIdEqualTo(Long.valueOf(id));
        return service.update(demo, example);
    }

    @DeleteMapping("/data/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        DemoExample example = new DemoExample();
        example.createCriteria().andIdEqualTo(Long.valueOf(id));
        service.delete(example);
    }

    @GetMapping("/encode/{code}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String encoder(@PathVariable String code) {
        log.info("数据库配置：{}", encryptor.encrypt("jdbc:mysql://127.0.0.1:18004/webchat?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&allowMultiQueries=true&useSSL=false"));
        log.info("数据库用户：{}", encryptor.encrypt("towerdml"));
        log.info("数据库密码：{}", encryptor.encrypt("towerdmlpwd"));
        log.info("缓存库密码：{}", encryptor.encrypt("redispwd"));
        return String.format("加密数据：%s", encryptor.encrypt(code));
    }

}