package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/5/19 17:14
 */
@RestControllerAdvice
public class GlobalExceptionController {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(SQLException.class)
    public Map<String, Object> sqlException(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return ResponseDataUtil.error("该数据有关联数据，操作失败");
        }
        logger.error(e.getMessage());
        return ResponseDataUtil.error("数据库异常，操作失败");
    }

    @ExceptionHandler(BaseRuntimeException.class)
    public Map<String, Object> baseRuntimeException(BaseRuntimeException e) {
        logger.error(e.getMessage());
        return ResponseDataUtil.error(e.getMessage());
    }


}
