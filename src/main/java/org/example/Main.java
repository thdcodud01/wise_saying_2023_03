package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Container.init();

        new App().run(); //new app에 run이라는 함수가 있다.

        Container.close();

    }
}