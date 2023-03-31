package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;

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

            } else if (command.equals("delete")){
                wiseSayingController.delete();
//                System.out.println("#" + lastWiseSayingId + "has deleted");
            }


        }



    }
}
