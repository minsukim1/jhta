package data.vo;

// 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수.
// ex _ s = a234 false  1234 = true
// s = 1이상8이하
public class cccc {

	public static void main(String[] args) {
	
		Solution sol = new Solution();
		boolean a1 = sol.solution("aaaa");
		boolean a2 = sol.solution("1234");
		boolean a3 = sol.solution("6464");
		boolean a4 = sol.solution("64651");
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
}
}
class Solution {
	public boolean solution(String s) {
		if(s.length()!=4 && s.length()!=6) {
			return false;
		}
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}
}

