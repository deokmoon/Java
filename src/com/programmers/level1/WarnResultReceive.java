package com.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
    신고결과 받기
    프로그래머스 level-1
 */
public class WarnResultReceive {
    public static Map<String, User> userList = new HashMap<>();
    public static Map<String, User> reportedList = new HashMap<>();

    public static void main(String[] args) {
//        int[] input = {0, 2, 3, 4, 5, 28, 58, 67, 91};
        int[] input = {0, 1, 3, 5, 6};
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        System.out.println(new Solution().solution(id_list, report, k));

    }

    private static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = {};

            answer = new int[id_list.length];

            for (String id : id_list) {
                if (!userList.containsKey(id)) {
                    userList.put(id, new User(id));
                }
            }

            for (String line : report) {
                String[] temp = line.split(" ");
                String reportUser = temp[0];
                String reportedUSer = temp[1];
                boolean isAlready = false;

                for (User user : userList.get(reportUser).getReportUserList()) {
                    if (user.getId().equals(reportedUSer)) {
                        isAlready = true;
                        break;
                    }
                }
                if (isAlready) continue;
                userList.get(reportUser).addReportId(userList.get(reportedUSer));
                userList.get(reportedUSer).addReportedCnt();
                if (userList.get(reportedUSer).getReportedCnt() >= k) {
                    if (!reportedList.containsKey(reportedUSer)) {
                        reportedList.put(userList.get(reportedUSer).getId(), userList.get(reportedUSer));
                    }
                }
            }

            int index = 0;
            for (String userStr : id_list) {
                int temp = 0;
                User tempUser = userList.get(userStr);
                for (User user : tempUser.getReportUserList()) {
                    if (reportedList.containsKey(user.getId())) {
                        temp++;
                    }
                }
                answer[index] = temp;
                index++;
            }


            return answer;
        }
    }
}

class User {
    private String id;
    private List<User> reportUserList;
    private int reportedCnt;

    public User(String id) {
        this.id = id;
        reportUserList = new ArrayList<>();
        reportedCnt = 0;
    }

    public String getId() {
        return id;
    }

    public List<User> getReportUserList() {
        return reportUserList;
    }

    public void addReportId(User user) {
        reportUserList.add(user);
    }

    public void addReportedCnt() {
        reportedCnt++;
    }

    public int getReportedCnt() {
        return reportedCnt;
    }
}
