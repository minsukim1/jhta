package oop11;

public class HTAListDemo {

	public static void main(String[] args) {
		HTAList list = new HTAList();
		
		// 값을 저장함
		list.add("홍길동");
		list.add("김유신");
		list.add("강감찬");
		list.add("이순신");
		list.add("류관순");
		
		// 값 꺼내기
		HTAIterator hta = list.iterator();
		String value1 = hta.next();
		boolean hasValue1 = hta.hasNext();
		System.out.println(value1 + ", "+ hasValue1);
		String value2 = hta.next();
		boolean hasValue2 = hta.hasNext();
		System.out.println(value2 + ", "+ hasValue2);
		String value3 = hta.next();
		boolean hasValue3 = hta.hasNext();
		System.out.println(value3 + ", "+ hasValue3);
		String value4 = hta.next();
		boolean hasValue4 = hta.hasNext();
		System.out.println(value4 + ", "+ hasValue4);
		String value5 = hta.next();
		boolean hasValue5 = hta.hasNext();
		System.out.println(value5 + ", "+ hasValue5);
	}
}
