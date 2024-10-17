package solution.lv00.q_181866;

import java.util.Arrays;

class Solution {
    public String[] solution(String myString) {
        String[] answer = {};
        
        answer = myString.split("x");
        
        int count = 0; // x 문자열 개수
        for(int i = 0; i < answer.length; i++) {
        	if(answer[i].equals("")) {
        		count++;
        	}
        }
        // System.out.println(count);
        
        String[] result = new String[answer.length - count];
        
        for(int i = 0; i < answer.length; i++) {  // 공백이 아닌 answer의 요소만 result에 넣기
        	if(answer[i].equals("")) {
        		continue;
        	}
        	for(int j = 0; j < result.length; j++) {
        		if(result[j] == null) {
        			result[j] = answer[i];
        			break;
         		} 
        	}
        }
        
        Arrays.sort(result, 0, result.length);
        
        answer = result;
        
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
}


