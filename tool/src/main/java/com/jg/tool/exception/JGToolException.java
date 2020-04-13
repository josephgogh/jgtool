package com.jg.tool.exception;

/**
 * 工具异常类
 */
public class JGToolException extends RuntimeException {

    public JGToolException() {
        super();
    }

    public JGToolException(String message) {
        super(message);
    }

    public JGToolException(String message, Throwable cause) {
        super(message, cause);
    }

    public JGToolException(Throwable cause) {
        super(cause);
    }

    protected JGToolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
