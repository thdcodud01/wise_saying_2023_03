package org.example; // org.example 하에 있는 파일들은 전부다 package로 묶여진다

import java.util.Scanner;

public class Main { // 진입하는 역할
    public static void main(String[] args) {
        Container.init(); //static 이기 때문에 class 설계도에서 바로 접근 가능, app과 container가 같은 level

        new App().run(); // run은 app안에 있는 메서드

        Container.close(); // scanner 해제

    }
}