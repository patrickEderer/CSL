package interpreter.logics;

import exceptions.VariableNotFoundException;
import interpreter.Variable;
import interpreter.storage.StoredVariables;
import interpreter.variables.CInteger;

import java.util.List;
import java.util.Stack;

public class Expression {
    public static Variable eval(String expression, String fileName, int lineNumber) {
        Stack<String> words = split(expression);
        if (words.size() >= 3) {
            while (words.size() >= 3) {
                words.push("" + (int) evalSingle(words.pop(), words.pop(), words.pop(), fileName, lineNumber));
            }
            return new CInteger().literal(Integer.parseInt(words.pop()));
        } else {
            try {
                return new CInteger().literal(Integer.parseInt(words.getFirst()));
            } catch (Exception _) {
                if (StoredVariables.variables.containsKey(words.getFirst())) {
                    return StoredVariables.variables.get(words.getFirst());
                } else {
                    throw new VariableNotFoundException(words.getFirst());
                }
            }
        }
    }

    //Evaluate a single operation
    private static Object evalSingle(String left, String operator, String right, String fileName, int lineNumber) {
        switch (operator) {
            case "+" -> {
                return Operators.add(eval(left, fileName, lineNumber), eval(right, fileName, lineNumber)).getValue();
            }
            case "-" -> {
                return Operators.subtract(eval(left, fileName, lineNumber), eval(right, fileName, lineNumber)).getValue();
            }
            case "/" -> {
                return Operators.divide(eval(left, fileName, lineNumber), eval(right, fileName, lineNumber)).getValue();
            }
            case "*" -> {
                return Operators.mul(eval(left, fileName, lineNumber), eval(right, fileName, lineNumber)).getValue();
            }
            default -> throw new UnsupportedOperationException(operator);
        }
    }

    static Stack<String> split(String expression) {
        List<String> words = new Stack<>();

        boolean inString = false;

        StringBuilder string = new StringBuilder();
        for (String word : expression.split(" ")) {
            if (word.startsWith("\"")) {
                inString = true;
            }
            if (inString) {
                string.append(word).append(" ");
            } else {
                words.add(word);
                continue;
            }
            if (word.endsWith("\"")) {
                string.deleteCharAt(string.length() - 1);
                inString = false;
            }
            if (!inString) {
                words.add(string.toString());
            }
        }

        Stack<String> result = new Stack<>();
        for (String word : words.reversed()) {
            result.push(word);
        }

        return result;
    }
}
