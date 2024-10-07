package exceptions;

public class VariableAlreadyDeclaredException extends RuntimeException {
    public VariableAlreadyDeclaredException(String fileName, int line) {
        super("Variable already declared in " + fileName + " at line " + line);
    }

    public VariableAlreadyDeclaredException(String varName) {
        super("Variable " + varName + " already declared");
    }
}
