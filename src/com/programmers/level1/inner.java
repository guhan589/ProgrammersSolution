package com.programmers.level1;

public class inner {
    /**
     * 내적
     * */

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        int result = solution(a,b);
        System.out.println("result=>"+result);
    }

    public static int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0 ; i < a.length; i++){
            answer+= a[i] * b[i];
        }
        return answer;
    }
}
