package com.gs;

public class Second {
    public static void main(String[] args) {
        int[][] arr = {
            {2, 100}, {3, 120}, {4, 180}, {7, 250}
        };
        System.out.println(solution(arr, 6));
    }
    public static int solution (int[][] salaries, int days) {
        int answer = 0;

        for (int i = 0; i < salaries.length; i++) {
            int salaryDays = (int)Math.ceil((double)days / salaries[i][0]);
            if(salaryDays < 1) {
                salaryDays = 1;
            }
            answer += salaryDays * salaries[i][1];
        }

        return answer;
    }
}
// 300 240 360, 250