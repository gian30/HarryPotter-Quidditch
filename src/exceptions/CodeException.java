package exceptions;

/**
 * Abstract class to work with Exception with code
 * 
 * @author gianluca
 */
public abstract class CodeException extends Exception {

    // Code of exception
    private final int code;

    public CodeException(int code) {
        this.code = code;
    }

    /**
     * Get the value of code
     *
     * @return the value of code
     */
    public int getCode() {
        return code;
    }

}
