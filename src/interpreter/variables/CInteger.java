package interpreter.variables;

import interpreter.Variable;
import interpreter.storage.StoredVariables;

public class CInteger implements Variable {
    Integer value;

    @Override
    public void initialize(Object value, String name) {
        this.value = (Integer) value;
        if (value != null) {
            StoredVariables.variables.put(name, this);
        } else {
            System.err.println("Wrong variable type for type Integer!");
        }
    }

    public Object getValue(String name) {
        return value;
    }

    public void declare(String name) {
        StoredVariables.variables.put(name, this);
    }
}
