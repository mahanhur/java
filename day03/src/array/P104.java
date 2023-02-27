package array;

import java.util.Arrays;
import java.util.Random;

public class P104 {

	public static void main(String[] args) {
		
		int arr[] = new int[10];
		Random r = new Random();
		
		//data 심기(난수)
		for(int i = 0; i<arr.length;i++) {
//			int data = r.nextInt(99)+1;
//			arr[i] = data;
			arr[i] = r.nextInt(99)+1;
		}
		
		//출력
		for(int a:arr) {
			System.out.printf("%d \t", a);
		}
		
		//출력2
		System.out.println(Arrays.toString(arr));
		
		//Q.배열의 합과 평균을 구하시오
		int sum = 0;
		double avg = 0;
		
//		for(int i = 0; i<arr.length;i++) {
//			sum += arr[i];
//		}
		
		for(int A:arr) {
			sum += A;
		}
		
		avg = sum / (arr.length * 1.0);
		
		System.out.printf("합: %d , 평균: %4.2f", sum, avg);
		
	}

}
