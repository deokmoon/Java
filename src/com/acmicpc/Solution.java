package com.acmicpc;

import java.util.HashMap;
import java.util.Map;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public Map<String, Integer> chkDup = new HashMap<>();

    public String[] getEmailName(String[] names, String company) {

        int length = names.length;
        String out[] = new String[length];

        for(int i = 0; i < length; i++) {
            String name[] = names[i].split(" ");
            for(int j = 0; j < name.length; j++) {
                if(j == name.length - 1 && name[j].contains("-")) { // last
                    String temp = "";
                    temp += name[j].replace("-", "").toLowerCase();
                    if(temp.length() > 8) out[i] += temp.substring(0, 8);
                    else out[i] += temp;
                    break;
                } else if(j == name.length - 1) {
                    String temp = "";
                    temp += name[j].toLowerCase();
                    if(temp.length() > 8) out[i] += temp.substring(0, 8);
                    else out[i] += temp;
                    break;
                }
                out[i] += name[j].substring(0, 1).toLowerCase();
            }
            if(chkDup.containsKey(out[i])) { // 중복체크
                int cnt = chkDup.get(out[i]);
                chkDup.put(out[i], cnt++);
                out[i] += Integer.toString(cnt + 1);
            } else {
                chkDup.put(out[i], 1);
            }
        }
        return out;
    }
    public String solution(String S, String C) {
        String names[] = S.split(", ");
        int length = names.length;
        String emailNames[] = new String[length];
        String res[] = new String[length];
        String domain = C.toLowerCase();

        boolean[] visited = new boolean[res.length];
        emailNames = getEmailName(names, C);

        for(int i = 0; i < length; i++) {
            res[i] = "<" + names[i];
        }

        return "";
    }
}
