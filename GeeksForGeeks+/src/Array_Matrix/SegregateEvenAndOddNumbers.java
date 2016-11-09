package Array_Matrix;

public class SegregateEvenAndOddNumbers {

	public int[] segregate(int[] arr){
		int l = 0;
		int r = arr.length-1;
		int temp = 0;
		
		while(l < r){
		
			while((arr[l]%2 == 0) && l < r) l++;		
			while((arr[r]%2 != 0) && l < r) r--;
			
			if(l < r){
				temp = arr[r];
				arr[r] = arr[l];
				arr[l] = temp;
				l++;
				r--;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		SegregateEvenAndOddNumbers obj = new SegregateEvenAndOddNumbers();
		int[] arr = {1, 4, 45, 5, 10, 8};
		arr = obj.segregate(arr);
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i]+",");
		}
	}
}
