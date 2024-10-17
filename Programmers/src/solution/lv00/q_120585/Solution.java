package solution.lv00.q_120585;

import java.util.Arrays;

class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        
        Arrays.sort(array);
        // System.out.println(Arrays.toString(array));
        
        for(int i = array.length - 1; i >= 0; i--) {
        	if(array[i] > height) {
        		answer++;
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
}