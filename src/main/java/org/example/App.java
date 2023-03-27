package org.example;

import java.util.Scanner;

public class App {
    private final Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.printf(" == wise_saying app == \n");
        while(true) {
            System.out.printf("command) ");
            String command = sc.nextLine().trim();

            if(command.equals("end")) {
                break;
            }
        }


    }
}
