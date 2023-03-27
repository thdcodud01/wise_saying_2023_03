package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        new App(sc).run(); //new app에 run이라는 함수가 있다.

        sc.close();

    }
}