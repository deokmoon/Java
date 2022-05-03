package com.gs;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class First {
    public String solution(String s1, String s2) {
        String answer = "";

        if(s1.length() >= s2.length()) {
            answer = getShortString(s1, s2);
        } else {
            answer = getShortString(s2, s1);
        }

        return answer;
    }
    public String getShortString(String longS, String shortS) {
        // 짧은 문자열 기준으로, 긴 문자열의 앞뒤를 비교
        List<String> strList = new ArrayList<String>();
        int dupLength = 0; //중첩 length

        // front, longS + shortS
        for (int i = 0; i < shortS.length(); i++) {
            int endIdx = shortS.length() - i;
            String compStr = shortS.substring(0, endIdx);

            if (longS.endsWith(compStr)) {
                dupLength = endIdx;
                strList.add(longS + shortS.substring(endIdx));
                break;
            }
        }

        // back, shortS + longS
        for (int i = 0; i < shortS.length(); i++) {
            String compStr = shortS.substring(i, shortS.length());

            if (longS.startsWith(compStr)) {
                if ((shortS.length() - i) > dupLength) {
                    strList.remove(0);
                    strList.add(shortS + longS.substring(shortS.length() - i));
                    break;
                }
                if ((shortS.length() - i) == dupLength) {
                    strList.add(shortS + longS.substring(shortS.length() - i));
                    break;
                }
            }
        }

        Collections.sort(strList);
        return strList.get(0);
    }
}