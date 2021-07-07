package com.yacoota.framework.spring;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private static final String FORMAT = "系统错误》》》代码：%s，描述：%s。";

    // 运行时异常
    @ExceptionHandler(RuntimeException.class)
    public String runtimeExceptionHandler(RuntimeException ex) {
        return resultFormat("00001", ex);
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException ex) {
        return resultFormat("00002", ex);
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public String classCastExceptionHandler(ClassCastException ex) {
        return resultFormat("00003", ex);
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public String iOExceptionHandler(IOException ex) {
        return resultFormat("00004", ex);
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public String noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return resultFormat("00005", ex);
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public String indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return resultFormat("00006", ex);
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public String requestNotReadable(HttpMessageNotReadableException ex) {
        return resultFormat("00007", ex);
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public String requestTypeMismatch(TypeMismatchException ex) {
        return resultFormat("00008", ex);
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public String requestMissingServletRequest(MissingServletRequestParameterException ex) {
        return resultFormat("00009", ex);
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public String request405(HttpRequestMethodNotSupportedException ex) {
        return resultFormat("00010", ex);
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public String request406(HttpMediaTypeNotAcceptableException ex) {
        return resultFormat("00011", ex);
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public String server500(RuntimeException ex) {
        return resultFormat("00012", ex);
    }

    //栈溢出
    @ExceptionHandler({StackOverflowError.class})
    public String requestStackOverflow(StackOverflowError ex) {
        return resultFormat("00013", ex);
    }

    //除数不能为0
    @ExceptionHandler({ArithmeticException.class})
    public String arithmeticException(ArithmeticException ex) {
        return resultFormat("00014", ex);
    }

    //其他错误
    @ExceptionHandler({Exception.class})
    public String exception(Exception ex) {
        return resultFormat("99999", ex);
    }

    private <T extends Throwable> String resultFormat(String code, T ex) {
        log.error(String.format(FORMAT, code, ex.getMessage()));
        return JSONUtil.toJsonStr(new String[]{code, ex.getMessage()});
    }

}
