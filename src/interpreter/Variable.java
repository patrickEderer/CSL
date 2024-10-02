package interpreter;

public interface Variable {
    void initialize(String name, Object value);

    Object getValue(String name);

    void declare(String name);
}
