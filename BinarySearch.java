package algorithms;
import java.util.Scanner;
public class BinarySearch {
	public static int BinarySearchelements(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		while(left <= right)
		{
			int mid = left + (right - left)/2;
			if(target>array[mid]) {left=mid+1;}
			else if (target == array[mid]) {return mid;}
			else {right= mid-1;}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size of the array");
		int n= scanner.nextInt();
		int[] array = new int[n];
		System.out.println("Enter the elements in an array");
		for (int i = 0; i<n;i++) { array[i]=scanner.nextInt();}
		for(int i = 0; i<n; i++) {
			for (int j=i+1; j<n;j++) { // use recursion to reduce the time complexity
				if(array[i]>array[j]) {
				int temp = array[i];
				array[i]=array[j];
				array[j]=temp;			
				}
			}
		}
		for (int i = 0; i<n;i++) { System.out.println(array[i]);}
		System.out.println("Enter target to find");
		int target = scanner.nextInt();
		int index = BinarySearchelements(array,target);
		if(index == -1) System.out.println("Target doesn't exist in the array");
		else System.out.println("Target found at " +index);
		scanner.close();
	}
}
