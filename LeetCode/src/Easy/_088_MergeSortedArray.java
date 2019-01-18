package Easy;
/*
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class _088_MergeSortedArray {

	 public void merge(int a[], int m, int b[], int n){
        
	int mplusn = m+n, i = m-1,j = mplusn-1,k = 0;;
		if(a.length < mplusn) return;
		while(i >= 0){
			a[j] = a[i];
			j--;
			i--;
		}
		i = 0;j++;
		while(j < mplusn && k < n){
		
			if(a[j] < b[k]){
				a[i] = a[j];
				j++;
			}
			else if(a[j] > b[k]){
				a[i] = b[k];
				k++;
			}
			else{
				a[i] = a[j];
				i++;
				j++;
				a[i] = b[k];
				k++;
				System.out.println(a[i]);
			}
			i++;
		}
		while(j < mplusn){
			a[i] = a[j];
			i++;j++;
		}
		while(k < n){
			a[i] = b[k];
			i++;k++;
		}
	}

	public static void main(String[] args) {
		_088_MergeSortedArray obj = new _088_MergeSortedArray();
		int a[] = {0,0,0};
		int[] b = {2,5,6};
		obj.merge(a,0,b,3);
		for(int i = 0;i < a.length;i++)	System.out.print(a[i]+",");
	}
}
