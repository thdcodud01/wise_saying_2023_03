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
            Rq rq = new Rq(command);

            switch (rq.getActionCode()) { // if 문이 대략 3개 이상이 될 때에는 switch문이 더 편리
                case "end":
                    systemController.exit();
                    return;
                case "register":
                    wiseSayingController.write();
                    break; // switch안에서만 break됨
                case "list":
                    wiseSayingController.list();
                    break;
                case "remove":
                    wiseSayingController.remove(rq);
                    break;
                case "modify":
                    wiseSayingController.modify(rq);
                    break;
            }

        }

    }
}
