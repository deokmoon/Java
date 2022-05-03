package com.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 오픈채팅방 문제(level 2)
 * 문자열 파싱 및 map, list 활용
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 *
 */
public class OpenChatting {
    private static void main(String[] args) {
        Solution sol = new Solution();
        String[] str = {
                "Enter uid1234 Muzi"
                , "Enter uid4567 Prodo"
                , "Leave uid1234"
                , "Enter uid1234 Prodo"
                , "Change uid4567 Ryan"
        };
        List<String> result = sol.solution(str);
        for (String line : result) {
            System.out.println(line);
        }
    }
    public static class Solution {
        /**
         * 1. id, 닉네임 hashMap으로 정리 -> enter인 경우 신규, change는 변경
         * 2. record 순자 읽으면서 answer에 입력
         */
        public List<String> solution(String[] record) {
            List<String> answer = new ArrayList<String>();
            Map<String, String> nameMap = new HashMap<String, String>();

            // name mapping
            for (String line: record) {
                String cmd = line.split(" ")[0];
                String id = "";
                String name = "";
                if (!"Leave".equals(cmd)) {
                    id = line.split(" ")[1];
                    name = line.split(" ")[2];
                }
                if ("Enter".equals(cmd) || "Change".equals(cmd)) {
                    nameMap.put(id, name);
                }
            }
            // checking name mapping
            /*
            nameMap.forEach((strKey, strValue) -> {
                System.out.println(strKey + " : " + strValue);
            });
            */
            // input answer
            for (String line: record) {
                String cmd = line.split(" ")[0];
                String id = line.split(" ")[1];
                if ("Enter".equals(cmd)) {
                    answer.add(nameMap.get(id) + "님이 들어왔습니다.");
                }
                if ("Leave".equals(cmd)) {
                    answer.add(nameMap.get(id) + "님이 나갔습니다.");
                }
            }

            return answer;
        }
    }
}
