package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListTest1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		// 1 ~ 10까지의 숫자를 랜덤하게 10개 담으세요
		for(int i=0; i<11; i++) {
			Random r = new Random();
			list.add(r.nextInt(10)+1);
		}
//		list.add(10);
//		list.add(20);
//		list.add(30);
		list.add(5, 100);
		list.remove(5);
		for(int data:list) {
			System.out.println(data);
		}
	}

}
