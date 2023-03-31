package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;

import java.util.HashMap;

public class App {
    public void run() {
        System.out.printf(" == wise_saying app == \n");

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        while (true) {
            System.out.printf("command) ");
            String command = Container.getScanner().nextLine().trim();

            if (command.equals("end")) {
                systemController.exit();
                break;
            } else if (command.equals("register")) {
                wiseSayingController.write();

            } else if (command.equals("list")) {
                wiseSayingController.list();

            } else if (command.startsWith("remove")){
                String[] commandBits = command.split("\\?", 2); // split->나눈것을 배열화 시킴 (?를 기준으로 나눔 ,값을 2개로 나눔)
                String actionCode = commandBits[0];
                String[] paramsBits = commandBits[1].split("&"); // &를 기준으로 또 나눔, 같은 level에 있으니 limit를 줄필요 x

                HashMap<String, String> params = new HashMap<>(); // key로 접근 가능

                for(String paramsStr : paramsBits) { //paramBits를 받을 변수의 이름을 ':' 앞에 선언해준 것
                    String[] paramStrBits = paramsStr.split("=", 2);
                    String key = paramStrBits[0];
                    String value = paramStrBits[1];
                    params.put(key, value); // hashmap 이용해서 put
                }
                System.out.printf("actionCode : %s\n", actionCode);
                System.out.printf("params : %s\n", params);
                wiseSayingController.remove();
            }


        }



    }
}
