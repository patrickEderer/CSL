package interpreter.variables;

import exceptions.VariableAlreadyDeclaredException;
import exceptions.WrongVariableTypeException;
import interpreter.Variable;
import interpreter.storage.StoredVariables;

public class CInteger implements Variable {
    Integer value;
    final int varType = Variable.INTEGER;

    @Override
    public Variable literal(Object value) {
        if (!(value instanceof Integer)) {
            throw new WrongVariableTypeException();
        }
        this.value = (int) value;
        return this;
    }

    @Override
    public void initialize(String name, Object value) {
        this.value = (Integer) value;
        if (value != null) {
            if (!StoredVariables.variables.containsKey(name)) {
                StoredVariables.variables.put(name, this);
                System.out.println("Initialized var " + name);
            } else {
                throw new VariableAlreadyDeclaredException(name);
            }
        } else {
            System.err.println("Wrong variable type for type Integer!");
        }
    }

    public Object getValue() {
        return value;
    }

    public void declare(String name) {
        if (!StoredVariables.variables.containsKey(name)) {
            StoredVariables.variables.put(name, this);
            System.out.println("Declared var " + name);
        } else {
            throw new VariableAlreadyDeclaredException(name);
        }
    }

    @Override
    public int getVarType() {
        return varType;
    }
}
