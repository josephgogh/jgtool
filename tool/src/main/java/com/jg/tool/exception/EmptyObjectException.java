package com.jg.tool.exception;

/**
 * 空对象异常
 */
public class EmptyObjectException extends JGToolException {

    public EmptyObjectException() {
        super();
    }

    public EmptyObjectException(String message) {
        super(message);
    }

    public EmptyObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyObjectException(Throwable cause) {
        super(cause);
    }

    protected EmptyObjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
