package interpreter;

public interface Variable {
    int INTEGER = 0;

    Variable literal(Object value);

    void initialize(String name, Object value);

    Object getValue();

    void setValue(Object value);

    void declare(String name);

    int getVarType();
}
