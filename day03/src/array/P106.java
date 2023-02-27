package array;

import java.util.Arrays;
import java.util.Random;

public class P106 {

	public static void main(String[] args) {
		
		int arr[] = new int[5];
		Random r = new Random();
		
		//data 심기(난수)
		for(int i = 0; i<arr.length;i++) {
			arr[i] = r.nextInt(9)+1;
		}
		
		//출력2
		System.out.println(Arrays.toString(arr));
		
		//Q.배열의 합과 평균을 구하시오
		//Q2.홀수 번째의 합과 평균을 구하시오
		
		int sum = 0;
		double avg = 0.0;
		int cnt = 0;
		
		for(int i=0;i<arr.length;i++) {
			if(i%2 == 0) {
			sum += arr[i];
			cnt++;
			}
		}
		
		avg = sum / (cnt*1.0);
		
		System.out.printf("합:%d, 평균:%4.2f",sum,avg);

	}

}
