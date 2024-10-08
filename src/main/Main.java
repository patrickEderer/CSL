package main;

import interpreter.Interpreter;
import interpreter.logics.Expression;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        new Interpreter().interpret("main.txt", 1);
    }
}