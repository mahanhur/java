package array;

public class P102 {

	public static void main(String[] args) {
		
//		int arr[] = new int[3];
//		int []arr = new int[3];
//		
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
		
		int arr[] = {10, 20, 30};
		System.out.println(arr);
		
		//배열의 구성을 보고싶은 경우
		for(int i = 0; i<arr.length;i++) {
			System.out.printf("%d \t", arr[i]);
		}
		
		//배열의 구성을 보고싶은 경우2
		System.out.println("\n Type 2 ");
		for(int data:arr) {
			System.out.printf("%d \t", data);
		}
	}

}
