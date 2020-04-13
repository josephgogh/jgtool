package com.jg.tool.exception;

/**
 * ACTable异常（自动建表异常）
 */
public class ACTableException extends JGToolException {

    public ACTableException() {
        super();
    }

    public ACTableException(String message) {
        super(message);
    }

    public ACTableException(String message, Throwable cause) {
        super(message, cause);
    }

    public ACTableException(Throwable cause) {
        super(cause);
    }

    protected ACTableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
