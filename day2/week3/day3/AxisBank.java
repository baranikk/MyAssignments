package week3.day3;
public class AxisBank extends BankInfo {

public void openFdAC() //Overriding the same method from the parent class
{
	System.out.println("Opening Fixed Deposit");
	System.out.println("Axis Bank:FD minium duration -6 months");
}
public static void main(String[] args) {
	AxisBank axis=new AxisBank();
	axis.openSavingsAC();
	axis.openCurrentAC();
	axis.openFdAC();//overridden method
}
}