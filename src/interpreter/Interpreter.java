package interpreter;

import interpreter.logics.Expression;
import interpreter.storage.StoredVariables;
import interpreter.variables.CInteger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Interpreter {
    public void interpret(String fileName, int lineNumber) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                interpretLine(scanner.nextLine(), fileName, lineNumber);
                lineNumber++;
            }
        } catch (FileNotFoundException _) {
            System.err.println("Couldn't find a file with name '" + fileName + "'");
        }
    }

    private void interpretLine(String line, String fileName, int lineNumber) {
        try {
            String[] words = line.split(" ");
            if (Keywords.variableTypes.contains(words[0])) {
                boolean initialize = words.length >= 4;
                String name = words[1];

                String inline = "";
                if (initialize) {
                    for (int i = 3; i < words.length; i++) {
                        inline = inline.concat(words[i]);
                    }
                }

                switch (words[0]) {
                    case "int" -> {
                        if (initialize) new CInteger().initialize(name, Expression.eval(inline, fileName, lineNumber).getValue());
                        else new CInteger().declare(name);
                    }
                }
            } else if (StoredVariables.variables.containsKey(words[0])) {
                if (words[1].equals("=")) {
                    StoredVariables.variables.get(words[0]).setValue(Expression.eval(arrayToString(Arrays.copyOfRange(words, 2, words.length)), fileName, lineNumber).getValue());
                }
            } else {
                switch (words[0]) {
                    case "print" -> {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 1; i < words.length; i++) {
                            stringBuilder.append(words[i]).append(" ");
                        }
                        System.out.println(Expression.eval(stringBuilder.toString(), fileName, lineNumber).getValue());
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Found error in " + fileName + " on line " + lineNumber);
            throw new RuntimeException(e);
        }
    }

    private String arrayToString(String[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : array) {
            stringBuilder.append(s).append(" ");
        }
        return stringBuilder.toString();
    }
}
