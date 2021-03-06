package io.github.suxil.core.exception;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/21 22:38
 * <p>
 *
 * @author lu_it
 * @version V1.0
 * @Package io.github.suxil.core.exception
 */
public class GlobalCommonException extends RuntimeException {

    public GlobalCommonException() {
    }

    public GlobalCommonException(String message) {
        super(message);
    }

    public GlobalCommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalCommonException(Throwable cause) {
        super(cause);
    }

}
