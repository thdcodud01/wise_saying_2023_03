package org.example;

import java.util.Scanner;

public class Container { // 의존도와 결합도를 낮추기 위해 container class 선언
    private static Scanner sc;

    public static void init() { //진입한다는 키워드 , 클래스에 직접 진입하기 때문에 static 사용
        sc = new Scanner(System.in);
    }
    public static void close() {
        sc.close();
    }
    public static Scanner getScanner () {
        return sc;
    }
}
