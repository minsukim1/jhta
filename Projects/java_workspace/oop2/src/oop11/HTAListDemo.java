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
		boolean hasValue1 = hta.hasNext();
		String value1 = hta.next();
		System.out.println(hasValue1 + ", "+ value1);
		
		boolean hasValue2 = hta.hasNext();
		String value2 = hta.next();
		System.out.println(hasValue2 + ", "+ value2);
		
		boolean hasValue3 = hta.hasNext();	
		String value3 = hta.next();
		System.out.println(hasValue3 + ", "+ value3);

		boolean hasValue4 = hta.hasNext();
		String value4 = hta.next();
		System.out.println(hasValue4 + ", "+ value4);

		boolean hasValue5 = hta.hasNext();
		String value5 = hta.next();
		System.out.println(hasValue5 + ", "+ value5);
		
		boolean hasValue6 = hta.hasNext();
		System.out.println(hasValue6);
//		while(hta.hasNext()) {
//			boolean hasValue = hta.hasNext();
//			String value = hta.next();
//			System.out.println(hasValue + ", "+ value);
//		}
	}
}
