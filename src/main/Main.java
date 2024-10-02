package main;

import interpreter.Interpreter;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Interpreter().interpret("main.txt", 0);
    }
}