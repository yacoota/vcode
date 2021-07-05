package com.yacoota.business.controller;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/demox")
public class DemoFluxController {

    @Autowired
    private StringEncryptor encryptor;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<String> index(@PathVariable("id") String id) {
        return Mono.just(id);
    }

    @GetMapping("/encode/{code}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Flux<String> encoder(@PathVariable String code) {
        log.info("数据库配置：{}", encryptor.encrypt("jdbc:mysql://127.0.0.1:18004/webchat?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&allowMultiQueries=true&useSSL=false"));
        log.info("数据库用户：{}", encryptor.encrypt("towerdml"));
        log.info("数据库密码：{}", encryptor.encrypt("towerdmlpwd"));
        log.info("缓存库密码：{}", encryptor.encrypt("redispwd"));
        return Flux.just(String.format("加密数据：%s", encryptor.encrypt(code)));
    }

}
