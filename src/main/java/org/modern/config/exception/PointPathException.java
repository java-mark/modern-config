package org.modern.config.exception;

/**
 * @author pengjian05
 */
public class PointPathException extends RuntimeException {
    private static final String POINT_PATH_ERROR_MSG = "Error path: ";

    public PointPathException(String path, Throwable cause) {
        super(POINT_PATH_ERROR_MSG + path, cause);
    }
}
