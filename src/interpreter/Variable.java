package interpreter;

public interface Variable {
    void initialize(Object value, String name);

    Object getValue(String name);

    void declare(String name);
}
