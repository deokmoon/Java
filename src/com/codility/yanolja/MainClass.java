package com.codility.yanolja;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a[] = {2, 1, 4, 4};
        int res = s.solution(a);
        System.out.println(res );
    }
    static class Solution {
        public int solution(int[] A) {
            Arrays.sort(A);
            Map<Integer, Integer> map = new HashMap<>();
            long cnt = 0;
            int length = A.length;

            // init
            for(int i = 1; i <= length; i++) {
                if(!map.containsKey(i)) map.put(i, 0);
            }
            for(int i = 0; i < length; i++) {
                map.put(A[i], map.get(A[i]) + 1);
            }

            for(int intKey: map.keySet()) {
                int pre = intKey - 1;
                int post = intKey + 1;
                while(map.get(intKey) == 0) {
                    // pre > 0 && post < length
                    if(pre > 0 && map.get(pre) > 1) {
                        map.put(pre, map.get(pre) - 1);
                        map.put(intKey, 1);
                        cnt += intKey - pre;
                    }
                    else if(post <= length && map.get(post) > 1) {
                        map.put(post, map.get(post) - 1);
                        map.put(intKey, 1);
                        cnt += post - intKey;
                    }
                    else {
                        pre--;
                        post++;
                    }
                    if(cnt > 1000000000) return -1;
                }
            }

            return (int)cnt;
        }
    }

}
