package solution.lv02.q_42885;

import java.util.Arrays;

class Solution {
	
    public int solution(int[] people, int limit) {
    	
        int answer = 0;
        
        Arrays.sort(people);
        
        int leftIdx = 0;
        int RightIdx = people.length - 1;
        int count = 0;
        
        while(true) {
        	
        	if(leftIdx > RightIdx) {
        		break;
        	}
        	
        	if( people[leftIdx] + people[RightIdx] <= limit) {
        		leftIdx++;
        		RightIdx--;
        		count++;
        	} else {
        		RightIdx--;
        		count++;
        	}
        }
        
        answer = count;
        
        return answer;
    }
    
}