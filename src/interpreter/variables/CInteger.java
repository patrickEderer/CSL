package interpreter.variables;

import exceptions.WrongVariableTypeException;
import interpreter.Variable;
import interpreter.storage.StoredVariables;

public class CInteger implements Variable {
    Integer value;
    final int varType = Variable.INTEGER;

    @Override
    public Variable literal(Object value) {
        try {
            this.value = (int) value;
            return this;
        } catch (NumberFormatException _) {
            throw new WrongVariableTypeException();
        }
    }

    public void declare(String name) {
        StoredVariables.variables.put(name, this);
    }

    @Override
    public void initialize(String name, Object value) {
        this.value = (Integer) value;
        if (value != null) {
            StoredVariables.variables.put(name, this);
        } else {
            System.err.println("Wrong variable type for type Integer!");
        }
    }

    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = (Integer) value;
    }

    @Override
    public int getVarType() {
        return varType;
    }
}
