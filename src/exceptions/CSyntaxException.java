package exceptions;

public class CSyntaxException extends RuntimeException {
    public CSyntaxException(String message) {
        super(message);
    }

    public CSyntaxException(String fileName, int line) {
        super("Unknown syntax in " + fileName + " at line " + line);
    }

    public CSyntaxException() {
        super("Unknown syntax");
    }
}
