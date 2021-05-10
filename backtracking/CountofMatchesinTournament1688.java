package com.leetcode.backtracking;

public class CountofMatchesinTournament1688 {
	/*
        짝수인 경우
            경기: n / 2 , 진출: n / 2
        홀수인 경우
            경기: n - 1 / 2 , 진출: (n - 1 / 2 ) + 1

    */
	public int numberOfMatches(int n) {
		int matches = 0;

		while (n > 0) {
			if (n % 2 == 0) {
				matches += n / 2;
				n /= 2;
			} else {
				matches += (n - 1) / 2;
				n = ((n - 1) / 2) + 1;
			}
			if (n == 1)  n--;
		}
		return matches;
	}
}
