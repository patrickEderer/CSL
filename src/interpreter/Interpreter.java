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
            }
        } catch (FileNotFoundException _) {
            System.err.println("Couldn't find a file with name '" + fileName + "'");
        }
    }

    private void interpretLine(String line, String fileName, int lineNumber) {
        String[] words = line.split(" ");
        if (Keywords.variables.contains(words[0])) {
            switch (words[0]) {
                case "int" -> {

                }
            }
        }
    }
}
