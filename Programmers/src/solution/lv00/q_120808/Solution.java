package solution.lv00.q_120808;

import java.util.ArrayList;


class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        
        
        // 분자
        int numer = (numer1 * denom2) + (numer2 * denom1); 
        
        // 분자의 약수 
        ArrayList<Integer> numerDivisor = new ArrayList<Integer>();
        for(int i = 2; i <= numer; i++) {
        	if(numer%i == 0) {
        		numerDivisor.add(i);
        	}
        }
       
      
        
        System.out.println();
        
        // 분모
        int denom = denom1 * denom2;
        
        // 분모의 약수
        ArrayList<Integer> denomDivisor = new ArrayList<Integer>();
        for(int i = 2; i <= denom; i++) {
        	if(denom%i == 0) {
        		denomDivisor.add(i);
        	}
        }
        
        // 분모와 분자의 최대공약수 
        int maxDivisor = 1;
        for(int i = 0; i < numerDivisor.size(); i++) {
        	for(int j = 0; j < denomDivisor.size(); j++) {
        		if( numerDivisor.get(i).equals( denomDivisor.get(j) ) ) {
        			maxDivisor = numerDivisor.get(i);
        		}
        	}
        }
        
        // System.out.println("최대 공약수 : " + maxDivisor);
        
        numer /= maxDivisor;
        denom /= maxDivisor;
        
        answer = new int[] {numer, denom};
        
        
        return answer;
    }
}
 