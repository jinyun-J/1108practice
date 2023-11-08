package org.example;

import org.example.App;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Container.init();
        new App().run();
        Container.close();
    }
}


