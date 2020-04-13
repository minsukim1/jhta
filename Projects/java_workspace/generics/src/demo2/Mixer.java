package demo2;

public class Mixer {

	public static <T extends Fruit> void mix(FruitBox<T> box) {
		int size = box.size();
		for (int i=0; i<size; i++) {
			T t = box.get(i);
			System.out.println(t.toString()+"를 믹싱합니다.");
		}
		System.out.println();
	}
	
	public static <T> void mix2(FruitBox<? extends T> box) {
		int size = box.size();
		for (int i=0; i<size; i++) {
			T t = (T) box.get(i);
			System.out.println(t.toString());
		}
		System.out.println();
	}
}
