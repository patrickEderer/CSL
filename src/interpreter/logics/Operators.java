package interpreter.logics;

import exceptions.CSyntaxException;
import interpreter.Variable;
import interpreter.variables.CInteger;

public class Operators {
    public static Variable add(Variable var1, Variable var2) {
        if (var1.getVarType() == Variable.INTEGER) {
            if (var2.getVarType() == Variable.INTEGER) {
                return new CInteger().literal((int) var1.getValue() + (int) var2.getValue());
            }
        }

        throw new CSyntaxException();
    }
    public static Variable subtract(Variable var1, Variable var2) {
        if (var1.getVarType() == Variable.INTEGER) {
            if (var2.getVarType() == Variable.INTEGER) {
                return new CInteger().literal((int) var1.getValue() - (int) var2.getValue());
            }
        }

        throw new CSyntaxException();
    }
    public static Variable mul(Variable var1, Variable var2) {
        if (var1.getVarType() == Variable.INTEGER) {
            if (var2.getVarType() == Variable.INTEGER) {
                return new CInteger().literal((int) var1.getValue() * (int) var2.getValue());
            }
        }

        throw new CSyntaxException();
    }

    public static Variable div(Variable var1, Variable var2) {
        if (var1.getVarType() == Variable.INTEGER) {
            if (var2.getVarType() == Variable.INTEGER) {
                return new CInteger().literal((int) var1.getValue() / (int) var2.getValue());
            }
        }

        throw new CSyntaxException();
    }

    public static Variable mod(Variable var1, Variable var2) {
        if (var1.getVarType() == Variable.INTEGER) {
            if (var2.getVarType() == Variable.INTEGER) {
                return new CInteger().literal((int) var1.getValue() % (int) var2.getValue());
            }
        }

        throw new CSyntaxException();
    }
}
