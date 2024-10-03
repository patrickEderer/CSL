package exceptions;

public class WrongVariableTypeException extends RuntimeException {
    public WrongVariableTypeException(String message) {
        super(message);
    }

    public WrongVariableTypeException() {
        super("Wrong variable type in");
    }
}
