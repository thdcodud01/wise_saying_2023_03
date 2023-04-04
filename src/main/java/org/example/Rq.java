package org.example;

import java.util.HashMap;

public class Rq {
    String actionCode;
    HashMap<String, String> params; // key로 접근 가능

    public Rq(String command) {
        String[] commandBits = command.split("\\?", 2); // split->나눈것을 배열화 시킴 (?를 기준으로 나눔 ,값을 2개로 나눔)
        this.actionCode = commandBits[0];

        // register 또는 end 일 경우는 여기까지 실행
        // ? 옵션이 없으면 여기까지 실행
        if (commandBits.length == 1) return;
        params = new HashMap<>();
        String[] paramsBits = commandBits[1].split("&"); // &를 기준으로 또 나눔, 같은 level에 있으니 limit를 줄필요 x

        for (String paramsStr : paramsBits) { //paramBits를 받을 변수의 이름을 ':' 앞에 선언해준 것
            String[] paramStrBits = paramsStr.split("=", 2);

            if (paramStrBits.length == 1) continue; // 배열 1개일때 정상적으로 진행 (안전성 위한 코드)

            String key = paramStrBits[0];
            String value = paramStrBits[1];
            params.put(key, value); // hashmap 이용해서 put
        }
    }

    public String getActionCode() {
        return this.actionCode;
    }

    public String getParams(String name) {
        return params.get(name);
    }

    public int getIntParam(String name, int defaultValue) {
        try {
            return Integer.parseInt(getParams(name));
        } catch (NumberFormatException e) {
            System.out.printf("error ! because it's not integer\n");
        }
        return defaultValue;

    }
}
