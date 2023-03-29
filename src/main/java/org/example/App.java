package org.example;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class App {
    private final Scanner sc; //final -> 최초에 한번 할당하고 더이상 할당 하지 않겠다

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.printf(" == wise_saying app == \n");
        long lastWiseSayingId = 0;
        List<WiseSaying> wiseSayings = new ArrayList<>();

        while (true) {
            System.out.printf("command) ");
            String command = sc.nextLine().trim();

            if (command.equals("end")) {
                break;
            } else if (command.equals("register")) {

                System.out.printf("wise_saying : ");
                String content = sc.nextLine().trim();
                System.out.printf("author : ");
                String authorName = sc.nextLine().trim();

                long id = lastWiseSayingId + 1;
                wiseSayings.add(new WiseSaying(id, content, authorName));

                System.out.printf("#%d number wise_saying is register \n", id);
                lastWiseSayingId = id;
            } else if (command.equals("list")) {
                System.out.println("Id / Author / Wise_saying");
                System.out.println("----------------------");

                for(int i = wiseSayings.size() -1; i >= 0; i--){
                    System.out.println(wiseSayings.get(i).getId() + " / " + wiseSayings.get(i).getAuthorName() + " / " + wiseSayings.get(i).getContent());
                }
            }

        }



    }
}
