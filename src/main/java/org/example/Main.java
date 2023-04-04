package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Container.init(); //static 이기 때문에 class 설계도에서 바로 접근 가능, app과 container가 같은 level

        new App().run(); //new app에 run이라는 함수가 있다.

        Container.close();

    }
}