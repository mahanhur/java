package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListTest2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		// 1~10까지의 숫자를 20개 입력한다.
		//단 while 문을 이용한다.
		
		Random r = new Random();
		int i = 0;
		while(i<20) {
			i = list.size();
			list.add(r.nextInt(10)+1);
//			i++;
		}
		System.out.println(list.size());
		for(int data:list)
		System.out.println(data);
	}

}
