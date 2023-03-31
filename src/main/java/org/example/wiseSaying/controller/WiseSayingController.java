package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {
    long lastWiseSayingId = 0;
    List<WiseSaying> wiseSayings = new ArrayList<>();

    public void write() {
        System.out.printf("wise_saying : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.printf("author : ");
        String authorName = Container.getScanner().nextLine().trim();

        long id = lastWiseSayingId + 1;
        wiseSayings.add(new WiseSaying(id, content, authorName));

        System.out.printf("#%d number wise_saying is register \n", id);
        lastWiseSayingId = id;
    }

    public void list() {
        System.out.println("Id / Author / Wise_saying");
        System.out.println("-".repeat(25));

        for(int i = wiseSayings.size() -1; i >= 0; i--){
            System.out.println(wiseSayings.get(i).getId() + " / " + wiseSayings.get(i).getAuthorName() + " / " + wiseSayings.get(i).getContent());
        }
    }

    public void delete() {
    }
}
