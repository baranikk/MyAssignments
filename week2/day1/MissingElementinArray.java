package week2.day1;

import java.util.Arrays;

public class MissingElementinArray {

	public static void main(String[] args) {
		
		int[] arr= {1,2,3,4,7,6,8};
		
		for(int i=0;i<arr.length;i++)
	
		{
			Arrays.sort(arr);

			{
			
			if(arr[i]!=i+1)
			{
				System.out.println("The Missing number is:");
				System.out.println(i+1);
			    break;
			}
			}
			
		}

	}

}
