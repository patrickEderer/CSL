package interpreter.logics;

public class Expression {
    static boolean check(String expression, String fileName, int lineNumber) {
        String[] words = expression.split(" ");
        String leftSide;
        String rightSide;

        //
        if (words[0].startsWith("(")) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].contains(")")) {

                }
            }
        }
    }
}
