package com.yintu.ruixing.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author:mlf
 * @date:2020/5/21 16:25
 */
public class BaseRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 8097323379789459900L;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BaseRuntimeException(String message) {
        super(message);
        this.logger.debug(message);
    }


    public BaseRuntimeException(Throwable cause) {
        super(cause);
        this.logger.debug(cause.getMessage());
    }

    public BaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
        this.logger.debug(cause.getMessage());
    }
}
