package number1;

import java.text.DecimalFormat;

public class NumberFormatDemo {

	public static void main(String[] args) {
		
		double number = 1234567.89;
		
		// DecimalFormat
		// 숫자를 지정된 형식의 텍스트로 변환한다.
		
		DecimalFormat df = new DecimalFormat("#,###.###");
		String text = df.format(number);
		System.out.println(text);
		
		/*
		 *  "0"				1234568
		 *  "#"				1234568
		 *  "000000000"		0001234568
		 *  "#########"		1234568
		 *  "0.0"			1234567.9
		 *  "#.#"			1234567.9
		 *  "0.000"			1234567.890
		 *  "#.###"			1234567.89
		 *  "0,000"			1,234,568
		 *  "#,###"			1,234,568
		 *  "0,000.000"		1,234,567.890
		 *  "#,###.###"		1,234,567.89
		 */
	}
}
/*
 * 	기호				의미			설명
 * -------------------------------------
 * 	0				숫자			해당위치에 숫자 없어도 0을 표시한다.
 * 	#				숫자			해당위치에 숫자가 없으면 표시하지 않는다.
 * 	.				소숫점
 * 	,				단위구분자
 * 
 * DecimalFormat
 * 		숫자를 지정한 형식의 텍스트로 변환
 * 		String format(double number)
 * 		String format(long number)
 * 
 * 		지정된 형식의 텍스트를 숫자로 변환
 * 		Number format(String text)
 * 
 * 	String과 Interger, Long, Double
 * 		정수나 실수를 문자열로 반환하기
 * 		String.valueOf(int number)
 * 		String.valueOf(long number)
 * 		String.valueOf(double)
 * 
 * 		텍스트를 숫자로 변환하기(* 텍스트에 숫자 아닌 내용이 포함되어 있으면 오류 발생)
 * 		int Integer.parseInt(String text)
 * 		long Long.parseLong(String text)
 * 		double Double.parseDouble(String text)
 */
