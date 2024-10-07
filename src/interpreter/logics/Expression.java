package interpreter.logics;

import exceptions.VariableNotFoundException;
import interpreter.Keywords;
import interpreter.Variable;
import interpreter.storage.StoredVariables;
import interpreter.variables.CInteger;

import java.util.InputMismatchException;

public class Expression {
    public static Variable eval(String expression, String fileName, int lineNumber) {
        //Check if it is an operation
        if (Keywords.expressions.stream().anyMatch(expression::contains)) {
            String[] words = expression.split(" ");
            String newExpression = "";

            for (String word : words) {
                if (Keywords.expressions.contains(word)) {
                    eval(newExpression, fileName, lineNumber);
                } else {
                    newExpression += word + " ";
                }
            }


        }
        //Get variable or literal
        else {
            try {
                return new CInteger().literal(Integer.parseInt(expression));
            } catch (InputMismatchException _) {
                if (StoredVariables.variables.containsKey(expression)) {
                    return StoredVariables.variables.get(expression);
                } else throw new VariableNotFoundException(fileName, lineNumber);
            }
        }
        return null;
    }
}
