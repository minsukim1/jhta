package demo2;

public class GradeDemo {
	// 열겨형의 주요 메소드

	// String name()
	// 열거형 상수의 이름을 문자열로 반환한다.
	public static void main(String[] args) {
		String name = Grade.VIP.name();
		System.out.println(name);

		int no1 = Grade.VIP.ordinal();
		int no2 = Grade.GOLD.ordinal();
		int no3 = Grade.SILVER.ordinal();
		int no4 = Grade.BRONZE.ordinal();
		
		System.out.println(Grade.VIP + " " + no1);
		System.out.println(Grade.GOLD + " " + no2);
		System.out.println(Grade.SILVER + " " + no3);
		System.out.println(Grade.BRONZE + " " + no4);
		
		// static T valueOf(Class<T> enumType, String name)
		// 지정된 열거형 타입에서 이름에 해당하는 문자열 상수를 반환한다.
		Grade grade = Enum.valueOf(Grade.class,"VIP");
		System.out.println(grade.name()+", "+grade.ordinal());
	}
}
