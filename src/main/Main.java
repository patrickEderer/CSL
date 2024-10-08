package main;

import interpreter.Interpreter;

public class Main {
    public static void main(String[] args) {
        new Interpreter().interpret("main.txt", 1);
    }
}