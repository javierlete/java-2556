
public class ArraysEjemplo {
	public static void main(String[] args) {
		int[] arr = new int[3];

		//Java5
		for(int dato: arr) {
			System.out.println(dato);
		}
		
		arr[0] = 1;
		arr[1] = 3;
		arr[2] = 5;
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
