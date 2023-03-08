package set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetTest1 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		//1~10까지의 숫자를 10개 입력하세요
		Random r = new Random();
//		for(int i=0;i<10;i++) {
//			set.add(r.nextInt(10)+1);
//		}
		//이렇게는 불가
		
		while(set.size()<20) {
			set.add(r.nextInt(10)+1);
		}
		
		System.out.println(set.size());
		System.out.println("--");
		for (int data : set) {
			System.out.println(data);
		}
	}

}
