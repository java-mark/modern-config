package person.pjzero.cfman.exception;

/**
 * @author pengjian05
 */
public class BindException extends RuntimeException {
    private static final String BIND_FAILED_MSG = "Missing environment: ";

    public BindException(Throwable cause) {
        super(BIND_FAILED_MSG, cause);
    }
}
