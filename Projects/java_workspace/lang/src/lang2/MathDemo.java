package lang2;

import static java.lang.Math.round; // 반올림
import static java.lang.Math.rint;  // 가장 가까운 정수형
import static java.lang.Math.floor; // 버림
import static java.lang.Math.ceil;  // 올림
public class MathDemo {

	public static void main(String[] args) {
		
		System.out.println(round(-1.8)+", "+ round(-1.9)+", "+round(1.2)+ ", "+round(1.8));
		System.out.println(rint(-1.8)+", "+ rint(-1.9)+", "+rint(1.2)+ ", "+rint(1.8));
		System.out.println(floor(-1.8)+", "+ floor(-1.9)+", "+floor(1.2)+ ", "+floor(1.8));
		System.out.println(ceil(-1.8)+", "+ ceil(-1.9)+", "+ceil(1.2)+ ", "+ceil(1.8));
	}
}
