package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.Rq;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {
    long lastWiseSayingId = 0;
    ArrayList<WiseSaying> wiseSayings = new ArrayList<WiseSaying>(); // arraylist 라는 list를 유동적으로 받을 수 있는 상자를 선언

    public void write() {
        System.out.printf("wise_saying : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.printf("author : ");
        String authorName = Container.getScanner().nextLine().trim();

        long id = lastWiseSayingId + 1;
        wiseSayings.add(new WiseSaying(id, content, authorName)); // 배열을 add라는 함수에 추가해주겠다

        System.out.printf("#%d number wise_saying is register \n", id);
        lastWiseSayingId = id;
    }

    public void list() {
        System.out.println("Id / Author / Wise_saying");
        System.out.println("-".repeat(25)); // repeat함수는 숫자만 적어주면 그 횟수만큼 출력 -> =를 25번 출력

        for (int i = wiseSayings.size() - 1; i >= 0; i--) { // 가장 마지막에 있는 값의 i는 배열의 크기보다 1 작은 초기값으로 시작,
            System.out.println(wiseSayings.get(i).getId() + " / " + wiseSayings.get(i).getAuthorName() + " / " + wiseSayings.get(i).getContent());
        }
    }

    public void remove(Rq rq) {
        System.out.println(rq);

        int id = rq.getIntParam("id", -1); // 비어있는 값 대신 null 대신 -1로 setting


        if (id == -1) {
            System.out.printf("please enter integer value\n");
            return;
        }

        WiseSaying wiseSaying = findByid(id); // id 값으로 저장된 데이터를 가져온다

        if (wiseSaying == null) {
            System.out.printf("there's no data to deleted");
        }

        wiseSayings.remove(wiseSaying); // 저장된 데이터로 전체데이터에서 삭제하는 메서드를 이용해서 삭제한다
        System.out.printf("No.%d wise_saying has delete\n", id); // 멘트 출력
    }

    private WiseSaying findByid(int id) {
        for (WiseSaying wiseSaying : wiseSayings) { // wiseSayings 에서 id 값을 순회하면서 내가 입력한 id 값이 있는지 검사하는 것
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }

    public void modify(Rq rq) {
        int id = rq.getIntParam("id", -1); // 비어있는 값 대신 null 대신 -1로 setting

        if (id == -1) {
            System.out.printf("please enter integer value\n");
            return;
        }
        WiseSaying wiseSaying = findByid(id);

        if (wiseSaying == null) {
            System.out.printf("Don't need to modify");
            return;
        }
        System.out.printf("original wise_saying %s\n", wiseSaying.getContent());
        System.out.printf("wise_saying to be modified) ");
        String Content = Container.getScanner().nextLine().trim();

        System.out.printf("original author %s\n", wiseSaying.getContent());
        System.out.printf("authorName to be modified) ");
        String authorName = Container.getScanner().nextLine().trim();

        wiseSaying.setContent(Content);
        wiseSaying.setAuthorName(authorName);

        System.out.printf("NO. %d has been modified\n", wiseSaying.getId());
    }
}