package com.yacoota.business.controller;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private StringEncryptor encryptor;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String index(@PathVariable String id) {
        log.info("采集数据：{}", id);
        return id;
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