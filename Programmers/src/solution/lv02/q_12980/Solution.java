package solution.lv02.q_12980;

public class Solution {
	
    public int solution(int n) {
    	
        int battery = 0;
        
        while(true) {
        	
        	if(n == 2) { // 2는 1칸 이동 후 순간이동
        		battery++;
        		break;
        		
        	} else if(n == 1) { // 1칸만 이동
        		return 1;
        		
        	} else if(n%2 == 0) { // 순간이동 - 건전지 사용X
        		n /= 2;
        		
        	} else { // 1칸이동 - 건전지 1만큼 사용
        		n -= 1;
        		battery++;
        	}
        	
        }

        return battery;
    }
    
}
