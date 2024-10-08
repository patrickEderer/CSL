package interpreter.logics;

import interpreter.Variable;
import interpreter.variables.CInteger;

public class Operators {;
    public static Variable add(Variable var1, Variable var2) {
        if (var1.getVarType() == CInteger.INTEGER) {
            if (var2.getVarType() == CInteger.INTEGER) {
                return new CInteger().literal((int) var1.getValue() + (int) var2.getValue());
            }
        }
        throw new UnsupportedOperationException(var1.getVarType() + " + " + var2.getVarType());
    }

    public static Variable subtract(Variable var1, Variable var2) {
        if (var1.getVarType() == CInteger.INTEGER) {
            if (var2.getVarType() == CInteger.INTEGER) {
                return new CInteger().literal((int) var1.getValue() - (int) var2.getValue());
            }
        }
        throw new UnsupportedOperationException(var1.getVarType() + " + " + var2.getVarType());
    }

    public static Variable divide(Variable var1, Variable var2) {
        if (var1.getVarType() == CInteger.INTEGER) {
            if (var2.getVarType() == CInteger.INTEGER) {
                return new CInteger().literal((int) var1.getValue() / (int) var2.getValue());
            }
        }
        throw new UnsupportedOperationException(var1.getVarType() + " + " + var2.getVarType());
    }

    public static Variable mul(Variable var1, Variable var2) {
        if (var1.getVarType() == CInteger.INTEGER) {
            if (var2.getVarType() == CInteger.INTEGER) {
                return new CInteger().literal((int) var1.getValue() * (int) var2.getValue());
            }
        }
        throw new UnsupportedOperationException(var1.getVarType() + " + " + var2.getVarType());
    }

    public static Variable mod(Variable var1, Variable var2) {
        if (var1.getVarType() == CInteger.INTEGER) {
            if (var2.getVarType() == CInteger.INTEGER) {
                return new CInteger().literal((int) var1.getValue() % (int) var2.getValue());
            }
        }
        throw new UnsupportedOperationException(var1.getVarType() + " + " + var2.getVarType());
    }
}
