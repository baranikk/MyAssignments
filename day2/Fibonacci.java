package week1.day2;

public class Fibonacci {

	public static void main(String[] args) {
		
		int range=8;
		int num1=0;
		int num2=1;
		int i,sum;
		
		System.out.println(num1);
		System.out.println(num2);
		for(i=2;i<range;i++)
		{
			sum=num1+ num2;
			System.out.println(sum);
			num1=num2;
			num2=sum;
		}
		}
		
		
}
