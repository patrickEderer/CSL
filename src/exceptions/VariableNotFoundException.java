package exceptions;

public class VariableNotFoundException extends RuntimeException {
    public VariableNotFoundException(String message) {
        super(message);
    }

    public VariableNotFoundException(String fileName, int line) {
        super("Variable not found in " + fileName + " at line " + line);
    }
}
