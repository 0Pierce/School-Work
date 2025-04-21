package Whenever;

public class RomanNums {
	
	
	public static void main (String[] args) {
		
		//1994
		System.out.println(	convertNumeral("XII"));
		
		
		//M   CM       XC90       IV4
		
	}
	
	
	public static int convertNumeral(String s) {
		int ans = 0;
		String numeral = s.toUpperCase();
		for(int i =0; i < numeral.length(); i++) {
			
			if(numeral.charAt(i)=='M') {
				ans += 1000;
				
			}else if(numeral.charAt(i)== 'D') {
				ans+= 500;
				
			}else if(numeral.charAt(i)=='C') {
				ans+= 100;
				
			}else if(numeral.charAt(i)=='L') {
				ans+=50;
				
			}
			else if(numeral.charAt(i)=='X') {
				ans+=10;
				
			}
			else if(numeral.charAt(i)=='V') {
				ans+=5;
			}
			else if(numeral.charAt(i)=='I') {
				
				
				if(i+1 < numeral.length() && numeral.charAt(i+1) != 'I') {
					ans-=1;
				}else {
					ans+=1;
				}
				
			}
			
		}
		
		return ans;
		
	}
	
	


}
