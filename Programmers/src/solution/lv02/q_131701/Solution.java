package solution.lv02.q_131701;

import java.util.HashSet;
import java.util.Set;

class Solution {
	
    public int solution(int[] elements) {
    	
        int answer = 0;
        
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i = 1; i <= elements.length; i++) {
        	
        	// i : 연속 부분 수열 길이
        	for(int j = 0; j < elements.length; j++) {
        		
        		int sum = 0;
        		
        		for(int k = j; k < j + i; k++) {
        			if(k >= elements.length) {
        				sum += elements[k - elements.length];
        			} else {
        				sum += elements[k];
        			}
        		}
        		
        		set.add(sum);
        	}
        	
        }
        
        answer = set.size();
        
        return answer;
    }
    
}