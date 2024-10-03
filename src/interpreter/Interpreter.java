package interpreter;

import interpreter.variables.CInteger;

import java.io.File;
import java.io.FileNotFoundException;
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
            if (Keywords.variables.contains(words[0])) {
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
                        if (initialize) new CInteger().initialize(name, Integer.parseInt(inlineOperation(inline, fileName, lineNumber)));
                        else new CInteger().declare(name);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Found error in " + fileName + " on line " + lineNumber + "\n" + e.getMessage());
        }
    }

    private String inlineOperation(String inline, String fileName, int lineNumber) {
        String output = "";

        return output;
    }
}
